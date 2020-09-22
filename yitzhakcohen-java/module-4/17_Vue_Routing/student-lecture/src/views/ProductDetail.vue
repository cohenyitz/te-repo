<template>
  <div id="app" class="main">
      <h1>{{product.name}}</h1>
      <p class="description">{{product.description}}</p>
      <div class="actions">
          <router-link v-bind:to="{name: 'products'}">Back to Products</router-link>&nbsp;
          <router-link v-bind:to="{name: 'add-review', params: {id: product.id}}">Add Review</router-link>
      </div>

      <div class="well-display">    <!-- display count of each rating -->
          <average-summary/>
          <star-summary rating="1"/>
          <star-summary rating="2"/>
          <star-summary rating="3"/>
          <star-summary rating="4"/>
          <star-summary rating="5"/>  
      </div>
      <review-list/>                <!--list the reviews for the products-->
  </div>
</template>

<script>
import AverageSummary from '@/components/AverageSummary.vue'
import StarSummary from '@/components/StarSummary.vue'
import ReviewList from '@/components/ReviewList.vue'

export default {
    name: 'product-detail',
    components: {
        AverageSummary,
        StarSummary,
        ReviewList
    },
    computed: {
        product() {         // Retireve the data from the data store for product selected
        // retrieve the product data from the data store for id selected
        //          products in the data store is an array of objets
        //          each object has a unique id
        //          find the object in the array with the id we want
        //          we can use the array .find() method to locate product object we want 
        //              like most array functions, find loops through the array sending an element 
        //              to an anonymos functions or a single statement
        //              .find((element-name) => {}) or .find(element-name => statement-that-uses-the-elment-name) 
        // $store.state.products gives us access to the products array in the data store
        // We need to determine the id of the product selected by the user
        //          the data store has a property called activeProduct that contains the id of the product
        //                          ($store.state.activeProducts)
            return this.$store.state.products.find(aProduct => aProduct.id === this.$store.state.activeProduct) 
        }, // end of product()
    }, //end of computed
    // Since the id of the product slected is in the path variable (/product/id)
    // we need to copy the value from the path variable to activeProduct property 
    // in data store using a data store mutaion to set it 
    // The created() lifecycle hook gives us an opportunity to do something before the page is rendered
    //      the html is injected into the DOM. ie. We need to know the id right away
    // We need to generate the html for the product before the html is added to the DOM
    created() { // Provides processing at the created() lifecycle hook to copy id from pat variable
        // $route.params gives us access to parh variable (like @PathVariable in Spring MVC)
        const selectedProductId = this.$route.params.id;    // Get the path variable from the route called id
        this.$store.commit("SET_ACTIVE_PRODUCT", selectedProductId) // Set the activeProduct id in the data store
    }
   
}
</script>

<style>

</style>