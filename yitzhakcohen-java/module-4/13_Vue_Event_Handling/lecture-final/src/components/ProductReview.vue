<template>
  <div class="main">
    <h2>Product Reviews for {{ name }}</h2>

    <p class="description">{{ description }}</p>

    <div class="well-display">
      <div class="well">
        <span class="amount" v-on:click="filter=0">{{ averageRating }}</span>
        Average Rating
      </div>

      <div class="well">
        <span class="amount" v-on:click="filter=1">{{ numberOfOneStarReviews }}</span>
        <!-- add an 's' at the end of words if there is more than one star -->
        <!-- conditional operator - ? example                              -->
        <!-- format: condition ? result-if-true : result-if-false          -->
        <!-- used here to provide conditional output                       -->
        1 Star Review{{ numberOfOneStarReviews === 1 ? '' : 's' }}
      </div>

      <div class="well">
        <span class="amount" v-on:click="filter=2">{{ numberOfTwoStarReviews }}</span>
        2 Star Review{{ numberOfTwoStarReviews === 1 ? '' : 's' }}
      </div>

      <div class="well">
        <span class="amount" v-on:click="filter=3">{{ numberOfThreeStarReviews }}</span>
        3 Star Review{{ numberOfThreeStarReviews === 1 ? '' : 's' }}
      </div>

      <div class="well">
        <span class="amount" v-on:click="filter=4">{{ numberOfFourStarReviews }}</span>
        4 Star Review{{ numberOfFourStarReviews === 1 ? '' : 's' }}
      </div>

      <div class="well">
        <span class="amount" v-on:click="filter=5">{{ numberOfFiveStarReviews }}</span>
        5 Star Review{{ numberOfFiveStarReviews === 1 ? '' : 's' }}
      </div>
    </div>

    <!-- add a link to the page to show a form for adding a review                  -->
    <!-- v-on will add an event handler to an element                               -->
    <!-- we are adding a click event with the prevent-default option to the link    -->
    <!-- we are providing in-line code for the event handler rather than a function -->
    <!-- When the user clicks the link, set the showForm variable to true           -->
    <!-- v-if controls whether an element is added or removed from the DOM          -->
    <!--     when the v-if condition is true include the element in the DOM         -->
    <!--     when the v-if condition is false remove the element in the DOM         -->
    <!-- if showForm variable is true, this a-tag is removed from the DOM           -->
    <!-- if showForm variable is false, this a-tag is added to the DOM              -->
    <!-- if the form is showing, this link isn't                                    -->
    <a
      id="show-form-button"
      href="#"
      v-on:click.prevent="showForm = true"
      v-if="!showForm"
    >Show Form</a>
    <!-- Use a v-if with the showForm variable to show/hide this form          -->
    <!-- if showForm variable is true, the form displays, if false, it doesn't -->
    <!-- Use v-on to add an click event handler when submit event occurs       -->
    <!--      a submit event occurs when a submit button is clicked            -->
    <!--      prevent the default action for submit                            -->
    <!--      the event handler is a function called addNewReview              -->
    <!--                           v-on:event.modifier="function"              -->
    <form v-if="showForm === true" v-on:submit.prevent="addNewReview">
      <div class="form-element">
        <label for="reviewer">Name:</label>
        <input id="reviewer" type="text" v-model="newReview.reviewer" />
      </div>
      <div class="form-element">
        <label for="title">Title:</label>
        <input id="title" type="text" v-model="newReview.title" />
      </div>
      <div class="form-element">
        <label for="rating">Rating:</label>
        <!-- .number v-model modifier says only accept numeric values in the field -->
        <select id="rating" v-model.number="newReview.rating">
          <option value="1">1 Star</option>
          <option value="2">2 Stars</option>
          <option value="3">3 Stars</option>
          <option value="4">4 Stars</option>
          <option value="5">5 Stars</option>
        </select>
      </div>
      <div class="form-element">
        <label for="review">Review</label>
        <textarea id="review" v-model="newReview.review"></textarea>
      </div>
      <button>Submit</button>
      <!-- Define a cancel button with an click event handler to call resetForm() -->
      <button v-on:click.prevent="resetForm" type="cancel">Cancel</button>
    </form>

    <div
      class="review"
      v-bind:class="{ favorited: review.favorited }"
      v-for="review in filteredReviews()"
      v-bind:key="review.id"
    >
      <h4>{{ review.reviewer }}</h4>
      <div class="rating">
        <img
          src="../assets/star.png"
          v-bind:title="review.rating + ' Star Review'"
          class="ratingStar"
          v-for="n in review.rating"
          v-bind:key="n"
        />
      </div>
      <h3>{{ review.title }}</h3>

      <p>{{ review.review }}</p>

      <p>
        Favorite?
        <input type="checkbox" v-model="review.favorited" />
      </p>
    </div>
  </div>
</template>

<script>
export default {
  name: "product-review",
  data() {
    return {
      name: "Cigar Parties for Dummies",
      description:
        "Host and plan the perfect cigar party for all of your squirrelly friends.",
      showForm: false,  // variable to control whether the form is displayed or not
      filter : 0,       // Control the ratings displayed
      newReview: {},    // object to hold a new review - add properties as it's created
      reviews: [
        {
          reviewer: "Malcolm Gladwell",
          title: "What a book!",
          review:
            "It certainly is a book. I mean, I can see that. Pages kept together with glue and there's writing on it, in some language.",
          rating: 3,
          favorited: false
        },
        {
          reviewer: "Tim Ferriss",
          title: "Had a cigar party started in less than 4 hours.",
          review:
            "It should have been called the four hour cigar party. That's amazing. I have a new idea for muse because of this.",
          rating: 4,
          favorited: false
        },
        {
          reviewer: "Ramit Sethi",
          title: "What every new entrepreneurs needs. A door stop.",
          review:
            "When I sell my courses, I'm always telling people that if a book costs less than $20, they should just buy it. If they only learn one thing from it, it was worth it. Wish I learned something from this book.",
          rating: 1,
          favorited: false
        },
        {
          reviewer: "Gary Vaynerchuk",
          title: "And I thought I could write",
          review:
            "There are a lot of good, solid tips in this book. I don't want to ruin it, but prelighting all the cigars is worth the price of admission alone.",
          rating: 3,
          favorited: false
        }
      ]
    };
  },
  // computed: values are recreated everytime some thing on thepage changes
  computed: {
    averageRating() {
      let sum = this.reviews.reduce((currentSum, review) => {
        return currentSum + review.rating;
      }, 0);
      return sum / this.reviews.length;
    },
    numberOfOneStarReviews() {
      return this.numberOfReviews(this.reviews, 1);
    },
    numberOfTwoStarReviews() {
      return this.numberOfReviews(this.reviews, 2);
    },
    numberOfThreeStarReviews() {
      return this.numberOfReviews(this.reviews, 3);
    },
    numberOfFourStarReviews() {
      return this.numberOfReviews(this.reviews, 4);
    },
    numberOfFiveStarReviews() {
      return this.numberOfReviews(this.reviews, 5);
    }
  },
  // Run only when called - do not forget the 's' on methods - Ask Matt about why
  methods: {
    filteredReviews() {  // return an array of reviews with only the rating 
                         // requested by the filter property
      // .filter - will add an element from the array to a new array if function returns true
      return this.reviews.filter((aReview) => {
        return (this.filter === 0) ? true : (aReview.rating === this.filter)
    
    /* Long-form technique
          if (this.filter === 0) {  // if filter is 0 include element
            return true;
          }
          if (aReview.rating === this.filter) {
            return true
          }
          else {
            return false;
           }
    */
      })

    },
    numberOfReviews(reviews, starType) {  // receiving thr array and ratingvalue we want
      return reviews.reduce((currentCount, review) => {
        // add 1 or 0 to currentCount if the review.rating matches the one we want
         return currentCount + (review.rating === starType ? 1 : 0);
        // alternate techique for adding to current count
        // uses the fact in JavaScript true=1  and false=0 (truthy/falsey concepts)
        // return currentCount + (review.rating === starType);
        //
      }, 0);
    },
    addNewReview() {
      this.reviews.unshift(this.newReview); // Add the new review to the beginning of the array (unshift)
      this.resetForm();                     // Call function to reset the form
    },
    resetForm() {
      this.showForm = false;                // hide the form
      this.newReview = {};                  // reset newReview object to empty
    }
  }
};
</script>

<style scoped>
div.main {
  margin: 1rem 0;
}

div.main div.well-display {
  display: flex;
  justify-content: space-around;
}

div.main div.well-display div.well {
  display: inline-block;
  width: 15%;
  border: 1px black solid;
  border-radius: 6px;
  text-align: center;
  margin: 0.25rem;
}

div.main div.well-display div.well span.amount {
  color: darkslategray;
  display: block;
  font-size: 2.5rem;
}

div.main div.review {
  border: 1px black solid;
  border-radius: 6px;
  padding: 1rem;
  margin: 10px;
}

div.main div.review.favorited {
  background-color: lightyellow;
}

div.main div.review div.rating {
  height: 2rem;
  display: inline-block;
  vertical-align: top;
  margin: 0 0.5rem;
}

div.main div.review div.rating img {
  height: 100%;
}

div.main div.review p {
  margin: 20px;
}

div.main div.review h3 {
  display: inline-block;
}

div.main div.review h4 {
  font-size: 1rem;
}
</style>

