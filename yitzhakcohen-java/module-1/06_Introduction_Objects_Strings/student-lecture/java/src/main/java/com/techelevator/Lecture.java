package com.techelevator;

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
		 * 		String name = new String();	//create an empty String
		 *		String nema = "value"; 		// create a new String with value given
		 * 		String name = "";			//create an empty String
		 * 
		 *  	String name;  //Will CAUSE AN ERROR - this is an undefined String
		 *  				  // Trying to use an undefined anything, will case an error
		 */
		
		String paul = "Over 9000!";
		
		String anotherString = paul + " llamas";
		
		System.out.println("variable paul contains: " + paul);	// expecting "Over 9000!"
		System.out.println("variable another String contains: " + anotherString);	// expecting "Over 9000! llamas"

		

		System.out.println();
		System.out.println("******************************");
		System.out.println("****** MEMBER METHODS ******");
		System.out.println("******************************");
		System.out.println();

		
		/*
		 * Like many things provided by Java, String provides methods to help use it effectively 
		 */
		
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
		 * toUpperCase() - return the String in all uppercase
		 * trim() - return the String with spaces removed from beginning and end of the String
		 */

		// 			   012345678911234	-	index of each character
		String name = "Pauline Jupiter";
		
		System.out.println();	//Display a blank line
		System.out.println("name contains " + name);
		
		System.out.println("name.length() returns: " + name.length());
		
		System.out.println("The character at index 11: " + name.charAt(11));	// access a specific character 
		System.out.println("The character at index 3: " + name.charAt(3));	// access a specific character 

		/*
		 * 	Eclipse Intellisense displays
		 * 
		 * method-name(argument(s) : return-type - Class that defines it
		 * 
		 * charAt(int index) 	   : char		 - String
		 * 
		 */
		if(name.charAt(3) == 'l') {		// 'l' is a char - "l" is a String - charAt() returns a char
			System.out.println("its an l");
		}
		else {
			System.out.println("its NOT an l");
		}

		System.out.println("Does name start with Paul?: " + name.startsWith("Paul"));	
		System.out.println("Does name start end with line?: " + name.endsWith("line"));
		
		// Sustring (start-idex, end-index +1)
		System.out.println("What are the 4th thru 9th chars in name?: " + name.substring(3, 9));	// Expect "line J"
		//                          index 3  thru 8													// does not include the char at end of index
		
		System.out.println("name in uppercase is: " + name.toUpperCase());
		
		System.out.println();
		System.out.println("**********************");
		System.out.println("****** EQUALITY ******");
		System.out.println("**********************");
		System.out.println();

		
		String hello1 = "Hello";
		String hello2 = "Hi";
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

	}
}
