package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class testNonStart {
	
	NonStart testClass = new NonStart();
	
	/* Testing:
	 * 
	 * Test to see if Strings concatenate and that first letter of each String is cut off 
	 * 
	 */

	@Test
	public void test_string_hello_there() {
		String a = "Hello";
		String b = "There";
		String newString = testClass.getPartialString(a, b);
		assertEquals("ellohere", newString);
		System.out.println(newString);
	}
	
	@Test
	public void test_string_java_code() {
		String a = "java";
		String b = "code";
		String newString = testClass.getPartialString(a, b);
		assertEquals("avaode", newString);
		System.out.println(newString);	
	}
	
	@Test
	public void test_string_shotl_java() {
		String a = "shotl";
		String b = "java";
		String newString = testClass.getPartialString(a, b);
		assertEquals("hotlava", newString);
		System.out.println(newString);	
	}

}
