package com.techelevator.myFileReading;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyFileReader {

	public static void main(String[] args) throws FileNotFoundException {
		
		File myFile = new File("./data/numbers.txt");  // Define a file object for number.txt
		Scanner inputFile = new Scanner(myFile);	   // Define a Scanner object to access the file
		
		
		while(inputFile.hasNext()) {				   // Loop  while there is data in the file
			String aLine = inputFile.nextLine();	   // Read the next line from the file into aLine
			System.out.println("Line the file: " + aLine);
													   // We want to sum the numbers in the line from the file
			   										   // In order to sum the numbers we have to 
			String [] theNumbers = aLine.split(",");   // Extract each number from the line into an array
			
			int sum = 0;							   // Variable to hold the sum
			
			for(String aNum : theNumbers) {			   // Loop through the array of numbers with aNum holding the current number
				sum = sum + Integer.parseInt(aNum);	   // Convert the current number to an int and add it to sum
			}
		System.out.println("The sum of the numbers is: " + sum);
		}
		inputFile.close(); 							   // Close the file after the loop since I'm done with it
	}

}
