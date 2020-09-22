/**
 * All named functions will have the function keyword and
 * a name followed by parentheses.
 * 
 * @returns {number} 1
 */
function returnOne() {
  return 1;
}

/**
 * Functions can also take parameters. These are just variables that are filled
 * in by whoever is calling the function.
 * 
 * function parameters are always optional in JavaScript
 *
 * Also, we don't *have* to return anything from the actual function.
 *
 * @param {any} value the value to print to the console
 */
function printToConsole(value) {
  console.log(value);
}

/**
 * Write a function called multiplyTogether that multiplies two numbers together. 
 * But what happens if we don't pass a value in? - result is NaN (Not a Number)
 * What happens if the value is not a number? - no problem as long as it represents a numeric value "1"
 *                                              NaN if either value does not represent a numeric value = "Paul"
 * 
 * @param {number} firstParameter the first parameter to multiply
 * @param {number} secondParameter the second parameter to multiply
 */
function  multiplyTogether(firstParameter, secondParameter) {
   return firstParameter * secondParameter;
}
/**
 * This version makes sure that no parameters are ever missing. If
 * someone calls this function without parameters, we default the
 * values to 0. However, it is impossible in JavaScript to prevent
 * someone from calling this function with data that is not a number.
 * Call this function multiplyNoUndefined
 *
 * @param {number} [firstParameter=0] the first parameter to multiply
 * @param {number} [secondParameter=0] the second parameter to multiply
 */
function  multiplyNoUndefined(firstParameter=0, secondParameter=0) {
  return firstParameter * secondParameter;
}

 
/**
 * Functions can return earlier before the end of the function. This could be useful
 * in circumstances where you may not need to perform additional instructions or have to
 * handle a particular situation.
 * 
 * In this example, if the firstParameter is equal to 0, we return secondParameter times 2.
 * 
 * Observe what's printed to the console in both situations.
 * 
 * @param {number} firstParameter the first parameter
 * @param {number} secondParameter the second parameter
 */
function returnBeforeEnd(firstParameter, secondParameter) {
  console.log("This will always fire.");

  if (firstParameter == 0) {
    console.log("Returning secondParameter times two.");
    return secondParameter * 2;
  }

  //this only runs if firstParameter is NOT 0
  console.log("Returning firstParameter + secondParameter.");
  return firstParameter + secondParameter;
}

/**
 * Scope is defined as where a variable is available to be used.
 *
 * If a variable is declare inside of a block, it will only exist in
 * that block and any block underneath or within it. Once the block that the
 * variable was defined in ends, the variable disappears.
 */
function scopeTest() {
  console.log(`Frank's new friend: ${franksNewFriend}`) // a var variable can be referenced before it is defined
                                                        //     This is why use of var can be confusing                    
  // This variable will always be in scope in this function
  let inScopeInScopeTest = true;   // A variable defined outside any block is global to the function
  var franksNewFriend = "Buddy";
  {
    // this variable lives inside this block and doesn't
    // exist outside of the block
    let scopedToBlock = inScopeInScopeTest;  // A variable defined inside the block is local to the block
    var doNotUseVar = true;                  // Defined inside a block - but available outside the block
                                             //     This is why use of var can be confusing
  }
  console.log(`doNotUseVar=${doNotUseVar}`);

  // scopedToBlock doesn't exist here so an error will be thrown
  if (inScopeInScopeTest && scopedToBlock) {
    console.log("This won't print!");
  }
}
/** JSDoc notation - generate consistent documentation
 * 
 * createSentenceFromUser() - create an English language type sentence
 *                            from information passed in as parameters
 * 
 * @param {string}   name           name of the person we are describing
 * @param {number}   age            age of the person we are description 
 * @param {string[]} listOfQuirks   array of strings containing quirks of the person we are describing
 * @param {string}   separator      string to separate the quirks in our sentence
 * 
 * @returns {string}                the full sentence description of the person      
 * 
 */
//           default empty array for listOfQuirks and default separator is ','
function createSentenceFromUser(name, age, listOfQuirks = [], separator = ', ') {
  // Construct a string containing the person's basic info from the parameters
  let description = `${name} is currently ${age} years old. Their quirks are: `;
  
  // array.join() method will take  the elements in an array and construct a string with the elements
  //                                                             separated by the separator
  return description + listOfQuirks.join(separator);
}

/**
 * Takes an array and, using an anonymous function, generates their sum.
 *
 * @param {number[]} numbersToSum numbers to add up
 * @returns {number} sum of all the numbers
 */
function sumAllNumbers(numbersToSum) {

  // array.reduce() - generate a single value from all the elements in the array
  //    there is an implied forEach loop to process the array
  //            the function given is called for each element in the array
  //
  // array.reduce(function-to-generate-the-final-result)
  //
  //  the function given accept two parameters (variable-for-result, name-for-the-current-element)

  // call reduce on the array passed in as a parameter using an anonymous function that will store result in sum
  //                                                                                and receive current element

  return numbersToSum.reduce((sum, number) => {
                                                return sum + number;
                                              }); // closing-brace ended anon-func, right-paren end call to reduce
                                            }                                                                             
/*
    Given: numbersToSum - [1,2,3]

    numbersToSum.reduce((reduced, element) => {return reducer + element });

    1. Call the anon-func with reducer=0, element=1
    2. The anon-func will return reducer + element and store that value in reducer
    3. Call the anon-func with reducer=1, element=2
    4. The anon-func will return reducer + number and store that value in reducer
    5. Call the anon-func with reducer=3, element=3
    6. The anon-func will return reducer + element and store that value in reducer
    7. The result of numbersToSum.reduce is the value in reduced
*/

/**
 * Takes an array and, using a named function, generates their sum.
 *
 * @param {number[]} numbersToSum numbers to add up
 * @returns {number} sum of all the numbers
 */

function sumNumbers(numbersToSum){
  // Note: only the name of the function is coded as an argument to reduce
  //       when using a named function
  //       two arguments are automatically passed to the named function:
  //             1. the-reducer - which holds the result
  //             2. the current element from the array
  return numbersToSum.reduce(addem);
}    
// function called in reduce to sum the elements
//       two arguments are automatically passed to the function: 
//             1. the-reducer - which holds the result
//             2. the current element from the array                              
function addem(sum, number){
  return sum + number;
}
/**
 * Takes an array and returns a new array of only numbers that are
 * multiples of 3
 *
 * @param {number[]} numbersToFilter numbers to filter through
 * @returns {number[]} a new array with only those numbers that are
 *   multiples of 3
 */
function allDivisibleByThree(numbersToFilter) {

  // go through the array numbersToFilter one element at a time passing the element to anon-func
  //   if the anon-func returns true the element will be added to a new array, if false it won't

  return numbersToFilter.filter((number)=> {
                                             if (number % 3 === 0) return true;     // if argument is evenly divisible by 3 return true
                                             else                  return false;    // if not, return false
                                           // alternate code: return (number % 3 === 0);
                                           // alternate code: return !(number % 3); 
                                           })  // brace ends anon-func, right paren ends call to filter
}
