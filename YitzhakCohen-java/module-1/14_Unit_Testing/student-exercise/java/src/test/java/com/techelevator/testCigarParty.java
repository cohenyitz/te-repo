package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class testCigarParty {
	
	// Define an object for the class with the methods to test
	
	CigarParty testClass = new CigarParty();  // instantiate an object for the class with the methods you want to test

	/*Testing:
	 * 
	 * Need to have 40 to 60 Cigars, unless its weekend, at least 40
	 * 
	 * 		1. Test having 40 cigars and its not the weekend
	 * 		2. Test having 40 cigars and it IS a weekend
	 * 		3. Test having 60 cigars and it IS a weekend
	 * 		4. Test having 60 cigars and its not the weekend
	 * 
	 * 		5. Test having less than 40 cigars and its not the weekend
	 * 		6. Test having less than 40 cigars and it IS a weekend
	 * 		7. Test having more than 60 cigars and it IS a weekend
	 * 		8. Test having more than 60 cigars and its not the weekend
	 * 		9. Test having between 40 and 60 cigars and its a weekend
	 * 		10.Test having between 40 and 60 cigars and its NOT the weekend
	 */
	@Test
	public void test_having_40_cigars_and_NOT_weekend() {
		int cigars = 40;
		boolean isWeekend = false;
		boolean shouldHaveParty = testClass.haveParty(cigars, !isWeekend);
		assertEquals("Cigar Party should equal: ", true, shouldHaveParty);
	}
	
	@Test
	public void test_having_40_cigars_and_IS_weekend() {
		int cigars = 40;
		boolean isWeekend = true;
		boolean shouldHaveParty = testClass.haveParty(cigars, isWeekend);
		assertEquals("Cigar Party should equal: ", true, shouldHaveParty);
	}
	
	@Test
	public void test_having_60_cigars_and_IS_weekend() {
		int cigars = 60;
		boolean isWeekend = true;
		boolean shouldHaveParty = testClass.haveParty(cigars, isWeekend);
		assertEquals("Cigar Party should equal: ", true, shouldHaveParty);
	}
	
	@Test
	public void test_having_60_cigars_and_NOT_weekend() {
		int cigars = 60;
		boolean isWeekend = false;
		boolean shouldHaveParty = testClass.haveParty(cigars, !isWeekend);
		assertEquals("Cigar Party should equal: ", true, shouldHaveParty);
	}
	
	@Test
	public void test_having_less_than_40_cigars_and_NOT_weekend() {
		int cigars = 40;
		boolean isWeekend = false;
		if (cigars < 40 && isWeekend) {
			boolean shouldHaveParty = testClass.haveParty(cigars, !isWeekend);
			assertEquals("Cigar Party should equal: ", false, shouldHaveParty);
		}
	}
		
		@Test
		public void test_having_less_than_40_cigars_and_IS_weekend() {
			int cigars = 40;
			boolean isWeekend = true;
			if (cigars < 40 && isWeekend) {
				boolean shouldHaveParty = testClass.haveParty(cigars, isWeekend);
				assertEquals("Cigar Party should equal: ", false, shouldHaveParty);
			}
	}
		@Test
		public void test_having_more_than_60_cigars_and_IS_weekend() {
			int cigars = 60;
			boolean isWeekend = true;
			if (cigars > 60 && isWeekend) {
				boolean shouldHaveParty = testClass.haveParty(cigars, isWeekend);
				assertEquals("Cigar Party should equal: ", true, shouldHaveParty);
			}
		}
		
		@Test
		public void test_having_more_than_60_cigars_and_NOT_weekend() {
			int cigars = 60;
			boolean isWeekend = false;
			if (cigars > 60 && isWeekend) {
				boolean shouldHaveParty = testClass.haveParty(cigars, !isWeekend);
				assertEquals("Cigar Party should equal: ", false, shouldHaveParty);
			}
		}	

		@Test
		public void test_having_between_40_and_60_cigars_and_IS_weekend() {
			int cigars = 40;
			boolean isWeekend = true;
			if (cigars >= 40 && cigars <= 60 && isWeekend) {
				boolean shouldHaveParty = testClass.haveParty(cigars, isWeekend);
				assertEquals("Cigar Party should equal: ", true, shouldHaveParty);
			}
		}	
		
		@Test
		public void test_having_between_40_and_60_cigars_and_NOT_weekend() {
			int cigars = 40;
			boolean isWeekend = false;
			if (cigars >= 40 && cigars <= 60 && isWeekend) {
				boolean shouldHaveParty = testClass.haveParty(cigars, !isWeekend);
				assertEquals("Cigar Party should equal: ", true, shouldHaveParty);
			}
		}	

}
		
