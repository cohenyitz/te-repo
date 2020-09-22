import Vue from 'vue'
import App from './App.vue'
import store from './store'
import router from './router'   // access the Vue Router facilities

Vue.config.productionTip = false

new Vue({   // Create an instance of a Vue app
  store,    //    Use Vuex Data Store
  router,   //    Use the Vue Router
  render: h => h(App)
}).$mount('#app')
