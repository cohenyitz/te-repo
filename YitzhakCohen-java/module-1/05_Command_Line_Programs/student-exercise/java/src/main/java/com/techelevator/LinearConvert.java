package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {
		
		// Meters to Feet || Feet to Meters Converter
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Please enter the length: ");
		int numToBeConv = keyboard.nextInt();
		String aChar = keyboard.nextLine();
		
		System.out.println("Is the measurment in (m)eters or (f)eet? (format: m or f) ");
		String metersOrFeet = keyboard.nextLine();
		
		if(metersOrFeet.equals("m")) {
			System.out.println(numToBeConv + "m " + " is " +  numToBeConv * 3.2808399 + "f");
		}
		if(metersOrFeet.equals("f")) {
			System.out.println(numToBeConv + "f " + " is " + numToBeConv * 0.3048 + "m");
		}
	
		
		
	}

}
