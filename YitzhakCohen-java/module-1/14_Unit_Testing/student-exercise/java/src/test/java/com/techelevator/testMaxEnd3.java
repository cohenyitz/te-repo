package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class testMaxEnd3 {
	
	MaxEnd3 testClass = new MaxEnd3();
	
	/*Testing:
	 * 
	 * Find the largest 'nums' in an array between first and last element and set all other elements in the array to that 'nums'
	 * 
	 */

	@Test
	public void test_largest_nums_3() {
		int[] nums = {1,2,3};
		int[] expectedResult = {3,3,3};
		int[] newArrayOfNums = testClass.makeArray(nums);
		assertArrayEquals(expectedResult, newArrayOfNums);
	}

	@Test
	public void test_largest_array_11() {
		int[] nums = {11,5,9};
		int[] expectedResult = {11,11,11};
		int[] newArrayOfNums = testClass.makeArray(nums);
		assertArrayEquals(expectedResult, newArrayOfNums);
	}
	
	@Test
	public void test() {
		int[] nums = {2,11,3};
		int[] expectedResult = {3,3,3};
		int[] newArrayOfNums = testClass.makeArray(nums);
		assertArrayEquals(expectedResult, newArrayOfNums);
	}
}
