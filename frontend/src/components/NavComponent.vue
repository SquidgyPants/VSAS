<script setup lang="ts">


import router from "../router.ts";

function NavigateToHome() {
  router.push(`/`);
}
</script>


<template>
  <body>
  <div>
    <b-navbar style="background-color: #04498F;  background: linear-gradient(to bottom, #1F85C7, #04498F);" toggleable="lg">
      <b-navbar-brand @click="NavigateToHome">V/SAS</b-navbar-brand>

      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

      <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav>
          <b-nav-item :to="`/shipment`">Bestellingen</b-nav-item>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
  </div>


</body>
</template>
<style scoped>
  b-navbar {
    width: 100%;
    display: flex;
  }

</style>
