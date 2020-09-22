import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'      // Use router view called Home
import Board from '../views/Board.vue'    // Use router view called Board
import Card from '../views/Card.vue'      // Use router view called Card

Vue.use(VueRouter)

const routes = [                          // Paths & associated views the router is aware of
  {
    //  When the '/' url path is sent to router it will use the Home.vue view
    path: '/',                            // URL
    name: 'Home',                         // Name for the path/view connection
    component: Home                       // Router view associated with path
  },
  {
    path: '/board/:id',
    name: 'Board',
    component: Board
  },
  {
    path: '/board/:boardID/card/:cardID', // two path variables 
    name: 'Card',
    component: Card
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes                                  // name of the p
})

export default router
