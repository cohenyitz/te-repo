package com.techelevator;

public class Lecture {

    /*
    1. Return the created array
    */
	// data type of return value in an int array
    public int[] returnArray() {
        int[] array = { 80, 8080, 443 };
        return array;
    }

    /*
    2. Return the first element of the array
    */
    public int returnFirstElement() {
        int[] portNumbers = { 80, 8080, 443 };
        return portNumbers[0];  // The first element in an array is at index 0
     }

    /*
    3. Return the last element of the array
    */
    public int returnLastElement() {
        int[] portNumbers = { 80, 8080, 443 };
        int lastElement = portNumbers.length - 1;
        return portNumbers[portNumbers.length-1];  // The highest valid index is length - 1
    }                                              // The last element is at index = length - 1
                                                   // We could have coded portNumbers[2]
                                                   //    but that tightly couple the code to the data

    /*
    4. Return the first element of the array from the parameters
    */
    // An array can be a parameter to a function
    public int returnFirstElementOfParam(int[] passedInArray) {  // the parameter is an int array
        return passedInArray[0];
    }

    /*
    5. Return the last element of the array from the parameters
    */
    public int returnLastElementOfParam(int[] passedInArray) {
    	int lastElement = passedInArray.length - 1;  // assign the index of the last element in the array to a variable
        return passedInArray[lastElement];
    }

    /*
    6. Here, a variable is defined within a block. How can we get the value of that outside of the block in order to
       return it? There are a couple of different ways of doing this, what can you come up with?
    */
    //Scope - Variables are only known and accessible within the block they are defined
    //        a variable is accessible to the block it's and any block define within it
    public int returnVariableFromBlock(int number) {
    	
    	int result = number * 5;
    	
        { // A new block with scoped variables

        //  int result = number * 5;  // the variable is only known inside this block
        
        } // the result variable disappears here

        return result; // We want to return result here. How? - move it outside the block it is in
                        //                                         or assign the value to variable outside the block
    }

    /*
    7. What will the variable result be at the end of the method? Change the number in the logic expression so that
       it returns true.
    */
    public boolean returnOperationInBlock() {
        int result = 5;

        {
            int multiplier = 10;
            result *= multiplier; // result is changed/available because it's in scope for this block
        //  result  = result * multiplier;
        }

        return result == 50; // <-- Change the number to match result and make this be true
    }                       //     (What's in result when we get here?)

    /*
    8. Return the only variable that is in scope at the return statement.
    */
    public double returnInScopeVariable() {
        double one = 1.0;
        {
            double three = 3.0;
            one += three;
            {
                double four = 4.0;
                three = four - one;
                one++;
            }

            double five = 5.0;
            double eight = five + three;
        }

        return one;  // What variable is accessible to this return statement
    }

    /*
    9. How many times do we go through this loop? Change the number in the logic expression so that it returns true.
    */
    public boolean returnCounterFromLoop() {

        int[] arrayToLoopThrough = { 3, 4, 2, 9 };

        int counter = 0; // Must be started outside the block so that have access to it after the block

        for (int i = 0; i < arrayToLoopThrough.length; i++) {  // This will loop once for each element in the array
            counter++;   // add when i=0,1,2,3 - adding to counter 4 times
        }

        return counter == 4 ; // What should the number be to return true?
                              // How many times do we loop?
    }

    /*
    10. This loop is counting incorrectly. What needs to change in the loop for it to count properly?
    */
    public boolean returnCorrectCount() {
        int[] arrayToLoopThrough = { 4, 23, 9 };

        int counter = 0;

        //     Start;       Keep going while         Increment by one;
        for (int i = 0; i < arrayToLoopThrough.length; i++) {
            counter += 1;
        }

        return counter == 3;  // We want counter to be 3 when we are done with the loop
    }

    /*
    11. This loop is counting incorrectly. What needs to change in the loop for it to count properly?
    */
    public boolean returnCountCorrectTimes() {
        int[] arrayToLoopThrough = { 4, 23, 9, 4, 33 };

        int counter = 0;

        //     Start;       Keep going while         Increment by one;
        for (int i = 0; i < arrayToLoopThrough.length; i++) {
            counter = counter + 1;
        }
        return counter == 5;  // We want counter to be 5 after the loop
    }

    /*
    12. We want this loop to only count every other item starting at zero. What needs to change in the loop for
        it to do that?
    */
    public boolean returnSumEveryOtherNumber() {
        int[] arrayToLoopThrough = { 4, 3, 4, 1, 4, 6 };

        int sum = 0;

        //     Start;       Keep going while       Increment by;
        for (int i = 0; i < arrayToLoopThrough.length; i = i + 2) {
            sum = sum + arrayToLoopThrough[i];
        }

        return sum == 12;
    }
}