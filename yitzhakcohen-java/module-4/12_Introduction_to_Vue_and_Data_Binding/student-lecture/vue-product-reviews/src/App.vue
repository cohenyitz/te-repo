<!-- This is a start up page for a vue application -->
<!-- Should be called App.vue  -->
<!-- HTML for this page-->
<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">
    <!-- Vue components are used like any other tag in HTML-->
    <product-review> </product-review>    <!-- added our component to the page-->
  </div>
</template>

<script>
// import our Vue component file into the page 
// paths are relative to the src folder
import ProductReview from './components/ProductReview.vue'


export default {
  name: 'App',
  components: { /* List of components (file name) used in the page */ 
    ProductReview
   
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
