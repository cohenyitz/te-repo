<template>
    <form v-on:submit.prevent="handleFilter"> <!-- when the form button is clicked, run the handleFilter function -->
        <input type="text" placeholder="Filter on..." v-model="searchText"><button>Filter</button>
    </form>
</template>

<script>
export default {
    name: 'search-bar',
    data() {
        return {
            searchText: ''
        };
    },
    methods: {
        handleFilter() {                            // handle the form submit button click
            this.$emit('paul', this.searchText);  // fire a filter event sending the data in searchText
        // $emit - fire a custom event (programmer defined event) sending optional data with it
        // $emit(event-name, optional-data-to-send)  
        }
    }
}
</script>

<style scoped>

form {
    display: flex;
    justify-content: flex-end;
    padding: 0.5em;
}

form * {
    padding: 0.5em;
    margin: 1em;
}

form input {
    flex: 2;
    font-size: 1em;
}

form button {
    width: 20%;
}

</style>
