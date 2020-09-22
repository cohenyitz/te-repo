package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		
Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Please enter the temperature: ");
		double tempToBeConv = keyboard.nextInt();
		String aChar = keyboard.nextLine();
		
		System.out.println("Is the temperature in (C)elsius or (F)ahrenheit? (format: C or F) ");
		String celsiusOrFahrenheit = keyboard.nextLine();
		
		double celsiusToFarenheit = (tempToBeConv * 9 / 5) + 32;
		double farenheitToCelsius = (tempToBeConv - 32) * 5 / 9;
		if(celsiusOrFahrenheit.equals("C")) {
			System.out.println(tempToBeConv + "C " + " is " +  celsiusToFarenheit + "F");
		}
		if(celsiusOrFahrenheit.equals("F")) {
			System.out.println(tempToBeConv + "F " + " is " + farenheitToCelsius + "C");
		}

	}

}
