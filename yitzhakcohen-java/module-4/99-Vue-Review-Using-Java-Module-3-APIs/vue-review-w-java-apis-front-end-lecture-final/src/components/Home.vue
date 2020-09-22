<template>
  <div id="sideNav">
    <h1>Squirrel Hotel System</h1>
    <div class="hotels">
      <div class="status-message error" v-show="errorMsg !== ''">{{errorMsg}}</div>
      <div class="loading" v-if="isLoading">
        <img src="../assets/animated-squirrel.gif" />
      </div>
      <div>
        <!-- add a router link for each hotel the hotels array of Vuex Data Store  -->
        <!-- list the hotel name as the link - go to HotelDetail view when clicked -->
        <router-link :to="{ name: 'HotelDetail', params: { id: hotel.id } }"
            class="hotel"
            v-for="hotel in this.$store.state.hotels"  
            v-bind:key="hotel.hotelID"
            tag="div"
      >
        {{ hotel.name }}
      </router-link>
      </div>
    </div>
  </div>
</template>

<script>
import HotelService from '../services/HotelServices';

export default {
  name: "home",
  data() {
    return {
      isLoading: true,
      hotels: [],    // hold the hotels we are processing

       /* Start of temporary data for testing purposes */

      hotel : {  
        hotelID: 31952,
        name: "The Squrrel Den"
      },
      /* End of temporary data for testing purposes   */ 
      
       errorMsg: ''
      }   // End of return
  },  // End of data()
  created() {               // This is a Vue lifecyle hook - do this before the page is displayed
    this.retrieveBoards();  //     run the retrieveBoards() method
    this.isLoading = false;
  },
  methods: {
    retrieveBoards() {          // run/call from the created hook
      HotelService.getHotels()  // run/call the HotelService getHotels() function
      .then(response => {       // Wait for Promise from the API call to complete
                         this.$store.commit("SET_HOTELS", response.data);    // call the SET_HOTELS mutation to copy the API date to Data Store
                         this.isLoading = false;                             // indicate we are done
                        })
      .catch (error => {      // Error handling for API call
        if (error.response) {
          this.errorMsg = "Error submitting new board. Response received was '" + error.response.statusText + "'.";

        } else if (error.request) {
          this.errorMsg = "Error submitting new board. Server could not be reached.";

        } else {
          this.errorMsg = "Error submitting new board. Request could not be created.";
        }
        this.isLoading = false;
      });
    }
  }
}
</script>

<style scoped>
div#sideNav {
  height: 100%;
  width: 20%;
  position: fixed;
  z-index: 1;
  left: 0;
  top: 0;
  padding-top: 20px;
  padding-bottom: 20px;
  overflow-x: hidden;
  border-right: solid lightgrey 1px;
}

h1 {
  text-align: center;
}

.boards {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: center;
}
.board {
  color: #f7fafc;
  border-radius: 10px;
  padding: 40px;
  flex: 1;
  margin: 10px;
  text-align: center;
  cursor: pointer;
  width: 60%;
}
.addBoard {
  color: #f7fafc;
  border-radius: 10px;
  background-color: #28a745;
  font-size: 16px;
  width: 60%;
  margin: 10px;
  padding: 20px;
  cursor: pointer;
}
.form-control {
  margin-bottom: 10px;
}
.btn {margin-bottom: 35px;}
.loading {
  flex: 3;
}
.board:hover:not(.router-link-active), .addBoard:hover {
  font-weight: bold;
}
.router-link-active {
  font-weight: bold;
  border: solid blue 5px;
}
</style>