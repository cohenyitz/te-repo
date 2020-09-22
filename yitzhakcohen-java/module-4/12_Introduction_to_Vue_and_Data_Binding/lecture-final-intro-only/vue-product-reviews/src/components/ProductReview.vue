<!-- The HTML for the component      -->
<template>
     <div class="main">
         <!-- data used in the HTML, but defined in the elsewhere is -->
         <!-- coded inside {{ }} - mustache expression               -->
         <h2>Product Reviews for {{productName}}</h2>
         <p class='description'>{{description}}</p>
     </div>
</template>

<!-- The JavaScript for the component -->
<script>

// export allows the sharing of JavaScript data between Vue components 
// export exposes data from this component to outside processes
// default is a special when all you have is one object to share
export default {  // A JavaScript object to share with other components
    name: 'product-review', // name of the component this export belongs to
                            // note the name:  lower-case with a - between parts
                            // Vue component filename is ProductReview
                            // The component name is the filename in lower-case with a - between the words
    data() { // the data() function is called by vue when data is requested by the component
        return {  // return this object to Vue when it asks for data for this component
            productName : 'Cigar Parties for Dummies',
            description : 'Host and plan the perfect cigar party for all your squirelly friends',
            reviews: [  // Data to be displayed by our component on the page
                {
                reviewer: "Malcolm Gladwell",
                title: 'What a book!',
                review: "It certainly is a book. I mean, I can see that. Pages kept together with glue and there's writing on it, in some language.",
                rating: 3,
		        favorite: false
                },
                {
                reviewer: "Craig Castelaz",
                title: 'Better than a swift kick in the butt!',
                review: "My bar is low.",
                rating: 4,
		        favorite: false
                }
        ]
        }  // end of return
    }  // end of data function     
}  // end of export
</script>
<!-- The CSS for the component       -->
<style scoped> /* scoped says only the this CSS to this component                */
               /* without scoped the CSS would be applied to the entire page     */
               /* which could change styling other components or css has applied */
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