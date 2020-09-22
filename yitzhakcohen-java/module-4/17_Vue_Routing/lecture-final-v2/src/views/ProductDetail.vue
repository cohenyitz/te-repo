<template>
<div id='app' class='main'>
    <h1>{{ product.name }}</h1>  <!-- get the name for the product selected-->
    <p class='description'>{{product.description}}</p>
    <div class="actions">
        <router-link v-bind:to="{name: 'products'}">Back to Products</router-link>&nbsp;
        <router-link v-bind:to="{name: 'add-review', params: {id: product.id}}">Add ReviewList</router-link>
    </div>
    <div class='well-display'>   <!-- display count of each rating -->
        <average-summary />
        <star-summary rating='1' />
        <star-summary rating='2' />
        <star-summary rating='3' />
        <star-summary rating='4' />
        <star-summary rating='5' />
    </div>
    <review-list />              <!-- list the reviews for the product-->
</div>
</template>
<script>
import AverageSummary from '@/components/AverageSummary.vue'
import StarSummary    from '@/components/StarSummary.vue'
import ReviewList     from '@/components/ReviewList.vue'

export default {
    name:'product-detail',
    components: {
        AverageSummary,
        StarSummary,
        ReviewList
    },
    computed: {
        product() {  // Retrieve the data from the data store for product selected
         // retrieve the product data from the data store for id selected
         //       products in the data store is an array of objects
         //       each object has a unique id
         //       find the object in the array with the id we want 
         //       we can use the array.find() method to locate product object we want
         //           like most array functions, find, loops through the array sending and element
         //           to an anonymous function or a single statement
         //           .find((element-name) => {})
         //           .find(element-name => statement-that-uses-the-element-name)
         // $store.state.products give use access to products array in the data store
         // We need to determine the id of the product selected by the user
         //        The data store have a property called activeProduct that contains the id of the product
         //                   ($store.state.activeProduct)
         
         return  this.$store.state.products.find(aProduct => aProduct.id === this.$store.state.activeProduct);
        },  // end of product()
    }, // end of computed
    // Since the id of the product selected is in as a path variable (/product/id)
    // we need to copy the value from the path variable to activeProduct property 
    // in data store using a data store mutation to set it
    // The created() lifecycle hook gives us an opportunity to do something before the 
    //    the html is injected into the DOM. ie. We need to know the id right away
    // We need to generate the html for the product before the html is added to the DOM
    created() {  // Provide processing at the created() lifecycle hook top copy id from path variable
        // $route.params give us access to path variable (like @PathVariable in Spring MVC)
        const selectedProductId = this.$route.params.yitz; // Get the path variable from the route called id
        this.$store.commit("SET_ACTIVE_PRODUCT", selectedProductId); // Set the activeProductId in the data store
    }
    }
  
        
    

</script>
<style scoped>
</style>