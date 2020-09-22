	package com.techelevator;

import java.util.Scanner;	// Go get the description of a Scanner

public class CommandLineSampleProgram {

	public static void main(String[] args) {
		
		System.out.println("Welcome to Frank's Command Line Sample Program");
		
		// Read input from the keyboard
		
		// Define a Java Scanner object to represent the keyboard
		// System.in is a pre-defined name for the keyboard - defined by Java
		// Scanner - scant the keyboard input and return values to the program
		
	//  datatype  name		=	initial-value
		Scanner theKeyboard = new Scanner(System.in);	// Give me a Scanner object connected to a the keyboard
		
		String aLine = ""; // Hold a line of input from the keyboard
		
		System.out.println("Please enter a line and press enter ");
		aLine = theKeyboard.nextLine();		// Get the next line of input from the keyboard and it in aLine
		
		System.out.println("The line entered was: "  + aLine);	// Display the line entered from the keyboard
		
		
		System.out.println("Please enter a whole number: ");
		int aNumber = theKeyboard.nextInt();
		
		String aChar = theKeyboard.nextLine(); // Clear the buffer of the enter key left by nextIn()
		
		System.out.println("You entered: " + aNumber + " half of that is " + aNumber / 2);
		
		System.out.println("How rude of me, I didnt ak you for your name. Whats your name: ");
		String aName = theKeyboard.nextLine();	// Get the next line from the keyboard
		
		System.out.println("Hello, " + aName);
		
		System.out.println("please enter another whole number");
		
		aLine = theKeyboard.nextLine(); 	// read the input as a String -so enter is not left in the buffer
		aNumber = Integer.parseInt(aLine);	// Convert the String to an int so its numeric
											// Double.parseDouble(aString)
											// Float.parseFloat(aString)
		
		
		System.out.println("You entered: " + aNumber + " half of that is " + aNumber / 2);
		
		System.out.println("I forgot your name, what was it, again?");
		
		System.out.println("Hello, " + aName);
		
		
	}

}
