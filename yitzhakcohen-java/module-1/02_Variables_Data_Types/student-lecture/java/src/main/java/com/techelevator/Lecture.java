package com.techelevator;

public class Lecture {

	public static void main(String[] args) {
		
		// Define variables for Java
		
		// To define a variable: datatype  name;  // Uninitialized variable - content unnkown 
												  // Use of uninitialized variable may result
												  // 	in unpredictable results or errors
		
		//						 datatype  name= intial-value;  // Initialized variable
																// Content is known
																// safe and recommended 
		// Most often used and preferred datatypes
		//
		// int - Number without decimal places
		// double - Number with decimal places
		// char - One character - enclosed in ' '
		// String - Multiple character value - enclose in " "
		//			String are not a basic Java type - it's a special type for words/sentences 
		// boolean - true or false 
		
		/*
		1. Create a variable to hold an int and call it numberOfExercises.
			Then set it to 26.
		*/
		int numberOfExercises = 26; 

		System.out.println("The variable numberOfExercises contains: " + numberOfExercises); // Display the caluse in numberOfExercises

		/*
		2. Create a variable to hold a double and call it half.
			Set it to 0.5.
		*/
		double half = 0.5;

		System.out.println(half);

		/*
		3. Create a variable to hold a String and call it name.
			Set it to "TechElevator".
		*/
		String name = "TechElevator";

		System.out.println(name);

		/*
		4. Create a variable called seasonsOfFirefly and set it to 1.
		*/
		int seasonsOfFirefly = 1;

		System.out.println(seasonsOfFirefly);

		/*
		5. Create a variable called myFavoriteLanguage and set it to "Java".
		*/
		String myFavoriteLanguage = "Java";
		
		System.out.println(myFavoriteLanguage);

		/*
		6. Create a variable called pi and set it to 3.1416.
		*/
		double pi = 3.1416;
		
		System.out.println(pi);

		/*
		7. Create and set a variable that holds your name.
		*/
		String myName = "Yitzhak Cohen";
		
		System.out.println(myName);
		/*
		8. Create and set a variable that holds the number of buttons on your mouse.
		*/
		int numberOfMouseButtons = 5;
		
		System.out.println(numberOfMouseButtons);
		/*
		9. Create and set a variable that holds the percentage of battery left on
		your phone.
		*/
		double percentageOfPhoneBattery = 0; // Good idea to initialize even if you're not told 
		
		System.out.println("Phone Battery:" + percentageOfPhoneBattery + "%");
		/*
		10. Create an int variable that holds the difference between 121 and 27.
		*/
		int differenceBtwn121And27 = 121 - 27;
		
		System.out.println(differenceBtwn121And27);
		/*
		11. Create a double that holds the addition of 12.3 and 32.1.
		*/
		double sum = 12.3 + 32.1;
		
		System.out.println(sum);
		/*
		12. Create a String that holds your full name.
		*/
		String fullName = "Yitzhak Emanuel Cohen";
		
		/*
		13. Create a String that holds the word "Hello, " concatenated onto your
		name from above.
		*/
		String newString = "Hello " + fullName;
		
		System.out.println(newString);
	
		/*
		14. Add a " Esquire" onto the end of your full name and save it back to
		the same variable.
		*/
		fullName = fullName + " Esquire";
		
		System.out.println(fullName);
		
		/*
		15. Now do the same as exercise 14, but use the += operator.
		*/
		fullName += " Esquire";
		
		System.out.println(fullName);
		/*
		16. Create a variable to hold "Saw" and add a 2 onto the end of it.
		*/
		String saw = "Saw " + 2;
		
		System.out.println(saw);
		/*
		17. Add a 0 onto the end of the variable from exercise 16.
		*/
		saw += 0;
		
		System.out.println(saw);
		/*
		18. What is 4.4 divided by 2.2?
		*/
		
		
		System.out.println();
		/*
		19. What is 5.4 divided by 2?
		*/

		/*
		20. What is 5 divided by 2?
		*/
		double divide = 5/2;
		System.out.println(divide);
		/*
		21. What is 5.0 divided by 2?
		*/

		/*
		22. What is 66.6 divided by 100? Is the answer you get right or wrong?
		*/
		System.out.println(66.6/100);
		/*
		23. If I divide 5 by 2, what's my remainder?
		*/
		System.out.println("Remainder of 5 /2 " + 5 % 2);
		/*
		24. What is 1,000,000,000 * 3?
		*/
		System.out.println(1000000000 * (long) 3);
		/*
		25. Create a variable that holds a boolean called doneWithExercises and
		set it to false.
		*/

		/*
		26. Now set doneWithExercise to true.
		*/
		int n = 15;

		if (n % 5 == 0) {
		  // Fizz
		} else if (n % 3 == 0) {
		  // Buzz
		} else if (n % 3 == 0 && n % 5 == 0) {
		  // FizzBuzz
		}
		
		System.out.println(n);
		
	}

}
