/*
    Example of a multi-line comment just like in C#/Java
*/

// Single line comment

/**
 * Functions start with the word function.
 * They don't have a return type and the naming convention is camel-case.
 * no return type because JavaScript variables are dynamic/loosely typed
 * We intro the concepts od=f functions today - ALOT more on functions tomorrow
 * To have JavaScript generate a string, put the values inside the ` ` (back-ticks)
 * If you want variable values substituted use ${variable-name} - EL expression
 */
function variables() {
  // Declares a variable where the value cannot be changed
  // Use let statement to define a variable in JavaScript
  // DO NOT USE var to define a JavaScript variable
  // It is not considered best practice to use VAR - may lead to confusion 
  //const attribute makes a variable who's value cannot be changed

  const daysPerWeek = 7;
  // console.log writes a lint to screen (like System.out.println() in Java)
  // enclose the line with back-tick and variables go inside ${}
  console.log(`There are ${daysPerWeek} in a week.`);


  // Declares a variable those value can be changed

  let daysPerMonth = 30;  // assign an int value to a variable
  console.log(`There are ${daysPerMonth} in some months`)

  daysPerMonth = 'Thirty';  // assign a string to an already defined variable 
  console.log(`There are ${daysPerMonth} in some months`)

// String are enclosed in single quotes or double quotes
// ; is usually optional at the on of a statement

  // Declares a variable that will always be an array
  // Arrays are enclosed in []
  //You may assign values to the array when defining

  let weekdays = [
    "Monday",
    "Tuesday",
    "Wednesday",
    "Thursday",
    "Friday",
    "Saturday",
    "Sunday"
  ]
  console.table(weekdays);
}

/**
 * Functions can also accept parameters.
 * Notice the parameters do not have types because JavaScript is looselyy coupled variables
 * @param {Number} param1 The first number to display
 * @param {Number} param2 The second number to display
 */
function printParameters(param1, param2) {
  console.log(`The value of param1 is ${param1}`);
  console.log(`The value of param2 is ${param2}`);
}

/**
 * Compares two values x and y.
 * == is loose equality         - values are the same -does not take account datatype
 * === is strict equality       - values and data types are the same
 * @param {Object} x    
 * @param {Object} y
 */
function equality(x, y) {
  console.log(`x is ${typeof x}`);    // typeof return the data type of a variable
  console.log(`y is ${typeof y}`);

  console.log(`x == y : ${x == y}`); // true
  console.log(`x === y : ${x === y}`); // false
}

/**
 * Each value is inherently truthy or falsy.
 * false, 0, '', null, undefined, and NaN are always falsy
 * everything else is always truthy
 * @param {Object} x The object to check for truthy or falsy,
 */
function falsy(x) {
  if (x) {  //Everything is truthy or falsy
    console.log(`${x} is truthy`);
  } else {
    console.log(`${x} is falsy`);
  }
}

/**
  Objects in JavaScript are NOT the same as Objects in Java/C#  
  Objects in JavaScript are NOT Object Oriented objects
 
 * Objects are simple key-value pairs (like a Map in Java)
    - values can be primitive data types
    - values can be arrays
    - or they can be functions
    JSON -javaScript Object Notation
*/
function objects() {
  const person = {          // Object attributes are defined inside {}
    firstName: "Bill",      // key: value
    lastName: "Lumbergh",   // place commas between attributes of the object
    age: 42,
    employees: [            // An object attribute can be an array
      "Peter Gibbons",
      "Milton Waddams",
      "Samir Nagheenanajar",
      "Michael Bolton"
    ],
    toString : function() { // add an attribute to the object that is a function
      return `${this.lastName}, ${this.firstName}, ${this.age}` // 'this' means the current object
    }
  };

  // Log the object
  console.log(`person object is: ${person}`)  // Uses the toString() for the object if defined
  console.table(person)
  // if you code object.attribute - give the data for the attribute
  // if you code object.attribute() - run the function assigned to the attribute
  console.log(person.toString())

  // Log the first and last name
  // reference an attribute in an object  object-name.attribute notation
  console.log(`First Name: ${person.firstName} Last Name: ${person.lastName}`)
  // Log each employee
  // employees is an array in the object 
  // we need to loop through the array
  // can use a JavaScript for loop - same format as Java for loop
  for (let i = 0; i < person.employees.length; i++) {   // loop through the person objects employees array
    console.log(`Employee #: ${i+1} is ${person.employees[i]}`) // Display employee array position 1-based
                                                             // and the data in the employee element
                                                             // of the array
  }
}

/*
########################
Function Overloading
########################

Function Overloading is not available in Javascript. 

Overload - same name, same data (parameters) different behavior
Override - same name, different data (parameters), same behavior

If you declare a function with the same name, more than one time in a script file, the
earlier ones are overriden and the most recent one will be used.

The latest function definition in the JavaScript file for  name is the one thats used
*/

function Add(num1, num2) {
  console.log(`Two arg Add was run`)
  return num1 + num2;
}
// This Add function replaces the earlier one
function Add(num1, num2, num3) {
  console.log(`Three arg Add was run`)
  return num1 + num2 + num3;
}

/*
########################
Math Library
########################

A built-in `Math` object has properties and methods for mathematical constants and functions.
*/

function mathFunctions() {
  console.log("Math.PI : " + Math.PI);
  console.log("Math.LOG10E : " + Math.LOG10E);
  console.log("Math.abs(-10) : " + Math.abs(-10));
  console.log("Math.floor(1.99) : " + Math.floor(1.99));
  console.log("Math.ceil(1.01) : " + Math.ceil(1.01));
  console.log("Math.random() : " + Math.random());
}

/*
########################
String Methods
########################

The string data type has a lot of properties and methods similar to strings in Java/C#
*/

function stringFunctions(value) {
  console.log(`.length -  ${value.length}`);
  console.log(`.endsWith('World') - ${value.endsWith("World")}`);
  console.log(`.startsWith('Hello') - ${value.startsWith("Hello")}`);
  console.log(`.indexOf('Hello') - ${value.indexOf("Hello")}`);
  console.log(`.substr(value, 2,3) - ${value.substr(2,3)}`);       // start-index, length
  console.log(`.substring(value, 2,3) - ${value.substring(2,3)}`); // start-index, end-index
                                                                    // does not include the character at end-index
                                                                    //   (just like java)
  /*
    Other Methods
        - split(string)
        - substr(number, number)
        - substring(number, number)
        - toLowerCase()
        - trim()
        - https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String
    */
}
    /*
    ##########################
    Array Manipulation Methods
    ##########################

    JavaScript has many Array manipulation functions
    */
    function arrayFunctions() {
      let stooges = [
                    "Moe",
                    "Larry",
                    "Curly"
                    ];
      console.table(stooges); //Display array as a table

      stooges.push("Shemp");  // Add an element to end of the array
      console.table(stooges); //Display array as a table

      stooges.unshift("Curly Joe"); // Add an element to te start of an array
      console.table(stooges); //Display array as a table

      stooges.splice(3,0,"Groucho", "Chico", "Harpo");  //Add elements starting at index 3
                                                        // (3)index at which to insert elements
                                                        // (0) of elements to delete BEFORE insert
                                                        // .splice(3,0,'NEW") - go to index 3
                                                                            // delete 0 elements
                                                                            // insert new one(s)
      console.table(stooges); //Display array as a table

      stooges.splice(3,2);    // Remove 2 elements starting at index 3
      console.table(stooges); //Display array as a table

      stooges.shift();        // Remove one element at start of the array
      console.table(stooges); //Display array as a table

      stooges.pop();          // Remove one element from end of the array
      console.table(stooges); //Display array as a table

      stooges.splice(stooges.indexOf('Larry', 1))  // Remove one element with content Larry
                                                  // Find the index of Larry 
                                                  // Remove one row at that index
      console.table(stooges); //Display array as a table

      let marxBros = [
        "Groucho",
        "Chico",
        "Harpo"
      ]
      let funnyGuys = stooges.concat(marxBros);
      console.table(funnyGuys); //Display array as a table
    }


