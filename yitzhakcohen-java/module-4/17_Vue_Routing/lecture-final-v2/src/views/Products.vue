<!-- This view will be managed by Vue Router                             -->
<!-- We have to tell the router it is managing this view                 -->
<!-- update the index.js in the router folder to tell it about this view -->
<!-- Vue components are included here instead of App.vue                 -->
<template>
   <div class="products">
       <h1>Products</h1>
       <products-list /> <!-- include the ProductsList.vue component -->
   </div> 
</template>
<script>
//                        @ means root directory of project
import ProductsList from '@/components/ProductsList'; // Access the ProductsList Vue stuff

export default {
    components: {
        ProductsList
    }
}
</script>
<style scoped>
</style>