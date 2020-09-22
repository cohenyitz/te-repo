<!-- This is the start-up page for a Vue application -->
<!-- Should be called App.vue                        -->
<!-- HTML for the this page -->
<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">
    <!-- Vue components are used like any other tag in HTML -->
    <ProductReview></ProductReview>    <!-- added our component to the page -->
    <HelloWorld msg="Welcome to Your Vue.js App"/> 
    <Yitz/>
  </div>
</template>

<script>
// import our Vue component file into the page
// paths are relative to the src folder
import HelloWorld    from './components/HelloWorld.vue'
import ProductReview from './components/ProductReview.vue'
import Yitz          from './components/Yitz.vue'

export default {
  name: 'App',
  components: {   /* List of components (file name) used in the page */
    Yitz,
    ProductReview,
    HelloWorld
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
