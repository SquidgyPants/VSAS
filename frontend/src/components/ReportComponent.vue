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

onMounted(() => {
  fetchSelectedShipment()
})
</script>

<template>

</template>

<style scoped>

</style>