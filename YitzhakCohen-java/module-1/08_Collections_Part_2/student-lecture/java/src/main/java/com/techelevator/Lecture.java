package com.techelevator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("       MAPS");
		System.out.println("####################");
		System.out.println();

		/* Map is an interface and HashMap is a class that implements Map 
		 * 
		 * Two common types of Maps: HashMap - Stores data in any order it wants to (faster)
		 * 							 TreeMap - Stores data in sort order (slower)
		 * 
		 * */
		
		// Define a map:	Map<key-type, value-type> name = new HashMap<key-type, value-type> ()
		
		// Define a map to hold a name (String) and class (String) they are in
		Map<String, String> students = new HashMap<String, String>();
		
		/* The "put" method is used to add elements to a Map */

		students.put("Jason", "Java");
		students.put("Carl", "Java");
		students.put("Karol", "Java");
		students.put("Jeff", "Java");
		students.put("Ed", ".Net");
		students.put("Amy", ".Net");
		students.put("Zoran", ".Net");
		
		System.out.println("# of enterties in Map is: " + students.size());
		
		/* The "get" method is used to retrieve elements from a Map */
		
		// .get(key-you-want) - return the value associated with that key
		//							or null when the key is not found in the map
		System.out.println("------------ Display selected enteries from the Map ------------");
		
		System.out.println("Jeff is in " + students.get("Jeff") + " class");
		System.out.println("Amy is in " + students.get("Amy") + " class");
		System.out.println("Carl is in " + students.get("Carl") + " class");
		System.out.println("Frank is in " + students.get("Frank") + " class");
	
		/* keySet() returns a Set of all of the keys in the Map 
		 * 
		 * If you want to get all the keys in a Map so you can process all entries in the Map
		 * 		use the keySet() methods to get a Set of all the keys
		 * 
		 * You can then use a foreach loop to go through the Set and use each key
		 * */
		
		System.out.println("------------ Process all the entries in the Map ------------");
		
		Set<String> theKeys = students.keySet(); // Get all the keys form the Map
		
		for (String aKey : theKeys) {	// loop through the keys from the map
			System.out.println("Value for the key: " + aKey + " is " + students.get(aKey));
		}
		
		/* If the key already exists, put will overwrite the existing value with the new value */
		
		System.out.println("------------ Add a key that already exists ------------");
		
		String student2add = "Jason";
		
		if (students.containsKey(student2add)) {
			System.out.println("Key to be added already esists, so the value is updated instead");
		}
		else {
			System.out.println("Key to be added DOES NOT esists, so entery will be added");
		}
		
		students.put("Jason", ".Net"); // Trying to add a key that already exists
		//									it updates the value for the key
		//									it doesn't tell you it updated the value
		
		System.out.println("Jason is in " + students.get("Jason") + " class");
		
		
		/* .remove(key) - will remove an entry form a Map */

		System.out.println("------------ remove an entry from the Map ------------");
		
		students.remove("Jason"); // Remove the entry from the Map with the matching key
		
		Set<String> keys = students.keySet(); // Get all the keys form the Map
		
		for (String aKey : keys) {	// loop through the keys from the map
			System.out.println("Value for the key: " + aKey + " is " + students.get(aKey));
		}

		System.out.println("####################");
		System.out.println("       SETS");
		System.out.println("####################");
		System.out.println();



		System.out.println("####################");
		System.out.println("Sets cannot contain duplicates");
		System.out.println("####################");
		System.out.println();


		System.out.println("####################");
		System.out.println("Sets do not guarantee ordering");
		System.out.println("####################");
		System.out.println();



	}

}
