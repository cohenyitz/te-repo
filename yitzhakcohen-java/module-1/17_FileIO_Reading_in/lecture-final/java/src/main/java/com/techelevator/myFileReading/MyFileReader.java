package com.techelevator.myFileReading;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyFileReader {

	public static void main(String[] args) throws FileNotFoundException {
		
		int grandTotal = 0;    // Hold total of all lines
		
		File myFile = new File("./data/numbers.txt"); // Define a file object for numbers.txt
		Scanner inputFile = new Scanner(myFile);      // Define a Scanner object to access the file
		
		while(inputFile.hasNext()) {  // Loop while there is data in the file
			String aLine = inputFile.nextLine();  // Read the next line from the file into aLine
			System.out.println("Line the file: " + aLine);
			// sum the numbers in the line from the file
			String[] theNumbers = aLine.split(","); // Extract each number from the line into an array

			for(int i=0; i< theNumbers.length; i++) {
				System.out.println("theNumber["+i +"] is: " +theNumbers[i]);
			}

			int sum = 0; // Variable to hold the sum	
			
			for(String aNum : theNumbers) { // Loop through the array of numbers with aNum holding the current number
				sum = sum + Integer.parseInt(aNum);	// Convert the current number to an int and add it to sum)
			}
			grandTotal = grandTotal + sum;
			
		System.out.println("The sum of the numbers is: " + sum +"\n");
	}
		System.out.println("The total of all numbers in all lines: " + grandTotal);

		inputFile.close();            // close the file after the loop since I'm done with it
	}
}

