package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class testLucky13 {
	
	Lucky13 testClass = new Lucky13();
	
	/* Testing:
	 * 
	 * 1. If array does not contain 1 and 3 - expect true
	 * 2. Array does have 1 and 3 - expect false
	 * 3. If array contains 1 - expect false
	 * 4. If array contains 3 - expect false
	 * 
	 */

	@Test
	public void array_does_not_have_1_and_3() {
		int[] nums = {0,2,4};
		boolean numsNotToHave = testClass.getLucky(nums);
		assertEquals(true, numsNotToHave);
		
	}
	
	@Test
	public void array_does_have_1_and_3() {
		int[] nums = {1,2,3};
		boolean numsNotToHave = testClass.getLucky(nums);
		assertEquals(false, numsNotToHave);
		
	}
	
	@Test
	public void array_does_have_1() {
		int[] nums = {1,2,4};
		boolean numsNotToHave = testClass.getLucky(nums);
		assertEquals(false, numsNotToHave);
		
	}
	
	@Test
	public void array_does_have_3() {
		int[] nums = {0,2,3};
		boolean numsNotToHave = testClass.getLucky(nums);
		assertEquals(false, numsNotToHave);
		
	}

	

}
