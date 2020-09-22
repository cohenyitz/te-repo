package com.techelevator;

public class FranksArrayExample {
	
	public static void main(String[] args) {  
		
		System.out.println("Welcome to Frank's Array Example Program"); 

		int score1 = 10;
		int score2 = 20;
		int score3 = 30;
		int score4 = 15; // added another value
		
		// The code is considered "tightly coupled" to the data
		//	if the data changes the code has to change
		
		int sum = score1 + score2 + score3 + score4; // make sure I change the sum calculation 
		double avg = sum / 4; // make sure I change the avg calculations
		
		System.out.println("The average of the numbers is: " + avg);
		
		//-------------------------------------------------------------------------------------------
		// Use an array to hold the scores and process the array
		
			int [] scores = new int[3]; // An array of 3 ints
			
			scores[0] = 10; // Set the first element to 10 
			scores[1] = 20; // Set the second element to 20
			scores[2] = 30; // Set the third element to 30
			
			int[] scores2 = {10, 20, 30, 150, 40, 3};  // Define and initialize 
													   // The number of elements by the number of initialized 
			
			int total = 0;
			
			// Set up a for loop to process the array from the beginning to the end
			// Define a loop variable called i and initialize it at 0 (the index of the first element)
			// Define a loop condition to loop as long as the loop variable does not
			//							exceed the highest index value
			//							araayname.length return the number elements in the array
			// Increment the loop variable at the end of each loop - Use the increment operator (++)
			//							to add one to the loop variable
			// Inside the loop we will add each element to a variable called total
			
			for (int i = 0; i < scores.length; i++) {  // i will  go from 0 to 2 while in the loop
				total = total + scores[i];	// Use the loop variable as an index to the array
			}
			
			System.out.println("Averageof the numbers is: " + total / scores.length);
	}   
   
}