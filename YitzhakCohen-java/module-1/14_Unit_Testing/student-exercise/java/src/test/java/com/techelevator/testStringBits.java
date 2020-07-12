package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class testStringBits {
	
	StringBits testClass = new StringBits();
	
	/* Testing:
	 * 
	 *  a new string made of every other char starting with
	 * the first
	 * 
	 * "Hello" ---expect "Hlo"
	 * "Hi" ------expect "H"
	 * "Heeololeo"expect "Hello"
	 * "" expects ""
	 * 
	 */

	@Test
	public void test_string_hello() {
		String str = "Hello";
		String newString = testClass.getBits(str);
		assertEquals("Hlo", newString);
		//System.out.println(newString);
	}
	
	@Test
	public void test_string_hi() {
		String str = "Hi";
		String newString = testClass.getBits(str);
		assertEquals("H", newString);
		//System.out.println(newString);
	}
	
	@Test
	public void test_string_Heeololeo() {
		String str = "Heeololeo";
		String newString = testClass.getBits(str);
		assertEquals("Hello", newString);
		//System.out.println(newString);
	}
	

	@Test
	public void test_string_empty() {
		String str = "";
		String newString = testClass.getBits(str);
		assertEquals("", newString);
		//System.out.println(newString);
	}

}
