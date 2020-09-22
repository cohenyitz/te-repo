<template>
  <div>
    <h1>My Kanban Boards</h1>
    <div class="boards">
      <div class="loading" v-if="isLoading">              <!-- if page being loaded -->
        <img src="../assets/ping_pong_loader.gif" />      <!-- include this image   -->
      </div>
      <div
        class="board"
        v-for="board in boards"
        v-bind:key="board.id"
        v-bind:style="{ 'background-color': board.backgroundColor }"
        v-else
      >
        <router-link :to="{ name: 'Board', params: { id: board.id } }">
          {{ board.title }}
        </router-link>
      </div>
    </div>
  </div>
</template>

<script>
// import the file with the services we want to use
// a service is a JavaScript program called from this page rather than coding it in this page
// Services can be share amongst many components  - Code reusability / loosely coupled
import boardsService from '../services/BoardService'; // Access the BoardServices

export default {
  data() {
    return {
      boards: [],         // Hold the data to be processed in this component
      isLoading: true     // indicates whter the page s in the process of being loaded 
    };
  },
  created() {             // When this component begins processing and before its displayed
    // .then after an API call is how you wait for promise to be completed
    //        you specify waht you want to do when the API call is done on the .then
    boardsService.getBoards()                       // Call the service to load the data
      .then(response => {                           // Wait for call to finish then send the response data to anon-function
                  this.boards = response.data;      //    copy the data from the HTTP response to our variables
                  this.isLoading = false;           //    indicate page is no longer being loaded 
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
