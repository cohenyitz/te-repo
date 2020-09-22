<template>
  <div class="card">
    <!-- put the book title in h2 here-->
    <h2>{{book.title}}</h2>
    <!-- Please leave <img> commented out until directed to remove open and close comment tags in the README. -->
    <img v-if="book.isbn" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'" />
    <!-- put the author with h3 here -->
    <h3>{{book.author}}</h3>
    <!-- add a button to mark it read/unread -->
    <button v-on:click.prevent="onReadChange(book)" v-bind:class="[book.read ? 'mark-read' : 'mark-unread' ]">{{book.read === false ? "Mark Read" : "Mark Unread"}} </button>
    <!--    the button needds to say read/unerad depending on current read status -->
    <!--                            a class needs to be added depending on read status-->
    <!--            if current is read, the butto should be marked "unread"-->
    <!--            if current in not reawd, the button should be marked "read" -->
    <!-- if the book status is read, it needs a cleass read added to the div -->
    <!-- because the book properties are in Vuex Data Store, we need a mutation to --> 
    <!--            set the read status -->
  </div>
</template>

<script>
export default {
    name: 'book-card',
    props: {            // data whose values come from outside this component
        book:Object     // we are goin to an object called book 
    },
    methods: {
        onReadChange(book) {
            this.$store.commit("FLIP_READ", book);
        }

    }
     
}
</script>

<style>
.card {
    border: 2px solid black;
    border-radius: 10px;
    width: 250px;
    height: 550px;
    margin: 20px;
}

.card.read {
    background-color: lightgray;
}
.card.unread {
    background-color: white;
}
.card .book-title {
    font-size: 1.5rem;
}

.card .book-author {
    font-size: 1rem;
}
</style>