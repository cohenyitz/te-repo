// This is the index.js for the router 

import Vue            from 'vue'              // Access Vue stuff
import VueRouter      from 'vue-router'       // Access the Vue Router stuff
import Products       from '@/views/Products' // Access Products.vue stuff
import ProductDetail  from '@/views/ProductDetail' // Access ProductDetail.vue stuff

Vue.use(VueRouter)   // Tell Vue we are using the Vue router

// Array of router route information
const routes = [     // Associate URL paths to router view (similar to @RequestMapping in Java Spring MVC)
     {                      // An object with the properties related to the path/view
      path: '/',            // The URL path to be associated with a router view
      name: 'products',     // name for this path/view combination
      component: Products  // view router component associated with the path
     },
     // Set up paths for URL path /products/id  where id is id of line displayed
     // This an example of a dynamic path - a path determined when its used (id is a variable)
     {
       path:  'product/:id',    // for URL /products/1  or /products/2 etc
       name:  'product-detail',  // name for this path/view combination
       component: ProductDetail  // view router component associated with the path
     }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
