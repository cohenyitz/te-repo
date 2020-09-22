<template>
  <div>
    <h1>{{ card.title }}</h1>
    <p> {{ card.description }}</p>
    <div class="loading" v-if="isLoading">            <!-- if page being loaded -->
        <img src="../assets/ping_pong_loader.gif" />  <!-- include this image as a loading indicator  -->
    </div>
    <comments-list :comments="card.comments" v-else /><!-- if page id done loading, display commnets-->
    <div class="board-actions" v-if="!isLoading">     <!-- if page is not being loaded, display link back to board page -->
      <router-link
        v-bind:to="{ name: 'Board', params: { id: $route.params.boardID } }"
        >Back to Board</router-link
      >
    </div>
  </div>
</template>

<script>
import boardsService from '../services/BoardService'   // Access services in BoardService
import CommentsList  from '@/components/CommentsList'  // Access CommentList.vue component
export default {
  name: "card-detail",
  components: {
    CommentsList
  },
  data() {
    return {
      isLoading: true,
      card : {       // hold card information returned from API call
        title : '',
        description : '',
        status : '',
        comments : []
      }  // end of card
    }  // end of return
    }, // end of data()
    created() {   // WHen the page is loaded and before displayed
    // call getCard service with the boardID and cardID we got passed in the path variables
      boardsService.getCard(this.$route.params.boardID, this.$route.params.cardID) // Call service to call API top get a card
           .then(response => {         // wait for API to finish, then pass the response to a function
                this.card = response;  //      copy the data response to our card
                this.isLoading = false;
           });
    }
  
};
</script>
