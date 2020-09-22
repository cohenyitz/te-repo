<template>
  <div class="book-container">
    <!-- add the BookCard component tag -->
    <!-- generate one BookCard tag for each book in the array -->
    <!-- the book array is in the Vue Data Store -->
    <!-- we need pass the current book to the book-card tag -->
    <book-card v-for="book in $store.state.books" v-bind:key="book.title" v-bind:book="book"></book-card>
  </div>
</template>

<script>
import BookCard from './BookCard'
export default {
//import BookCard component vue file
  
    name: 'reading-list',
    // add a componenet property to specify that your using a BookCard
  components: {
    BookCard
  }
}
</script>

<style>
.book-container {
    display:flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
}
</style>