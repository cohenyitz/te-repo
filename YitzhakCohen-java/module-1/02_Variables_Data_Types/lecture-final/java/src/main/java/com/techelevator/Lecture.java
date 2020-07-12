package com.techelevator;

public class Lecture {

	public static void main(String[] args) {
		
		// Define variables for Java
		
		// To define a variable:   datatype   name;  // Uninitialized variable - content unknown
		                                             // Use of uninitialized variable may result 
		                                             //    in unpredictable results or errors
		
		//                         datatype   name = initial-value;  // Initialized variable
		                                                             // Content is known 
		                                                             // safe and recommended
		// Most often used and preferred data types:
		//
		//  int     - Number without decimal places
		//  double  - Number with decimal places
		//  char    - One character - enclosed in ' '
		//  String  - Multiple character value - enclose in " "
		//            String are not a basic Java type - it's a special type for words/sentences
		//  boolean - true or false
		
		/*
		1. Create a variable to hold an int and call it numberOfExercises.
			Then set it to 26.
		*/
		   int numberOfExercises = 26;

		   System.out.println("The variable numberOfExercies contains: " + numberOfExercises);  // Display the value in numberOfExercises

		/*
		2. Create a variable to hold a double and call it half.
			Set it to 0.5.
		*/
           double half = 0.5;
		   System.out.println("half=" + half);

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
            double pi = 3.1416 ;  // 3.1416  is assumed to be a double value
                                  // 3.1416F is stated float value
                                  // 3.1416f is stated float value
		System.out.println("The variable pi contains: " + pi);

		/*
		7. Create and set a variable that holds your name.
		*/
           String myName = "Frank";
           System.out.println("myName is " + myName);
		/* +
		8. Create and set a variable that holds the number of buttons on your mouse.
		*/
           int mouseButtons = 2;
           System.out.println("My mouse has " + mouseButtons + " buttons");
		/*
		9. Create and set a variable that holds the percentage of battery left on
		your phone.
		*/
           double pctBatteryLife = 0; // Good idea to initialize even if you're told the initial value
		/*
		10. Create an int variable that holds the difference between 121 and 27.
		*/
             int diff = 121 - 27;
             System.out.println("Difference between 121 and 27 is: " + diff);
             
             System.out.println("Diff between 453 and 27 is: " + (453 - 27)); 
		/*
		11. Create a double that holds the addition of 12.3 and 32.1.
		*/
             double sum = 12.3 + 32.1;
             System.out.println("sum=" + sum);
		/*
		12. Create a String that holds your full name.
		*/
             String fullName = "Frank Fella";
		/*
		13. Create a String that holds the word "Hello, " concatenated onto your
		name from above.
		*/
             String newString = "Hello - " + fullName;
             System.out.println("newString: " + newString);  // + used with Strings means concatenate
		/*
		14. Add a " Esquire" onto the end of your full name and save it back to
		the same variable.
		*/
             fullName = fullName + " Esquire";  // Overlaying the variable with a new value
             System.out.println("The value is: " + fullName);
		/* 
		15. Now do the same as exercise 14, but use the += operator.
		*/
             fullName += " Esquire";  // Overlaying the variable with a new value
             System.out.println("The value is: " + fullName);
		/*
		16. Create a variable to hold "Saw" and add a 2 onto the end of it.
		*/
             String movieName = "Saw" + 2; // a number can be concatenate
		/*
		17. Add a 0 onto the end of the variable from exercise 16.
		*/
             System.out.println(movieName + 0);
		/*
		18. What is 4.4 divided by 2.2?
		*/
             System.out.println("4.4 divided by 2.2 is: " + 4.4 / 2.2);  // double / double gives double result
		/*
		19. What is 5.4 divided by 2?
		*/
             System.out.println("5.4 divided by 2 is: " + 5.4 / 2);     // double / int gives double result
                                                                        // 1. convert the int to a double
                                                                        // 2. double / double gives double
		/*
		20. What is 5 divided by 2?                                  // int / int gives int
		*/                  
             System.out.println("5 divided by 2 is: " + 5 / 2);      // int / int gives int
                                                                     // int do not have decimal
                                                                     // int divide has a quotient and remainder
                                                                     // 5 / 2 quotient=2, remainder=1
             double reva = 5 / 2;  // 5 / 2 = 2
             System.out.println(reva);
             
             /*
		21. What is 5.0 divided by 2?
		*/
             System.out.println("5.0 divided by 2 is: " + 5.0 / 2); // double / int
                                                                    //          int => double
                                                                    // double / double
             reva = (double) 5 / 2;  // 5.0 / 2 = 2.5  // cast the 5 to double
             System.out.println(reva);
        /*
		22. What is 66.6 divided by 100? Is the answer you get right or wrong?
		*/
            System.out.println(66.6 / 100);  // demonstrate the issue convert double to decimal
		/*
		23. If I divide 5 by 2, what's my remainder?
		*/
            System.out.println("Remainder of 5 / 2 = " + 5 % 2);  //modulus (%) gives the remainder of integer divide
		/*
		24. What is 1,000,000,000 * 3?
		*/
            System.out.println("100000000 * 3 = " + 1000000000 * 3); // result is too bit to fit in an int
                                                                     // 3 billion is outside the range for an int
            System.out.println("100000000 * 3 = " + 1000000000 * (long) 3);
            /*
		25. Create a variable that holds a boolean called doneWithExercises and
		set it to false.
		*/
          boolean doneWithExercises = false;
		/*
		26. Now set doneWithExercises to true.
		*/
          doneWithExercises = true;
		
	}

}
