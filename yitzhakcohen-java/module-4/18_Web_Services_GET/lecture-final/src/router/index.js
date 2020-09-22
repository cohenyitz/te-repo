import Vue       from 'vue'
import VueRouter from 'vue-router'
import Home      from '../views/Home.vue'   // Use router view called Home
import Board     from '../views/Board.vue'  // Use router view called Board
import Card      from '../views/Card.vue'   // Use router view called Card

Vue.use(VueRouter)

const routes = [  // Paths and associated views teh router is aware of
  {
    //   When the '/' url path is sent to router it will use the Home.vue view
    path: '/',        // URL
    name: 'Home',     // name for the path/view connection
    component: Home   // router view associated with path
  },
  {
    path: '/board/:id',// URL may be used in router-link to indicate this pat
    name: 'Board',     // name that may be used in router-link to indicate this path
    component: Board   // When the path or name is used process Board.vue view
  },
  {//      /board/1492/card/1620
    path: '/board/:boardID/card/:cardID',   // two path variables
    name: 'Card',
    component: Card
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes   // name of path/view association object
})

export default router
