import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Board from '../views/Board.vue'
import Card from '../views/Card.vue'
import AddCard from '../views/AddCard.vue'
import EditCard from '../views/EditCard.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/board/:id',
    name: 'Board',
    component: Board
  },
  {
    path: '/board/:boardID/card/:cardID',
    name: 'Card',
    component: Card
  },
  // These paths were added for today's lecture
  {
    //     /board/a-value/card/create
    path: '/board/:boardID/card/create',  // a URL the router will recognize
    name: 'AddCard',                      // name for the path
    component: AddCard                    // router view associated with the path]
  },
  {
    path: '/board/:boardID/card/:cardID/edit',
    name: 'EditCard',
    component: EditCard
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
