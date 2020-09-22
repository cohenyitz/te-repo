//****************************************************************************************************
// Identify and define global variables (used by multiple functions) at the top of the program
//****************************************************************************************************
const PROBLEMS_PER_SET = 10;  // Number problems in a set 
                              //   change this to modify the number of problems presented to user
let score = 0;          // the number of correct answers so far
let currentProblem = 1; // The problem the user has currently display
let problemSet = [];    // The set of problems to be presented to the user and the answer choices

//****************************************************************************************************
// When page first loads...
//
//     1. Add event listener answerSet being displayed and score it
//     2. Add event listener to start over button
//     3. Display 1st problem when page loads
//****************************************************************************************************
document.addEventListener('DOMContentLoaded', () => {
    // Get an array of references to all the list items for the answers
    let answerListItems = document.querySelectorAll('#answers ul li');

    // Loop through the array of list items to add 'click' event and score answer
        answerListItems.forEach((anAnswer) => {
            anAnswer.addEventListener('click', (eventObj) => {
                const answer = parseInt(eventObj.currentTarget.innerText); // Convert the chosen answer to an int
                const correctAnswer = parseInt(problemSet[currentProblem-1].problem.answer);
                 if (answer === correctAnswer) {  // if chosen answer equals correct answer
                     updateScore();               //      updateScore()  
                    }
                 nextProblem();                   // Display next problem          
                });
    }) ;
    document.getElementById('btnStartOver').addEventListener('click',() => {
      startNewProblemSet();
    })
    startNewProblemSet();             // display the new problemSet   
});
//****************************************************************************************************
// Generate and array PROBLEMS_PER_SET random problems
// A problem contains: left operand, right operator, operator, answers 
//****************************************************************************************************
function generateProblemSet() {
for (let i=0; i < PROBLEMS_PER_SET; i++) {
    // Define and initialize a problem object
    const problem = {
        left:  getRandomNumber(10),  // Set the left operand to 0 through 9
        operator: '*',
        right: getRandomNumber(10),  // Set the right operand to 0 through 9
        answer: null                 // We don't know the answer yet due to random operands
    }
    // Calculate the correct answer and store it in the problem
    const correctAnswer = problem.left * problem.right; // Calculate correct answer
    problem.answer = correctAnswer;

    // Define array to hold answerSet
    let answerSet = [];
    do {
        // Create a shuffled array containing the correct answer and 3 random answers
        answerSet = shuffleArray([correctAnswer, getRandomNumber(82), getRandomNumber(82), getRandomNumber(82)]);
        }
    while(checkForDuplicates(answerSet));  // Loop until no duplicates in answerSet
    
    // Add the problem and answerSet to the problemSet
    // As a set of objects (ie. each array element holds a problem and an answerSet)
    problemSet.push({problem, answerSet}); 
}
}
//****************************************************************************************************
// Display a problem on the page - called from multiple places (page load, next problem)
//****************************************************************************************************
function displayProblem() {
    // Add the problem to the DOM
    const problemElement = document.getElementById('problem');
    // currentProblem starts at 1 (to count the problems like a human) - so we do -1 to get the index
    const theProblemExpression = `${problemSet[currentProblem-1].problem.left} ${problemSet[currentProblem-1].problem.operator} ${problemSet[currentProblem-1].problem.right}`
    problemElement.querySelector('div').innerText = theProblemExpression;
}
//****************************************************************************************************
// Display the answer choices in the page
//****************************************************************************************************
function displayAnswers(){
    const answersElement = document.getElementById('answers');        // Get reference to element with answers
    const listWithAnswers = answersElement.querySelector('ul');       // Get reference to list of answers
    const allAnswersInList = listWithAnswers.querySelectorAll('li');  // Get reference to all the list items in the list
   
    for(let i=0; i < problemSet[currentProblem-1].answerSet.length; i++){
        allAnswersInList[i].innerText = problemSet[currentProblem-1].answerSet[i];
    }
}
//****************************************************************************************************
// Display problem set - problem and answers
//****************************************************************************************************
function displayProblemSet() {
    displayProblem();
    displayAnswers();
}
//****************************************************************************************************
// Display the next problem when the the button is clicked
//****************************************************************************************************
function nextProblem() {
    // Only move to next problem if there are more problems to display
    if (currentProblem < PROBLEMS_PER_SET) {
        updateCurrentProblem();  // Increment problem number and re-display
        displayProblem();        // Display the new problem
        displayAnswers();        // Display answers for new problem
    }
    else {
        toggleShowHide();        // Hide all problem elements so only results show
        }
}
//****************************************************************************************************
// Advance the problem number and display new problem number
//****************************************************************************************************
function updateCurrentProblem() {
    currentProblem++;  // Increment current problem counter
    // update element containing problem number (class='currentProblem') on the page
    document.querySelector('.currentProblem').innerText = currentProblem;  
}
//****************************************************************************************************
// Keep track of the score (# of correct answers)
//****************************************************************************************************
function updateScore() {
    score++;     // increment score
    // update element containing (class='currentScore') on the page
    document.querySelector('.currentScore').innerText = score; 
}
//****************************************************************************************************
// Reset score to 0 if they start over
//****************************************************************************************************
function clearScore() {
    // Set element on the page with class='currentScore' to 0
    document.querySelector('.currentScore').innerText = 0;
}
//****************************************************************************************************
// Show problem elements if hidden, hide them if showing
//****************************************************************************************************
function toggleShowHide() {
    // Get an array of references to all elements with class='show-hide'
    const elementsToBeToggled = document.querySelectorAll('.show-hide');
    // use .toggle method to toggle hidden attribute
    // to use .toggle - .toggle(token, condition)
    //        if condition is true, token is added to target
    //        if condition is false, token is removed from target
    //
    // if final problem was just answered, hide all problem information in the page
    elementsToBeToggled.forEach((anElement) => {
        anElement.classList.toggle('hidden', currentProblem == PROBLEMS_PER_SET);
    });
}
//****************************************************************************************************
// Start a new problem set and display the first problem of the set
//****************************************************************************************************
function startNewProblemSet() {
    // if user is already in a problemSet, reset all values to initial settings
    if (currentProblem > 1) {
        problemSet = [];        // empty problemSet
        currentProblem = 0;     // reset current problem
        score = 0;              // reset score
        toggleShowHide();       // Hide all problem information on page
        updateCurrentProblem(); // Reset currentProblem to 1
        clearScore();           // Set displayed score to current value of score
    }
    generateProblemSet();       // Generate new problemSet
    displayProblemSet();        // Display new problemSet
}




/****************************************************************************************************
 * Utility / Helper functions  
 ****************************************************************************************************/
/**
 * Incorrect answers must not be the correct answer or duplicated
 * @param {array}
 * @returns{boolean} - indicates if array contains any duplicates
 * 
*/
function checkForDuplicates(array) {
    // a Set does not allow duplicates 
    // converting the array to a Set should result in the same number of elements in both
    // if there are no duplicates in the array
    // Return if the Set size not equal array size indicating there were duplicates in the array
    return new Set(array).size !== array.length 
  }
 /**
* Utility function to generate a random number based on max
* @param {number} max - the highest value to generate + 1
*                       if you want value between 0 and 9  - max=10
*                       if you want value between 0 and 21 - max=22
*                       if you want value between 0 and 81 - max=81
*/
function getRandomNumber(max) {
    // Math.random() generates a decimal value between 0 and 1
    return Math.floor(Math.random() * Math.floor(max));
    }
//****************************************************************************************************
/**
Utility function to shuffle the items in an array
@param {object} arr
*/
function shuffleArray(arr) {
    // Use a compare function to tell sort how two elements compare
    // Two elements are passed to the function by sort
    // The function returns a value indicating the relationship of first elem to second
    //              if first elem is less than the second    - returns a negative value
    //              if first elem is equal to  the second    - returns a zero
    //              if first elem is greater than the second - returns positive values
    // Sort calls this function until the function indicates all elements are ascending order
    // Use a calculation with a random number in the return of function to randomize the array
    return arr.sort(function (a, b) { return Math.random() - 0.5 })
    }
    //**************************************************************************************************

