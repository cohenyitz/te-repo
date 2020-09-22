<template>
  <div id="sideNav">
    <h1>My Kanban Boards</h1>
    <div class="boards">
      <div class="status-message error" v-show="errorMsg !== ''">{{errorMsg}}</div>
      <div class="loading" v-if="isLoading">
        <img src="../assets/animated-squirrel.gif" />
      </div>
      <!-- This will displayd if the previou v-if condition is false                     -->
      <!-- v-else follows an element with a v-if and will only display if v-if was false -->
      <!-- generate the following router-link for each board in our data (v-for)         -->
      <!--    only after the page is finished loading (v-else)                           -->
      <router-link :to="{ name: 'Board', params: { id: board.id } }"
        class="board"
        v-for="board in this.$store.state.boards"
        v-bind:key="board.id"
        v-bind:style="{ 'background-color': board.backgroundColor }"
        v-else 
        tag="div"
      >
        {{ board.title }}
      </router-link>
      <!-- display button if page is being loaded and AddBoard view is not showing-->
      <button class="btn addBoard" v-if="!isLoading && !showAddBoard" v-on:click="showAddBoard = !showAddBoard">Add Board</button>
      <form v-if="showAddBoard">
        Board Title:
        <input type="text" class="form-control" v-model="newBoard.title" />
        Background Color:
        <input type="text" class="form-control" v-model="newBoard.backgroundColor" />
        <button class="btn btn-submit" v-on:click="saveNewBoard">Save</button>
        <button class="btn btn-cancel" v-on:click="showAddBoard = !showAddBoard">Cancel</button>
      </form>
    </div>
  </div>
</template>

<script>
import boardsService from '../services/BoardService';

export default {
  data() {
    return {
      isLoading: true,       // true if page is being loaded, false if not
      showAddBoard: false,   // true if AddBoard.vue is showing, false if not
      newBoard: {            // Object to hold data from addNewBoard form
        title: '',
        backgroundColor: this.randomBackgroundColor()
      },
      errorMsg: ''
    };
  },
  created() {
    this.retrieveBoards();
  },
  methods: {
    retrieveBoards() {
      boardsService.getBoards()        // Call the getBoards() function in the services code
               .then(response => {     // Wait for the API call to be done and then...
                                  this.$store.commit("SET_BOARDS", response.data);  // call SET_BOARDS mutation to copy response data to the Data Store
                                  this.isLoading = false;
        // Error checking from API call
        if (this.$route.name == "Home" && response.status === 200 && response.data.length > 0) {
          this.$router.push(`/board/${response.data[0].id}`);
        }
      });
    },
    saveNewBoard() {
       boardsService.addBoard(this.newBoard)     // Call the service to add a board with the newBoard
             .then  (response => {                 // Wait for the API call to complete
             if (response.status === 201) {        // if post was successful
              this.retrieveBoards()                //     Refresh the local copy of the boards from the server
              this.showAddBoard = false            //     Hide the addForm
              this.newBoard = {                    // reset newBoard
                               title : "",
                               backgroundColor : this.randomBackgroundColor
                              }
             }
             })             
             .catch(error => {       // If there is any error... 
             if (error.response) {   // if it was a response error (HTTP error status code)
              this.errorMsg = "there was a response error"
             }
             else {
               if (error.request) {
                 this.errorMsg = "there was a request error"
               }
             }

             })                    
    },
    randomBackgroundColor() {
      return "#" + this.generateHexCode();
    },
    generateHexCode() {
      var bg = Math.floor(Math.random()*16777215).toString(16);
      if (bg.length !== 6) bg = this.generateHexCode();
      return bg;
    }
  }
};
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
