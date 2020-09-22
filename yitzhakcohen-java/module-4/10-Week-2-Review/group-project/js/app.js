const PROBLEM_PER_SET = 10; // Number of problems in a set
                            //    change this to modify tge number of problems presented to user
let score = 0;              // The number of correct answers so far
let currentProblem = 1;     // The problem the user has current displayed 
let problemSet = [];        // The set of problems to be presented to user

// Generate an array of PROBLEM_PER_SET random problem
// A problem contains: left operand, right operand, operator, 4 answers
for (let i = 0; i < PROBLEM_PER_SET; i++) {
    // Define and initialize a problem object
    const problem = {
        left: getRandomNumber(10),  // Set the left operand to 0 through 9
        operand: '*',
        right: getRandomNumber(10), // Set the right operand to 0 through 9
        answer: null               // We don't know the answer yet due to random operands
    }
    // Calculate the correct answer ans store in problem
    const correctAnswer = problem.left * problem.right; // calculate correct answer 
    problem.answer = correctAnswer;

    // Create a shuffled array containing the correct answer and 3 random answers
    let answerSet = shuffleArray([correctAnswer, getRandomNumber(82), getRandomNumber(82), getRandomNumber(82)]);

    // Add the problem and answerSet to problemSet
    problemSet.push({problem, answerSet})
}

// Display a problem on the page - called from multiple places (page load, next problem)

function displayProblem() {
    // Add the problem to the DOM
    const problemElement = document.getElementById('problem');
    // currentProblem start at 1 (to count the problems like a human) - so we do -1 to get the index
    const theProblemExpression = `${problemSet[currentProblem -1].problem.left} ${problemSet[currentProblem -1].problem.operand} ${problemSet[currentProblem -1].problem.right}`
    problemElement.querySelector('div').innerText = theProblemExpression;
}

// Display 1st problem when page loads
document.addEventListener('DOMContentLoaded', () =>  {
    displayProblem();
})


/**
 * Utility function to generate a random number based on max
 * @param {number} max - the highest value to generate +1
 *                       if you want a value between 0 and 9 - max=10
 */
function getRandomNumber(max) {
    // Math.random()
    return Math.floor(Math.random() * Math.floor(max));
    }


/**
 * Utility function to shuffle the items in an array
 * @param {object} arr
 */
function shuffleArray(arr) {
    // Use a compare function to tell sort how two elements compare
    // Two elements are passed into the function by sort
    // The function returns a value indicating the relationship of first elem to second
    //              if the first elem is less than the second    - returns negative value
    //              if the first elem is equal to the  second    - returns a zero
    //              if the first elem is greater than the second - returns a positive value
    // Sort calls this function until the function indicates all the elements are ascending order
    // Use a calculation with a random number in the return of function to randomize the 
    return arr.sort(function(a,b){ return Math.random() -0.5})
}