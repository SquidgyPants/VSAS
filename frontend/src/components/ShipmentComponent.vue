<script setup lang="ts">
import {ref} from 'vue';
import { Client } from '../API';
import {useRoute} from 'vue-router';
// import router from "../router.ts";

const route = useRoute();
const client = new Client();
const result = ref([] as any[]);
const isLoading = ref(false);
const error = ref();

const noticol = ref('');
const hazardous = ref(false);
const status = ref('');
const destination = ref('');
const startDate = ref('');
const endDate = ref('');

const fetchShipments = async (
) => {
  isLoading.value = true;
  error.value = null;
  try {
    result.value = await client.searchShipments(noticol.value, hazardous.value, status.value, destination.value, startDate.value, endDate.value);
    console.log("Shipment:",result.value);
  } catch (err) {
    error.value = err;
    console.error("Error fetching shipments:", err);
  } finally {
    isLoading.value = false;
  }
};

</script>

<template>
  <div class="container">
    <form @submit.prevent="fetchShipments">
      Noticol<input type="text" placeholder="Noticol" v-model="noticol"/>
      Schadelijk <input type="checkbox" v-model="hazardous"/>
      Status<input type="text" placeholder="Status" v-model="status"/>
      Bestemming<input type="text" placeholder="Bestemming" v-model="destination"/>
      <br>
      Vanaf:<input id="date" type="date" v-model="startDate"/>
      Tot:<input id="date" type="date" v-model="endDate"/>
    </form>
    <button @click="fetchShipments">Zoeken</button>
  </div>

  <div v-if="isLoading">Bestellingen laden...</div>
  <div v-else-if="error">Error: {{ error.message }}</div>
  <div class="container" v-else style="margin-top: 8px">
    <h1 id="table-heading">
      <p>Noticol</p>
      <p>Schadelijk</p>
      <p>Eindbestemming</p>
      <p>Datum</p>
      <p>Status</p>
    </h1>
    <ul id="ul">
      <li v-for="item in result">
        <div id="inline-flex-div" style="padding: 0;">
          <p style="width: 20%;">{{ item.noticol }}</p>
          <p style="width: 20%;">{{ item.hazardous ? 'Ja' : 'Nee' }}</p>
          <p style="width: 20%;">{{ item.destination }}</p>
          <p style="width: 20%;">{{ new Date(item.date).toLocaleDateString() }}</p>
          <p style="width: 20%;">{{ item.status }}</p>
          <b-button @click="$router.push(`/shipment/${item.id}`)" variant="primary" style="margin-left: 16px;">
            Bekijk
          </b-button>
        </div>
      </li>
    </ul>
  </div>

</template>



<style scoped>
#table-heading {
  padding: 16px;
  margin-top: auto;
  display: flex;
  justify-content: space-between;
  font-size: x-large;
  height: 70px;
  align-items: center;
}
p {
  margin: 0;
  padding: 0;
}
#ul {
  padding: 0;
  list-style-type: none;
}
input {
  margin: 1rem;
  margin-left: 0.5rem;
}
#date {
}
input[type=checkbox]
{
  /* Double-sized Checkboxes */
  -ms-transform: scale(2); /* IE */
  -moz-transform: scale(2); /* FF */
  -webkit-transform: scale(2); /* Safari and Chrome */
  -o-transform: scale(2); /* Opera */
  transform: scale(2);
  padding: 10px;
}
</style>