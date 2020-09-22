const name = 'Cigar Parties for Dummies';
let description = 'Host and plan the perfect cigar party for all of your squirrelly friends.';
let reviews = [
  {
    reviewer: 'Malcolm Gladwell',
    title: 'What a book!',
    review:
      "It certainly is a book. I mean, I can see that. Pages kept together with glue (I hope that's glue) and there's writing on it, in some language.",
    rating: 3
  }
];

/**
 * Add our product name to the page title
 * Get our page page title by the id and the query the .name selector
 * once you have the element you can add the product name to the span.
 */
function setPageTitle() {
  const pageTitle = document.getElementById('page-title');
  pageTitle.querySelector('.name').innerHTML = name;
}

/**
 * Add our product description to the page.
 */
function setPageDescription() {
  document.querySelector('.description').innerHTML = description;
}

/**
 * I will display all of the reviews in the reviews array
 */
function displayReviews() {
  if ('content' in document.createElement('template')) {
    reviews.forEach((review) => {
      displayReview(review);
    });
  } else {
    console.error('Your browser does not support templates');
  }
}

/**
 *
 * @param {Object} review The review to display
 */
//
// Code to add a review to teh DOM from the array of reviews in this JavaScript
//
function displayReview(review) {     // Receiving an array of review objects as a parameter
  // get a reference to the element containing the reviews on the page
  const main = document.getElementById('main');

  // create a copy of the template in the html called 'review-template' and give me a reference to it
  const tmpl = document.getElementById('review-template').content.cloneNode(true);

  tmpl.querySelector('h4').innerText = review.reviewer;  // Find the h4 element in the template and set it's text to the reviewer
  tmpl.querySelector('h3').innerText = review.title;     // Find teh h3 element in the template and set it;' text to the title
  tmpl.querySelector('p').innerText = review.review;     // Find the p element in the template and set it's text to the review
  // there will always be 1 star because it is a part of the template so we add on star less that rating indicates
  for (let i = 1; i < review.rating; i++) {
    const img = tmpl.querySelector('img').cloneNode();   // Copy the template img element
    tmpl.querySelector('.rating').appendChild(img);      // find the element with class='rating' and and the new img element
  }
  main.appendChild(tmpl);                                // Add the elements in the template to page
}

// LECTURE STARTS HERE ---------------------------------------------------------------

// Wait to run the DOM manipulation functions until we are sure the DOM created successfully
// add a DOMContentLoaded event listener to the document
//       addEventListener(event-to-listen-for, event-handler-function)
document.addEventListener('DOMContentLoaded' , () => {  // When the DOM is fully created run the anon-func
                                                      setPageTitle();  // set the product reviews page title
                                                      setPageDescription(); // set the product reviews page description
                                                      displayReviews();  // display all of the product reviews on our page
                                                     })
/**
 * Take an event on the description and swap out the description for a text box.
 *
 * @param {Event} event the event object
 */
const desc = document.querySelector('.description'); // Get a reference to element with class='description'
desc.addEventListener('click', (event) => {
  // event-object.target is the element that fired the event
  toggleDescriptionEdit(event.target); // Call the function to show the input box passing it the element
                                       //       element that fired the event (the description on the page)
} )

const inputDesc = document.getElementById('inputDesc'); // Get a reference to input box for new description
inputDesc.addEventListener('keyup', (event)=> {         // When the user releases a key in the input box
    if(event.key === 'Enter') {                  // If the user pressed the Enter key
        exitDescriptionEdit(event.target,true)   //     Call the function to exit box telling it to save input
    }
    if(event.key === 'Escape') {                 // if the user pressed Escape key
      exitDescriptionEdit(event.target,false)    //     Call the function to exit box telling it to not save input
    }
})
//
// Show/Hide form when Add Review is click
//
const btnToggleForm = document.getElementById('btnToggleForm');  // Get a reference to add review button
btnToggleForm.addEventListener('click', (event) => {   
      showHideForm();           // Run function to show/hide form
})

const btnSaveReview = document.getElementById('btnSaveReview'); // Get reference to the Save Review button
btnSaveReview.addEventListener('click', (event) => {
  event.preventDefault();   // Stop the default behavior of a submit button on a form 
  saveReview();             // run the function to save the review in our data source (array in the tis code)
})

// This will "toggle the input box editing"
// If we pass this function the element with class='description', 
//           the next sibling is the input box we want to use to enter the new description
function toggleDescriptionEdit(desc) {      // Receive an element from html
  const textBox = desc.nextElementSibling;  // Get a reference to the next sibling of the element passed
  textBox.value = description;              // Initializes the textBox to original description
  // .classlist represents the set of classes assigned to an element - what's in class= for an element
  textBox.classList.remove('d-none');       // Change the class of the textBox so it displays
  desc.classList.add('d-none');             // Add the class to element passed to hide it
  textBox.focus();                          // Put the cursor in the textBox 
}

/**
 * Take an event on the text box and set the description to the contents
 * of the text box and then hide the text box and show the description.
 *
 * @param {Event} event the event object
 * @param {Boolean} save should we save the description text
 */
//
// Function will save the new description entered by the user
//
function exitDescriptionEdit(textBox, save) {  // Receive the element with the new description, request
  let desc = textBox.previousElementSibling;   // get reference to textBox's previous sibling
  if (save) {                                  // if the request was to save was true
    desc.innerText = textBox.value;            //      copy the data from the textBox passed to it's previous sibling
  }
  textBox.classList.add('d-none');             // Hide the textBox passed to us
  desc.classList.remove('d-none');             // Show the previous sibling 
}

/**
 * I will show / hide the add review form
 */
function showHideForm() {
  const form = document.querySelector('form');
  const btn = document.getElementById('btnToggleForm');

  if (form.classList.contains('d-none')) {    // If the form is hidden
    form.classList.remove('d-none');          //      show it
    btn.innerText = 'Hide Form';              //      change the button text
    document.getElementById('name').focus();  //      put the cursor in the form id='name'
  } else {                                    // if the form is not hidden (it's showing)
    resetFormValues();                        //      call the function to reset values
    form.classList.add('d-none');             //      hide it
    btn.innerText = 'Add Review';             //      change the button text
  }
}

/**
 * I will reset all of the values in the form.
 */
function resetFormValues() {                    // Reset the form fields to default values
  const form = document.querySelector('form');  // Get a reference to the form
  const inputs = form.querySelectorAll('input');// Get references to all form input controls and put in an array
  inputs.forEach((input) => {                   // Loop through the array of input fields 
    input.value = '';                           //      setting them to empty
  });
  document.getElementById('rating').value = 1;
  document.getElementById('review').value = '';
}

/**
 * I will save the review that was added using the add review from
 */
function saveReview() {  // Save the data from the form into an object and add object to our array
  const name = document.getElementById('name');       // Get a reference to name field in the form 
  const title = document.getElementById('title');     // Get a reference to title field in the form
  const rating = document.getElementById('rating');   // Get a reference to rating field in the form
  const review = document.getElementById('review');   // Get a reference to review field in the form

  const newReview= {    // new object to add to array with form data
    reviewer: name.value,      // assign data from name in to form to reviewer
    title   : title.value,     // Get a reference to title field in the form
    rating  : rating.value,    // Get a reference to rating field in the form
    review  : review.value     // Get a reference to review field in the form
  }
  reviews.push(newReview);     // Add the newReview to our array
  displayReview(newReview);    // Call function to add the review to the page
  showHideForm();              // Hide the form
}
