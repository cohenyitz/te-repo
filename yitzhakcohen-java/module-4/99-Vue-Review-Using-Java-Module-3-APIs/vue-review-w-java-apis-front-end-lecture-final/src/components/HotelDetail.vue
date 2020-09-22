<!-- This will display the details for a hotel -->
<!-- 1. Get the hotel to be displayed.         -->
<!-- 2. Include the hotel detail data in page  -->

<template>
    <div>
        <h1>{{ hotel.name }} Details</h1>

         <p>{{ hotel.address.city}}</p>
         <p>{{ hotel.address.state}}</p>
        <div>
           <router-link to="/">Return to Home</router-link>
        </div> 
    </div>
         
</template>
<script>
//                        @=root folder (src)
import KarolsExcellentHotelMethods from "@/services/HotelServices"
export default {
    name: "hotel-detail",
       data() {
        return {
            hotel: {}                    
        }   // End of return for data()
    },  // End of data()
    created() {  // get the hotel whose details are to be displayed
    // We have two ways to get a specific hotel:
    //
    //   1. We can get it from the Data Store: this.$store.state.hotels.filter
    //      Pro: we already have the data from the API - so no API call overhead
    //      Con: if the details have changed since got the data we don't have change  
    //
    //   2. We can call the API to get a single hotel
    //      a. Add a service to make the API call
    //      b. Call the service to get the hotel
    //      c. Copy the data from API response to our hotel property
    //      Pro: We get the most up to date information
    //      Con: We are doing an API call, which takes time
    //
    // The vote was to implement option 2

    // Call the service ot get one hotel passing it the id from the URL parh
      KarolsExcellentHotelMethods.getHotel(this.$route.params.id) 
            .then (response => {              // wait for the API call to finis
                  this.hotel = response.data   // copy the data from repsonse to the hotel object in our code
            })
            .catch (error => {      // Error handling for API call
                 if (error.response) {
                     this.errorMsg = "Error submitting new board. Response received was '" + error.response.statusText + "'.";

                    } 
                else 
                if (error.request) {
                    this.errorMsg = "Error submitting new board. Server could not be reached.";

                 } else {
                    this.errorMsg = "Error submitting new board. Request could not be created.";
              }
        this.isLoading = false;
      });
    }
}
</script>
<style scoped>

</style>