import {createRouter, createWebHistory} from "vue-router";
import HelloWorld from "./components/HelloWorld.vue";
import ShipmentComponent from "./components/ShipmentComponent.vue";
import SelectedShipment from "./components/SelectedShipment.vue";

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
    },
    {
        path:"/SelectedShipment/:noticolid",
        name:"SelectedShipment",
        component: SelectedShipment,
    }
    ];

const router = createRouter({
    history: createWebHistory(),
    routes: links,
})

export default router;