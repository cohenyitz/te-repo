<template>
  <div>
    <h1>My Kanban Boards</h1>
    <div class="boards">
      <div class="loading" v-if="isLoading">          <!-- if page being loaded -->
        <img src="../assets/ping_pong_loader.gif" />  <!-- include this image as a loading indicator  -->
      </div>
      <div
        class="board"
        v-for="board in boards"
        v-bind:key="board.id"
        v-bind:style="{ 'background-color': board.backgroundColor }"
        v-else
      >
      <!-- router-link sets up a link to a router view -->
      <!-- when this click this item on the page       -->
      <!-- go to the path named 'Board' and send it the board-id as a path variable -->
        <router-link :to="{ name: 'Board', params: { id: board.id } }">
          {{ board.title }}
        </router-link>
      </div>
    </div>
  </div>
</template>

<script>
// import the file with the services we want to use
// a Service is a JavaScript program called from this page rather tham coding it in this page
// Services can be shared between many components - Code reusablity / loosely coupled
import boardsService from '../services/BoardService';  // Access the BoardService stuff

export default {
  data() {
    return {
      boards: [],        // Hold the data to be processed in this component
      isLoading: true    // indicate whether the page is in the process of being loaded
    };
  },
  created() {    // When this component begins processing and before it's displayed
    // .then after an API call is how you wait for promise to be completed
    //       your specify what what you want to do when the API call is done on the .then
    boardsService.getBoards()         // Call the service to load the data - service is doing an API call
      .then(response => {             // wait for call to finish then send the response data to anon-function
                        this.boards = response.data;    //    copy the data from the HTTP response to our variable
                        this.isLoading = false;         //    indicate page is no longer being loaded
                        });
  }
};
</script>

<style scoped>
.boards {
  display: flex;
  justify-content: space-between;
  align-items: center;
}
.board {
  background-color: #f7fafc;
  border-radius: 10px;
  padding: 40px;
  flex: 1;
  margin: 0 20px;
  text-align: center;
}
.loading {
  flex: 3;
}
.board a:link,
.board a:visited {
  color: rgb(243, 243, 243);
  text-decoration: none;
}
</style>
