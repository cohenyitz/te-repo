// This is our Vue DATA STORE
// It contains data shared across components in the page

import Vue from 'vue'         // give me access to Vue
import Vuex from 'vuex'       // give me access to Vuex

Vue.use(Vuex)                 // Tell Vue we want to use Vuex plug-in
                              // plug-in is a feature not part of tool that may be added

export default new Vuex.Store({   // Defining the Vuex Data Store to be shared
  // All data that used to be in the single ProductReview component is now in the Vuex data store
  state: {                        // Where all data properties to be shared are placed
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
  // One of the rules for Vuex any changes to the shared data (state) should only be done by mutations
  mutations: {        // The functions (mutations) that will change the properties in State
    // By convention, mutations function names are coded in all uppercase
    ADD_REVIEW(state, review) {               // Add a review to our array of reviews in state
      state.reviews.unshift(review);          // add a review to start of array
    },
    UPDATE_FILTER(state, newValue) {            // set the filter property value in state
      state.filter = newValue;                  // change filter property to value passed in as argument
    },
    FLIP_FAVORITED(state, reviewToChange) {   // set the favorited property of a review in the array in state
      reviewToChange.favorited = ! reviewToChange.favorited;
    }
  },
  actions: {
  },
  modules: {
  },
  strict: true    // enforce the rule that only mutations can change the state of Data Store
                  //      throw an exception if anything other than a mutation attempts to change data store
})
