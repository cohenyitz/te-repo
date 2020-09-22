/* eslint-disable */ 

<!-- This will dispay the details for a hoterl -->
<!-- 1. Get the hotel to be displayed          -->
<!-- 2. Include the hotel detail data in page  -->
<template>
  <div>
    <h1>{{ hotel.name }} Details</h1>
    <p>{{ hotel.address.city }}</p>
    <p> {{ hotel.address.state }} </p>
    <div>
      <router-link to="/">Return to Home</router-link>
    </div>
  </div>
</template>
<script>
import HotelService from "@/services/HotelServices";
export default {
  name: "hotel-detail",
  data() {
    return {
      hotel: {}  // hold the hotel whose details we are displaying
    };
  },
  created() {
    // get the hotel whose details are to be displayed
    // We have two ways to get a specific hotel
    // 1. we can get it from the Data Store: this.$store.state.hotels.filter()
    //      Pro: we already have the data from the API
    //      Con: if the details have since we got the data we have changes

    // 2. we can call the API to get a single hotel
    //      a. Add a service to make the API call
    //      b. Call the service to get the hotel
    //      c. copy the ata from API reponse to our hotel property
    //      Pro: we get the most upt to date info
    //      Con: we are doing an API call, which takes time
    HotelService.getHotel(this.$route.params.id)
      .then(response => {
        this.hotel = response.data;
      })
      .catch(error => {
        //Error handling for API Call
        if (error.response) {
          this.errorMsg =
            "Error submitting new board. Response received was '" +
            error.response.statusText +
            "'.";
        } else if (error.request) {
          this.errorMsg =
            "Error submitting new board. Server could not be reached.";
        } else {
          this.errorMsg =
            "Error submitting new board. Request could not be created.";
        }
        this.isLoading = false;
      });
  }
};
</script>
<style scoped>
</style>