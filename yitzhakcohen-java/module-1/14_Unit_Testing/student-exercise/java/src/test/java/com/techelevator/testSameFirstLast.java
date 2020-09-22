package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class testSameFirstLast {
	
	SameFirstLast testClass = new SameFirstLast();
	
	/* Testing:
	 * 
	 * if array is empty - return false
	 * if array length 1 or more element and the first and last elements are equal - return true
	 * if array length 1 or more element and the first and last elements are not equal - return false
	 */

	@Test
	public void array_is_empty_return_false() {
		int [] nums = null;
		boolean isArrayEmpty = testClass.isItTheSame(nums);
		assertEquals(false, isArrayEmpty);
	}
	
	@Test
	public void first_num_and_last_num_NOT_equal() {
		int [] nums = {1,2,3};
		boolean isNumsEqual = testClass.isItTheSame(nums);
		assertEquals(false, isNumsEqual);
	}
	
	@Test
	public void first_num_and_last_num_IS_equal() {
		int [] nums = {1,2,3,1};
		boolean isNumsEqual = testClass.isItTheSame(nums);
		assertEquals(true, isNumsEqual);
	}

}
