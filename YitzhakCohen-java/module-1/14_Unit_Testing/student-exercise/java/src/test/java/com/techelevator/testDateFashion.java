package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class testDateFashion {
	
	DateFashion testClass = new DateFashion();

	/* Testing:
	 * 
	 * 1. if you || date is greater than or equal to 8 - expect 2(yes)
	 * 
	 * 2. if you || date is less than or equal to 2 - expect 0(no)
	 * 
	 * 3. if you && date is greater than 2 and less than 8 - expect 1(maybe)
	 * 
	 * 
	 * 
	 */
	@Test
	public void if_you_or_date_greater_than_8() {
		int you = 5;
		int date = 10;
		int reserveTable = testClass.getATable(you, date);
		assertEquals("You can reserve a table", 2, reserveTable);
		
	}
	
	@Test
	public void if_you_or_date_less_than_2() {
		int you = 5;
		int date = 2;
		int reserveTable = testClass.getATable(you, date);
		assertEquals("You can not reserve a table", 0, reserveTable);
		
	}

	@Test
	public void if_you_and_date_btwn_2_and_8() {
		int you = 5;
		int date = 5;
		int reserveTable = testClass.getATable(you, date);
		assertEquals("You can possibly reserve a table", 1, reserveTable);
		
	}


}
