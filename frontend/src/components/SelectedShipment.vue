<script setup lang="ts">
import { ref } from 'vue';
import { Client, Shipment } from '../API';
import {onMounted} from "vue";
import {useRoute} from "vue-router";
import axios from "axios";

const route = useRoute();
const isLoading = ref(false);
const client = new Client();
const selectedShipment = ref<Shipment>(null as unknown as Shipment);
const error = ref();

defineProps({
  noticol: String
})

const fetchSelectedShipment = async () => {
  console.log("Fetching shipment with Noticol:", route.params.noticol);
  isLoading.value = true;
  try {
    selectedShipment.value = await client.getShipmentById(route.params.noticol as string);
    console.log("Selected Shipment:", selectedShipment.value);
  } catch (err) {
    console.error("Error fetching selected shipment:", err);
  }
  finally {
    isLoading.value = false;
  }
};

const exportToExcel = async () => {
  console.log("Exporting to Excel...");
  isLoading.value = true;
  try {
    await client.exportToExcel(selectedShipment.value);
    await downloadExcel();
    console.log("Export to Excel completed.");
  } catch (err) {
    console.error("Error exporting to Excel:", err);
  } finally {
    isLoading.value = false;
  }
};

async function downloadExcel() {
  const response = await fetch("/api/export", {
    method: "GET",
  });

  if (!response.ok) {
    throw new Error("Failed to download file");
  }

  const blob = await response.blob();

  // Parse filename
  // const disposition = response.headers.get("content-disposition") || "";
  // const fileName = getFileName(disposition);
  console.log(response.headers.get("content-disposition"));
  const fileName = response.headers.get("content-disposition") || "report.xlsx";

  // Create temp download link
  const url = window.URL.createObjectURL(blob);
  const link = document.createElement("a");

  link.href = url;
  link.download = fileName;

  document.body.appendChild(link);
  link.click();

  // Cleanup
  link.remove();
  window.URL.revokeObjectURL(url);
}

function getFileName(disposition: string): string {
  // filename*=UTF-8''encoded-name.xlsx
  const utf8 = /filename\*\s*=\s*UTF-8''([^;]+)/i.exec(disposition);
  if (utf8?.[1]) {
    return decodeURIComponent(utf8[1]);
  }

  // filename="something.xlsx"
  const quoted = /filename\s*=\s*"([^"]+)"/i.exec(disposition);
  if (quoted?.[1]) {
    return quoted[1];
  }

  // filename=something.xlsx
  const plain = /filename\s*=\s*([^;]+)/i.exec(disposition);
  if (plain?.[1]) {
    return plain[1];
  }

  return "download.xlsx";
}

onMounted(() => {
  fetchSelectedShipment()
})

</script>

<template>
  <div v-if="isLoading">Loading selected shipment...</div>
  <div v-else-if="error">Error: {{ error.message }}</div>
  <ul v-else id="ul">
    <li v-bind="selectedShipment">
      <b-card id="shipment" style="background-color: #e3e3e3; margin-bottom: 8px; padding: 16px;">
        <div id="inline-flex-div" style="padding: 0;">
          <p>Noticol: {{selectedShipment?.noticol}}</p>

          <p v-if="selectedShipment?.hazardous">VGS: Yes</p>
          <p v-else>VGS: No</p>

          <p>Desination: {{selectedShipment?.destination}}</p>
          <p>2nd Feedback: {{selectedShipment?.actualDate}}</p>
          <p>Status: {{selectedShipment?.status}}</p>
        </div>
        <b-card id="hu">
          <h5>Handling Unit Details:</h5>
          <div id="inline-flex-div" style="padding: 0;">
            <p>Type: {{selectedShipment?.handlingUnit?.type}}</p>
            <p>Length: {{selectedShipment?.handlingUnit?.length}}</p>
            <p>Height: {{selectedShipment?.handlingUnit?.height}}</p>
            <p>Breadth: {{selectedShipment?.handlingUnit?.breadth}}</p>
            <p>Weight: {{selectedShipment?.handlingUnit?.weight}}</p>
            <p>Volume: {{selectedShipment?.handlingUnit?.volume}}</p>
          </div>
          <b-card id="delivery" v-for="item in selectedShipment?.handlingUnit?.deliveries" :key="item.orderNumber">
            <h6>Delivery Item:</h6>
            <div id="inline-flex-div" style="padding: 0;">
              <p>Order Number: {{item.orderNumber}}</p>
              <p>Item Number: {{item.itemNumber}}</p>
              <p>Manufacturer: {{item.manufacturer}}</p>
              <p>Price: {{item.price}}</p>
              <p>QTY: {{item.quantity}}</p>
            </div>
          </b-card>
        </b-card>
      </b-card>
    </li>
  </ul>
  <div id="button-div">
  <b-button
      id="back-button"
      @click="$router.push(`/shipment`)"
      style="margin-bottom: 5%;"
  >
    Back to Search
  </b-button>
  <b-button
    id="export-button"
    @click="exportToExcel()"
    style="margin-bottom: 5%;"
  >
    Export report to Excel
  </b-button>
  </div>


</template>

<style scoped>
#ul {
  padding: 0;
  list-style-type: none;
}
#inline-flex-div {
  display: flex;
  justify-content: space-between;
}
#delivery {
  margin: 0;
  padding: 0;
  background: #bfbfbf;
}
#hu {
  margin: 0;
  padding: 0;
  background-color: #cfcfcf;
}
#export-button {
  background-color: green;
}
#button-div {
  display: flex;
  justify-content: space-between;
  margin: 1%;
}
</style>