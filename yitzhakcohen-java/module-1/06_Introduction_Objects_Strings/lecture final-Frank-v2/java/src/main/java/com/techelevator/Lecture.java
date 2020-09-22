package com.techelevator;

import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("************************************");
		System.out.println("****** MAKING A STRING OBJECT ******");
		System.out.println("************************************");

		/* The String class gets special treatment in the Java language.  One
		 * example of this is that there is a literal representation of a
		 * String (i.e. characters appearing between two double quotes.  This
		 * is not the case for most classes */

		/* create an new instance of String using a literal */
		/*
		 *     datatype  name   =   new String();
		 *     datatype  name   =   "value";
		 */
		String cheese = "Gouda";
		
		// + may be used to concatenate Strings
		String anotherString = cheese + " bologna";
		
		System.out.println(anotherString); // expecting Gouda bologna
		
		
		System.out.println();
		System.out.println("******************************");
		System.out.println("****** MEMBER METHODS ******");
		System.out.println("******************************");
		System.out.println();


		/* Commonly used methods:  stringname.methodname(parameters)
		 *
		 * length() - return the number of characters in a String
		 * charAt(index) - returns the character at the index - 0 is first character
		 * endsWith(search-string) - return true if the String ends with the search-string 
		 * startsWith(search-string) - return true if the String starts with the search-string
		 * indexOf(search-string) - return the index of the start of the 1st occurrence of search-string in the String
		 * lastIndexOf(search-string) - return the index of the start of the last occurrence of search-string in the Stri
		 * substring(start-index) - return from the start-index to rest of String
		 * substring(start-index,end-index) - return from the start-index to the end-index (but not the char at end-index)
		 * toLowerCase() - return the String in all lowercase
		 * toUpperCase() - retrrn the String in all uppercaswe
		 * trim() - return the String with spaces removed from beginning and end of the String
		 */
                    // 01234567891123
		String name = "Baker Mayfield";
		
		System.out.println("The 4th character in name: " + name.charAt(3)); // 'e'
		
		System.out.println("Does name end with the word field: "  + name.endsWith("field"));
		System.out.println("Does name end with the word berger: " + name.endsWith("berger"));
		
		System.out.println("Does name start with B "  + name.startsWith("B"));
		System.out.println("Does name start with b "  + name.startsWith("b"));
		
		System.out.println("Where does 'k' start in name?: "  + name.indexOf("k")); // expect 2
		System.out.println("Where does 'z' start in name?: "  + name.indexOf("z")); // expect -1
		System.out.println("Where does ' ' start in name?: "  + name.indexOf(" ")); // expect 5
		System.out.println("Where does 'a' start in name?: "  + name.indexOf("a")); // expect 1
		System.out.println("Where does the last 'a' start in name?: "  + name.lastIndexOf("a")); // expect 7
		
		System.out.println("Chars from the fifth char to end: "  + name.substring(4)); // "r Mayfield"
		System.out.println("Chars from the fifth char to the eighth: "  + name.substring(4,8)); // "r Ma"
		
		System.out.println("all lowercase: " + name.toLowerCase());
		System.out.println("all uppercase: " + name.toUpperCase());
		
		name = "   Aaron  Frank      ";
		
		System.out.println("trim(name): " + name.trim() + " which is " + name.trim().length() + " long");
		
		
// Display the last name in the String 
// The last name starts after the first space
//
// Name = Baker Mayfield
// Name	= Stevie Ray Vaughn
		
// 1. Find the last space
// 2. Get all the characters after the first space
// 
int lastSpace = name.lastIndexOf(" "); // index of the last space
String lastName = name.substring(lastSpace+1);

System.out.println("Last Name is: " + lastName + " which is " + lastName.length() + " characters long");

System.out.println("Last Name is: " + name.substring(lastSpace+1));

System.out.println("Last Name is: " + name.substring(name.lastIndexOf(" ")+1));
		
		
// How many 'a's are in name?
		
		int numLetters = 0; // Hold the number of letters we find
		
		for (int i=0; i < name.length(); i++) {   // Loop through each char in the String

			if(name.charAt(i) == 'a') {  // If the current letter indicated by i is an 'a'
				numLetters++;          //     count it
			}
		}
		
		System.out.println("Number if 'a's in name is: " + numLetters);
		
//--------------------------------------------------------------------------------
		System.out.println();
		System.out.println("**********************");
		System.out.println("****** EQUALITY ******");
		System.out.println("**********************");
		System.out.println();

		char[] helloArray = new char[] { 'H', 'e', 'l', 'l', 'o' }; // Array of characters (String)
		
		String hello1 = new String(helloArray);  // Create a String using the array of characters
		String hello2 = new String(helloArray);  // Create a String using the array of characters


		/* Double equals will compare to see if the two variables, hello1 and
		 * hello2 point to the same object in memory. Are they the same object? */
		if (hello1 == hello2) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

		String hello3 = hello1;
		if (hello1 == hello3) {
			System.out.println("hello1 is the same reference as hello3");
		}

		/* So, to compare the values of two objects, we need to use the equals method.
		 * Every object type has an equals method */
		if (hello1.equals(hello2)) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}
		
		System.out.println();
		System.out.println("**************************");
		System.out.println("****** USING .split ******");
		System.out.println("**************************");
		System.out.println();

		Scanner userInput = new Scanner(System.in);   // Define  Scanner to get user input
		
		String userData = "";        // define an empty String to hold user input
		
		System.out.println("Please enter a series of integers separated by spaces");
		
		userData = userInput.nextLine();   // Get line of input from user
		
		System.out.println("You entered: " + userData);  // Show user what they entered
		
		String[] theNumbers = userData.split(" "); // Divide user input into individual values
		
		int sum = 0;  // Define a variable to hold the sum
		
		for (int i=0; i<theNumbers.length; i++) {        // Loop through the individual values
			sum = sum + Integer.parseInt(theNumbers[i]); //    Convert element from String to int
		}                                                //    and add to sum
		
		System.out.println("\nThe sum of the numbers is: " + sum);  // '\n' is a newline escape character
		
		}
		
		

	}

