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
  try {
    isLoading.value = true;
    selectedShipment.value = await client.getShipmentById(route.params.noticol as string);
    console.log("Selected Shipment:", selectedShipment.value);
  } catch (err) {
    console.error("Error fetching selected shipment:", err);
  }
  finally {
    isLoading.value = false;
  }
};

onMounted(() => {
  fetchSelectedShipment();  
})

</script>

<template>
  <div v-if="isLoading">Loading teams...</div>
  <div v-else-if="error">Error: {{ error.message }}</div>
  <ul v-else id="ul">
    <li v-bind="selectedShipment">
      <b-card>
        <b-card>
          <li v-for="item in selectedShipment.handlingUnit?.deliveries">
          <div id="inline-flex-div" style="padding: 0;">
            <p>{{item.orderNumber}}</p>
            <p>{{item.itemNumber}}</p>
            <p>{{item.length}}</p>
            <p>{{item.width}}</p>
            <p>{{item.breadth}}</p>
            <p>{{item.weight}}</p>
            <p>{{item.volume}}</p>
          </div>
          </li>
        </b-card>
      </b-card>
    </li>
  </ul>


</template>

<style scoped>
#ul {
  padding: 0;
  list-style-type: none;
}
</style>