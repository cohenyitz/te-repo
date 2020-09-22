package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class testLess20 {
	
	Less20 testClass = new Less20();
	
	/* Testing:
	 * 
	 * 1. If n is 1 less than multiple of 20 - expect true 
	 * 2. If n is 2 less than multiple of 20 - expect true
	 * 3. If n is multiple of 20 - expect false
	 * 
	 */

	@Test
	public void if_n_is_1_less_than_multiple_of_20() {
		int n = 19;
		boolean lessThanMultipleOf20 = testClass.isLessThanMultipleOf20(n);
		assertEquals(true,lessThanMultipleOf20);
	}
	
	@Test
	public void if_n_is_2_less_than_multiple_of_20() {
		int n = 18;
		boolean lessThanMultipleOf20 = testClass.isLessThanMultipleOf20(n);
		assertEquals(true,lessThanMultipleOf20);
	}
	
	@Test
	public void if_n_is_multiple_of_20() {
		int n = 20;
		boolean lessThanMultipleOf20 = testClass.isLessThanMultipleOf20(n);
		assertEquals(false,lessThanMultipleOf20);
	}

}
