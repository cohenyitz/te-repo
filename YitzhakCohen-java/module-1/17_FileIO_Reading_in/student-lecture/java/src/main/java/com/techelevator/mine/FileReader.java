package com.techelevator.mine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

	public static void main(String[] args) throws FileNotFoundException  {
		String fileName = "./data/numbers.txt";   // File is in the same folder as project - just give it's name
		
		File numbersFile = new File(fileName);                // Define a File Object for the text file
		
		Scanner donutFileScanner = new Scanner(numbersFile);  // Define Scanner for the File Object
		
		while (donutFileScanner.hasNextLine()) {           // Loop while there are lines in the file
			String fileLine = donutFileScanner.nextLine(); //     Read a line from the file
			System.out.println("Line read: " + fileLine);  //     Display the line just read

			// Sum the number and display the numbers and the sum	
			
			String[] theNums = fileLine.split(",");        // Place each number in the line as an element in an array
			
			int sum = 0;    // This will hold the sum of the numbers

//          for(int i=0; i < theNums.length; i++)			
			for (String aNum : theNums) {             // Loop through the theNums array placing each element in aNum
				int aValue = Integer.parseInt(aNum);  //     Çonvert the current element to an int
				sum += aValue;                        //     add the value to sum		
			}
			System.out.println("The sum of the numbers is: " + sum); // Display the sum
		}
		donutFileScanner.close();  // Release the resources we were using for the file
	}

}
