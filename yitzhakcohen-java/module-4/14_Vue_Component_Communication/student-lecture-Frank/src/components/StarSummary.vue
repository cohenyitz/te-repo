<template>
  <div class="well">
    <span class="amount" v-on:click="updateFilter()">{{ numberOfReviews }}</span>
    {{ rating }} Star Review{{ numberOfReviews === 1 ? '' : 's' }}
  </div>
</template>

<script>
export default {
  name: "star-summary",
  props: ["rating"],  // the value for rating is coming from outside this component 
  methods: {
    updateFilter() {
      // filter is used by each StarReview component
      // filter is shared by multiple components - which is why its in the Vuex data store
      // we need to tell the data store to update the value filter so other components know what it is
      // Use a mutator in the data store to change data in the data store
      // .commit is defined in Vuex to run a mutator
      this.$store.commit("UPDATE_FILTER", parseInt(this.rating));
    }
  },
  computed: {
    numberOfReviews() {
      const reviews = this.$store.state.reviews;    // get access to the reviews array in Vuex data store
      return reviews.reduce((currentCount, review) => {
        return currentCount + (review.rating === parseInt(this.rating) ? 1 : 0);
      }, 0);
    }
  }
};
</script>

