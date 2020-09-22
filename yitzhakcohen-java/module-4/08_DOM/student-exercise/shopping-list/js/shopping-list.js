// add pageTitle
const pageName = 'My Shopping List'
let checkComplete = false;
// add groceries
const groceries = [
  {id: 1, name:'Milk', completed: false},
  {id: 2, name:'Eggs', completed: false},
  {id: 3, name:'Bread', completed: false},
  {id: 4, name:'Chicken', completed: false},
  {id: 5, name:'Wine', completed: false},
  {id: 6, name:'Pasta', completed: false},
  {id: 7, name:'Garlic', completed: false},
  {id: 8, name:'Alfredo', completed: false},
  {id: 9, name:'Parmesan', completed: false},
  {id: 10,name:'Mozzarella', completed: false}
];
/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
  const pageTitle = document.getElementById('title');
  pageTitle.innerText = pageName;
}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
  const groceryList = document.getElementById('groceries');
  groceries.forEach((item) => {
    const li = document.createElement('li');
    li.innerText = item.name;
    /*newList.setAttribute('class', 'groceryList');*/
    
    groceryList.appendChild(li);
  
  }); 
}

/**
 * This function will be called when the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted() {
  const li = document.createElement('li');
  checkComplete = document.createElement('li');
  checkComplete.setAttribute('class','.completed');
  li.appendChild(checkComplete);  
}

setPageTitle();

displayGroceries();

// Don't worry too much about what is going on here, we will cover this when we discuss events.
document.addEventListener('DOMContentLoaded', () => {
  // When the DOM Content has loaded attach a click listener to the button
  const button = document.querySelector('.btn');
  button.addEventListener('click', markCompleted);
});
