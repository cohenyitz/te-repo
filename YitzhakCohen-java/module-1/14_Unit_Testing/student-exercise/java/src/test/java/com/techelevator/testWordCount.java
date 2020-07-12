package com.techelevator;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class testWordCount {
	
	WordCount testClass = new WordCount();
	
	/* Testing:
	 * 
	 * Check to make sure array is not empty'
	 * ([]) -----> {}
	 * 
	 * check to make sure value equals the amount of times  key "words" are found in an array
	 * ["ba", "ba", "black", "sheep"] ---> {"ba" : 2, "black": 1, "sheep": 1 }
	 * ["a", "b", "a", "c", "b"] --------> {"b": 2, "c": 1, "a": 2}
	 * ["c", "b", "a"] ------------------> {"b": 1, "c": 1, "a": 1}
	 */

	@Test
	public void test() {
		String[] words = {"ba", "ba", "black", "sheep"};
		Map<String, Integer> output = testClass.getCount(words);
		System.out.println(output);
		
		assertTrue("{ba : 2, black : 1, sheep : 1 }", output);
	}

}
