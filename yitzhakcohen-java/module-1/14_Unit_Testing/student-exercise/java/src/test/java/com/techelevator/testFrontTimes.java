package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class testFrontTimes {
	
	FrontTimes testClass = new FrontTimes();
	
	/* Testing:
	 * 
	 * front of string is first 3 chars, return n copies of front - (Chocolate,2) expect "ChoCho"
	 * if String less than 3 chars return all chars times n copies (Ab,3) expect "AbAbAb"
	 * 
	 */

	@Test
	public void test_string_longer_than_3_chars() {
		String str = "Chocolate";
		int n = 2;
		String newString = testClass.generateString(str, n);
		assertEquals("ChoCho", newString);
	}
	
	@Test
	public void test_less_than_3_string() {
		String str = "Ab";
		int n = 3;
		String newString = testClass.generateString(str, n);
		assertEquals("AbAbAb", newString);
	}
	
	@Test
	public void test_string_longer_than_3_chars_bigger_n() {
		String str = "Chocolate";
		int n = 3;
		String newString = testClass.generateString(str, n);
		assertEquals("ChoChoCho", newString);
	}

}
