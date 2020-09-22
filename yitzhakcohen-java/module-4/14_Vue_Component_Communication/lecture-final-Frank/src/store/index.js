// This is our Vue Data Store
// It contains data to shared across components in the page

import Vue  from 'vue'      // Give me access to Vue
import Vuex from 'vuex'    // Give me access to Vuex

Vue.use(Vuex)              // Tell Vue we want to use the Vuex plug-in
                           // plug-in is an feature not part of tool that may be added

export default new Vuex.Store({  // Define the Vuex Data Store to be shared
  // All data that used to be in the single ProductReview component is not in the Vuex data store
  state: {         // Where all data properties to be shared are placed
    name: 'Cigar Parties for Dummies',
    description: 'Host and plan the perfect cigar party for all of your squirrelly friends.',
    filter: 0,
    reviews: [
      {
        reviewer: 'Malcolm Gladwell',
        title: 'What a book!',
        review:
          "It certainly is a book. I mean, I can see that. Pages kept together with glue and there's writing on it, in some language.",
        rating: 3,
        favorited: false
      },
      {
        reviewer: 'Tim Ferriss',
        title: 'Had a cigar party started in less than 4 hours.',
        review:
          "It should have been called the four hour cigar party. That's amazing. I have a new idea for muse because of this.",
        rating: 4,
        favorited: false
      },
      {
        reviewer: 'Ramit Sethi',
        title: 'What every new entrepreneurs needs. A door stop.',
        review:
          "When I sell my courses, I'm always telling people that if a book costs less than $20, they should just buy it. If they only learn one thing from it, it was worth it. Wish I learned something from this book.",
        rating: 1,
        favorited: false
      },
      {
        reviewer: 'Gary Vaynerchuk',
        title: 'And I thought I could write',
        review:
          "There are a lot of good, solid tips in this book. I don't want to ruin it, but prelighting all the cigars is worth the price of admission alone.",
        rating: 3,
        favorited: false
      }
    ],
  },
  // One of the rules for Vuex any changes to shared data (state) should only be done by mutations
  mutations: {       // The functions (mutations) that will change the properties in state
    // By convention, mutations function names are coded in all uppercase
    ADD_REVIEW(state, review) {      // Add a review to our array of reviews in state
      state.reviews.unshift(review); // add review to start of array
    },
    UPDATE_FILTER(state, filter) {   // set the filter property value in state
      state.filter = filter;
    },
    FLIP_FAVORITED(state, reviewToChange) {  // set the favorited property of a review in the array in state
      reviewToChange.favorited = ! reviewToChange.favorited;
    }
  },
  actions: {
  },
  modules: {
  },
  strict: true    // enforce the rule that only mutations can change the state of data store
                  //     throw an exception is anything other than a mutation attempts tp change data store
})
