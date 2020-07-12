package com.techelevator;

public class FranksArrayExample {
	
	public static void main(String[] args) {  
		
		System.out.println("Welcome to Frank's Array Example Program"); 
		
		int score1 = 10;
		int score2 = 20;
		int score3 = 30;
		int score4 = 15;   // added another value
		
		// The code is considered "tightly coupled" to the data
		//    if the data changes the code has to change
		
		int sum = score1+score2+score3+score4;  // Make sure I change the sum calculation
		
		double avg = sum / 4.0;  // Make sure I change the avg calculations
		
		System.out.println("The average of the numbers is: " + avg);
		
//----------------------------------------------------------------------------
// Use an array to hold the scores and process the array
		
		int[] scores = new int[6];  // An array of 6 ints
		
		scores[0] = 10;    // Set the first element to 10
		scores[1] = 20;    // Set the second element to 20
		scores[2] = 30;    // Set the third element to 30
		scores[3] = 150;   // Set the third element to 150
		scores[4] = 40;    // Set the third element to 40
		scores[5] = 3;     // Set the third element to 3
		
		int[] scores2 = {10, 20, 30, 150, 23};     // Define and initial1ze
		                                           //   The number of elements by the number of initializers
		
		System.out.println("Element at index 2 in scores2 is: " + scores2[2]);
	
		int total = 0;
		
		// set up a for loop to process the array form the beginning to the end

		// Define a loop variable called i and initialize it to 0 (the index of the first element)
		// Define a loop condition to loop as long as the loop variable does not 
		//         exceed the highest index value
		//         arrayname.length return the number elements in the array
		// Increment the loop variable at end of each loop - Use the increment operator (++)
		//         to add one to the loop variable
		//
		// Inside the loop we will add each to a variable called total
		
		for (int i=0; i < scores2.length; i++) {  // i will go from 0 to 2 while in the loop
			System.out.println("In the loop - i=" + i + " scores2["+i+"]=" +scores2[i]);
			total = total + scores2[i];   // use the loop variable as an index to the array
			System.out.println("Total is: " + total);
		}
	
		System.out.println("Average of the numbers is: " + total / scores2.length);
		

	}   // end of main() function
   
}  // end of FranksArrayExample class