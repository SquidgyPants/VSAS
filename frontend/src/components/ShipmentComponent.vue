<script setup lang="ts">
import {ref} from 'vue';
import { Client, Shipment } from '../API';

const client = new Client();
const result = ref<Shipment[]>([]);
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
    console.log("Shipment:",result);
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
      <p style="margin-left: 0;">Noticol</p>
      <p>Schadelijk</p>
      <p>Eindbestemming</p>
      <p>Datum</p>
      <p>Status</p>
    </h1>
    <ul id="ul">
      <li v-for="item in result" key="item.noticol">
        <b-card style="background-color: #e3e3e3; margin-bottom: 8px; padding: 16px;">
        <div id="inline-flex-div" style="padding: 0;">
          <a :id="noticol" @click="$router.push(`/SelectedShipment/${item.noticol}`)">{{ item.noticol }}</a>
          <p>{{ item.hazardous ? 'Ja' : 'Nee' }}</p>
          <p>{{ item.destination }}</p>
          <p>{{ item.actualDate }}</p>
          <p>{{ item.status }}</p>s
        </div>
        </b-card>
      </li>
    </ul>
  </div>

</template>



<style scoped>
#table-heading {
  padding: 30px;
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
#noticol {
  cursor: pointer;
  color: blue;
  text-decoration: underline;
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
#inline-flex-div {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0;
}
</style>