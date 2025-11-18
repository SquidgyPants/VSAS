import {createRouter, createWebHistory} from "vue-router";
import HelloWorld from "./components/HelloWorld.vue";
import ShipmentComponent from "./components/ShipmentComponent.vue";

const links = [
    {
        path:"/",
        name:"Home",
        component: HelloWorld,
    },
    {
        path:"/shipment",
        name:"Shipment",
        component: ShipmentComponent,
    }
    ];

const router = createRouter({
    history: createWebHistory(),
    routes: links,
})

export default router;