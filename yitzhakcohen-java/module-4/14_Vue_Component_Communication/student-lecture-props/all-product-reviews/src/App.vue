<template>
  <div id="app">
    <!--        v-on:event="function-to-be-run"    -->
    <search-bar v-on:filter="filterEventFired" />   <!-- when the filter event is fired, run the handleFilter method -->
                                                <!-- the filter event is fired from the searchBar component      -->
    <!-- include the ProductReview.vue tag in our page              -->
    <!-- and provide values for two of the props in product reviews -->
    <!-- name property to be assigned the string value              -->
    <!-- description property to be assigned a string value         -->
    <product-review
      name="Cigar Parties for Dummies"
      description="Host and plan the perfect cigar party for all of your squirrelly friends."
      v-bind:filterText="filter"
       />
    <!-- include the ProductReview.vue tag in our page              -->
    <!-- and provide values for two of the props in product reviews -->
    <!-- name property to be assigned the string value              -->
    <!-- description property to be assigned a string value         -->
    <!-- v-bind:filterText="filter" connect the filter properti in the component -->
    <!--                             to the filterText property in productReview-->
    <product-review
      name="Tech Elevator Bootcamp Extravaganza"
      description="14 crazy weeks of fun and coding with an emphasis on the coding"
      v-bind:filterText="filter"
       />
  </div>
</template>

<script>
import ProductReview from './components/ProductReview.vue';
import SearchBar from './components/SearchBar.vue';

export default {
  name: 'app',
  components: {
    ProductReview,
    SearchBar
  },
  data() {                            // prperties for this component
    return {
      filter: ''                      // hold the text from the searchBar - represents what they are ooking for 
    };
  },
  methods: {
    filterEventFired(filterText) {    // handle the filter event from searchBar
      this.filter = filterText;       // any data passed when the event is automatically passed to the function by v-on
                                      // filterText is the name we give to the data passed with the  event
                                      // assign the data from the evnt to our property called filter
    }
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

#app div.main {
  display: inline-block;
  width: 45%;
  padding: 1em;
  border: 1px black solid;
  border-radius: 5px;
  margin: 0 1em;
  vertical-align: top;
}
</style>
