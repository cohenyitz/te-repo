<template>
  <div>
    <div class="loading" v-if="isLoading">              <!-- if page being loaded -->
        <img src="../assets/ping_pong_loader.gif" />      <!-- include this image   -->
      </div>
    <h1>{{card.title}}</h1>
    <p>{{card.description}}</p>
  </div>
</template>

<script>
import boardsService from '../services/BoardService';
export default {
  name: "card-detail",
  data () {
    return {
      isLoading: true,
      card: {
        title: '',
        description: '',
        status: '',
        comments: []
      }// end of card
    } // end of return
  },
     created() { // When the page is loaded and before displayed
    // call getCard sevice with the boardID and cardID we got passed in the path variable
      boardsService.getCard(this.$route.params.boardID, this.$route.params.cardID)
      .then(response => {     // wait for API to finish, then pass the response to a function
        this.card = response; //      copy the data response to our card
      });
    },
};
</script>
