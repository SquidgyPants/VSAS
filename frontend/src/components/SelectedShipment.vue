<script setup lang="ts">
import { ref } from 'vue';
import { Client, Shipment } from '../API';
import {onMounted} from "vue";
import {useRoute} from "vue-router";

const route = useRoute();
const isLoading = ref(false);
const client = new Client();
const selectedShipment = ref<Shipment>(null as unknown as Shipment);
const error = ref();

const fetchSelectedShipment = async () => {
  isLoading.value = true;
  try {
    selectedShipment.value = await client.getShipmentById(route.params.noticolid as string);
    console.log("Selected Shipment:", selectedShipment.value);
  } catch (err) {
    console.error("Error fetching selected shipment:", err);
  }
  finally {
    isLoading.value = false;
  }
};

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
          <p>Noticol: {{selectedShipment.noticol}}</p>

          <p v-if="selectedShipment.hazardous">Hazardous: Yes</p>
          <p v-else>Hazardous: No</p>

          <p>Desination: {{selectedShipment.destination}}</p>
          <p>2nd Feedback: {{selectedShipment.actualDate}}</p>
          <p>Status: {{selectedShipment.status}}</p>
        </div>
        <b-card id="hu">
          <h5>Handling Unit Details:</h5>
          <div id="inline-flex-div" style="padding: 0;">
            <p>Type: {{selectedShipment.handlingUnit?.type}}</p>
            <p>Length: {{selectedShipment.handlingUnit?.length}}</p>
            <p>Height: {{selectedShipment.handlingUnit?.height}}</p>
            <p>Breadth: {{selectedShipment.handlingUnit?.breadth}}</p>
            <p>Weight: {{selectedShipment.handlingUnit?.weight}}</p>
            <p>Volume: {{selectedShipment.handlingUnit?.volume}}</p>
          </div>
          <b-card id="delivery" v-for="item in selectedShipment.handlingUnit?.deliveries" :key="item.orderNumber">
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
  <b-button
      id="back-button"
      @click="$router.push(`/shipment`)"
      style="margin-bottom: 5%;"
  >
    Back to Search
  </b-button>


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
</style>