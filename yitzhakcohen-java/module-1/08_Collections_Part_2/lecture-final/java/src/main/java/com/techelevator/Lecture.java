package com.techelevator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("       MAPS");
		System.out.println("####################");
		System.out.println();

		/* Map is an interface and HashMap is a class that implements Map 
		 * 
		 * Two common types of Maps: HashMap - Stores data in any order it wants to (faster)
		 *                           TreeMap - Stores data in sort order (slower)
		 *
		 */
		
		//  Define a Map:  Map<key-type, value-type> name = new HashMap<key-type,value-type>();
	
		// Define a map to hold a name (String) and class they are in (String)
		
		Map<String, String> students = new TreeMap<String, String>();

		/* The "put" method is used to add elements to a Map */
		
		students.put("Jason", "Java");  // .put(key, value)
		students.put("Carl", "Java");
		students.put("Karol", "Java");
		students.put("Jeff", "Java");
		students.put("Ed", ".NET");
		students.put("Amy", ".NET");
		students.put("Zoran", ".NET");
		
		System.out.println("# of entries in Map is: " + students.size());

		/* The "get" method is used to retrieve elements from a Map */
		
		// .get(key-you-want) - return the value associated with that key
		//                             or null is the key is not found in the map
		System.out.println("\n---- Display selected entries from the Map ----");
		System.out.println("Jeff is in " + students.get("Jeff") + " class");
		System.out.println("Jason is in " + students.get("Jason") + " class");
		System.out.println("Amy is in " + students.get("Amy") + " class");
		System.out.println("Carl is in " + students.get("Carl") + " class");
		System.out.println("Billy is in " + students.get("Billy") + " class");
	
		/* keySet() returns a Set of all of the keys in the Map 
		 * 
		 * If you want to get all keys in a Map so you can process all entries in the Map
		 *     use the keySet() method to get a Set of all the keys
		 *     
		 * You can then use a for-each loop to go through the Set and use it's key
		 * */
		
		 System.out.println("\n---- Process all the entries in the Map ----");
		
		 Set<String> theKeys = students.keySet(); // Get all the keys from the Map
		 
		 for(String aKey : theKeys) {  // loop through the keys from the map
			 System.out.println("Value for key: " + aKey + " is " +students.get(aKey));
		 }
		
		/* If the key already exists, put will overwrite the existing value with the new value */

		System.out.println("\n---- Add a key that already exists ----");
		
		String student2add = "Jason";
		
		if (students.containsKey(student2add)) {
			System.out.println("Key to be added already exists, so it will not be added");	
		}
		else {
			System.out.println("Key to added DOES NOT exists, so entry will be added");
			students.put(student2add, ".NET");  // Try to add a key that already exists
		}
		
		students.put(student2add, ".NET");  // Try to add a key that already exists	
		                                    //    it updates the value for the key
		                                    //    it does not tell you it updated the value
		
		System.out.println("Jason is in " + students.get("Jason") + " class");
	
		
		/* .remove(key) - will remove an entry from a Map */
		
		System.out.println("\n---- remove an entry from the Map ----");
		
		students.remove("Jason");  // Remove the entry from the map the matching key
		
		Set<String> keys = students.keySet(); // Get all the keys from the Map
		 
		for(String aKey : keys) {  // loop through the keys from the map
			 System.out.println("Value for key: " + aKey + " is " +students.get(aKey));
		 }
	/***************************************************************************************
	 * List all the keys with a specific value in the Map:
	 * 
	 *    1. Get all the keys in the Map
	 *    2. Loop through the keys one at at a time.
	 *         a. If the value for the current key matches the one you want, display it
	 *               if it doesn't, do nothing, continue in the loop
	 * 
	 ***************************************************************************************/	
	
		System.out.println("\n---- List all the keys for a specific value ----");
		
		String valueWeWant = "Java";               // Define a variable to hold the value we want to search for
		Set<String> keysInMap = students.keySet(); // Get all the keys from the Map
		 
		for(String aKey : keysInMap) {                                 // loop through the keys from the map
			if (students.get(aKey).equals(valueWeWant)) {              //      Does the value for the current match the one we want?
			System.out.println(aKey + " has the value " + valueWeWant);//      Display the key and value
		    }
		}
		System.out.println();    // Display a blank line
		
		System.out.println("####################");
		System.out.println("       SETS");
		System.out.println("####################");
		System.out.println();

		Set<String> studentsSet = new HashSet<String>(); // change HashSet to TreeSet or LinkedHashSet to see how the behavior changes

		System.out.println("####################");
		System.out.println("Sets cannot contain duplicates");
		System.out.println("####################");
		System.out.println();

		studentsSet.add("Jim");
		System.out.println("Added Jim");
		studentsSet.add("Seth");
		System.out.println("Added Seth");
		studentsSet.add("Dan");
		System.out.println("Added Dan");
		studentsSet.add("Jim"); // this value will be ignored because it is duplicate
		System.out.println("Added Jim again");
		System.out.println();

		System.out.println("####################");
		System.out.println("Sets do not guarantee ordering");
		System.out.println("####################");
		System.out.println();

		System.out.println("Set of students contains:");
		for (String studentName : studentsSet) { // note that the values are returned in a different order than they were added
			System.out.println(studentName + " : Hash = " + studentName.hashCode());
		}
		System.out.println();
		System.out.println("note that the values may be returned in a different order than they were added");
		System.out.println();

	}
}

