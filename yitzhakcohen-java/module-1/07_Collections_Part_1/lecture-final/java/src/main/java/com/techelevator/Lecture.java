package com.techelevator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");
		
		String instructor = "Frank";
		
		// An ArrayList is a type of List - Used to hold a collection of objects.
		// to define:
		//
		//      List<data-type> name = new ArrayList<data-type>();
		
		List<String>  names = new ArrayList<String>(); // instantiate an ArrayList of Strings

		names.add("Nate");  // .add is how we add an element to an ArrayList
		names.add("Paul");
		names.add("Reva");
		names.add("Tracy");
		names.add("Elle");
		names.add("Justine");
		names.add(instructor);
		names.add("Carl");

		System.out.println("####################");
		System.out.println("Lists are ordered - the way/order they are added");
		System.out.println("####################");
		
		// .size() will return the number elements in the ArrayList (it was .length for an array)
		// .get(index) will return the element at the index in ArrayList
		
		for(int i=0; i<names.size(); i++) {
			System.out.println("Element #" + i + ": " + names.get(i));
		}

		System.out.println("####################");
		System.out.println("Lists allow duplicates");		
		System.out.println("####################");
		
		names.add("Carl");   // It's ok to add an entry that already exists
		
		for(int i=0; i<names.size(); i++) {
			System.out.println("Element #" + i + ": " + names.get(i));
		}

		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");
		
		names.add(4,"Brendan");  // add an new element at the index given - add at index 4
		
		for(int i=0; i<names.size(); i++) {
			System.out.println("Element #" + i + ": " + names.get(i));
		}

		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");
		
		names.remove(4);     // .remove will remove the element at the index specified
		names.remove(names.indexOf("Frank"));  // find the index of "Frank" and use the index to remove him
		
		for(int i=0; i<names.size(); i++) {
			System.out.println("Element #" + i + ": " + names.get(i));
		}

		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");

		if (names.contains("Tracy")) {
			System.out.println("Found entry in ArrayList");
		}
		else {
			System.out.println("Found entry NOT in ArrayList");
		}
		if (names.contains(instructor)) {
			System.out.println("Found entry in ArrayList");
		}
		else {
			System.out.println("Found entry NOT in ArrayList");
		}
		
		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");
		
		String[] namesArray = names.toArray(new String[names.size()]);
		
		     // 1. Ask toArray() to create a new String array with the same number of elements as the ArrayList
		     // 2. Put the elements in the ArrayList into the new String array
			 // 3. Return the new String array with the elements
		     // 4. Assign namesArray the String array returned from toArray()

		System.out.println("####################");
		System.out.println(" PRIMITIVE WRAPPERS");
		System.out.println("####################");

		/* Every primitive data type has an equivalent "primitive wrapper class" that is an object representation
		 * of a primitive value */
		
		// A primitive wrapper allows you to store primitives in an ArrayList
		// Integer - a Class to create Object from an int
		// Double - a Class to create Object from an double
		// Float - a Class to create Object from an float
		// Boolean - a Class to create Object from an boolean
		// Character - a Class to create Object from an char
		//
		// Integer.parseInt() - use the wrapper class to convert a String to int
		
		List<Integer> numbers = new ArrayList<Integer>();
		
		numbers.add(1);  // Add an element to the ArrayList
		

		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();
		
		// foreach is short hand loop for processing all elements in a Collection class
		//
		// foreach is sometimes know as  "the enhanced for loop"
		//
		// foreach loop: - Always goes from the beginning to end of the Collection
		//                 (can't stop in the middle, can't start any where but first element)
		//                 (process one each element in order - can't skip elements) 
		//
		// Syntax:  for(a-variable-to-hold-current-element : ArrayList-name) {
		//               In the body of loop use the variable defined to access the current element
		//          {
		// 

		System.out.println("Elements display using a regular for-loop");
		System.out.println();  // Display a blank line
		
		for(int i=0; i<names.size(); i++) {
			System.out.println("Element #" + i + ": " + names.get(i));
		}
		
		System.out.println("Elements display using a foreach-loop");
		System.out.println();  // Display a blank line
		
		// Each element in the ArrayList is a String
		// So our foreach variable needs to be a String
		
		for(String anElement : names) {                  // Each time through the loop anElement will contain the current element in the ArrayList
			System.out.println("Element: " + anElement); // Display the current element (stored in the anElement
		}
		// YOU would have to figure a way to count the elements if you want the element numbers
		int elementNumber = 0;
		
		for(String anElement : names) {                  // Each time through the loop anElement will contain the current element in the ArrayList
			System.out.println("Element #" + elementNumber + ": "+ anElement); // Display the current element (stored in the anElement
			elementNumber++;
		}
		
		
		System.out.println("####################");
		System.out.println("       QUEUES");
		System.out.println("####################");
		System.out.println();

		/////////////////////
		// PROCESSING ITEMS IN A QUEUE
		/////////////////////

		System.out.println("####################");
		System.out.println("       STACKS");
		System.out.println("####################");
		System.out.println();

		////////////////////
		// PUSHING ITEMS TO THE STACK
		////////////////////

		////////////////////
		// POPPING THE STACK
		////////////////////

	}
}
