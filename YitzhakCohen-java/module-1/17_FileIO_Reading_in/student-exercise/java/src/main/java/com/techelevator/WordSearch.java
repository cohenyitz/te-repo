package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) throws FileNotFoundException {
	
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("What word would you like to search for? ");
		String userInput =  keyboard.nextLine();
		
		System.out.println("Should your search be case sensitive? (Y/N) ");
		String userCaseSensitivity = keyboard.nextLine();
		
		File aliceWordSearch = new File("alices_adventures_in_wonderland.txt");
		Scanner inputFile = new Scanner(aliceWordSearch);
		
		int lineNumber = 0;
		
		while (inputFile.hasNext()) {
			String aLine = inputFile.nextLine();
			lineNumber = lineNumber + 1;
				if (userCaseSensitivity.equals("Y")) {			// If case should be sensitive then user should see only the  
					userInput.toUpperCase();					// results that appear in the same case as search 
					if(aLine.contains(userInput)) {
					System.out.println(lineNumber +  ")" + " " + aLine);
				}
			}		
			else if (userCaseSensitivity.equals("N")) {			// If case should not be sensitive then search 
				userInput.toLowerCase();						// should return every instance regardless of case
				if(aLine.toLowerCase().contains(userInput.toLowerCase())) {
				System.out.println(lineNumber +  ")" + " " + aLine);
				}
					
			}
	}inputFile.close(); 
	}
		
}
