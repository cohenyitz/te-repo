<template>
  <div>
      <form class="new-book-form" v-on:submit.prevent="submitBook">
          
          <label for="title">Title</label>
          <input class="title-input" type="text" id="title" v-model="newBook.title"/>

          <label for="author">Author</label>
          <input class="author-input" type="text" id="author" v-model="newBook.author"/>

          
          
          <label for="isbn">ISBN</label>
          <input class="isbn-input" type="number" id="isbn" v-model="newBook.isbn"/>

          <button >Submit</button>
      </form>
      
  </div>
</template>

<script>
export default {
    name: "new-book-form",
    data() {
        return {
            newBook:{
                title: "",
                author:"",
                read: false,
                isbn:"",
            }
        }
    },
    methods: {
        submitBook() {
            this.$store.commit("ADD_BOOK", this.newBook);
            this.newBook = {
                title: '',
                author: '',
                read: false,
                isbn: ''
        };
    }
  }
}
</script>

<style>

</style>