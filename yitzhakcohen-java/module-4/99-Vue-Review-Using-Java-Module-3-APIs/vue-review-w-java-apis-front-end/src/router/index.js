import Vue          from "vue";
import VueRouter    from "vue-router";
import Home         from "../views/Home.vue";
import HotelDetail  from "../views/HotelDetail.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home
  },
  {
    path: "/hotels/:id",
    name: "HotelDetail",
    component: HotelDetail
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
