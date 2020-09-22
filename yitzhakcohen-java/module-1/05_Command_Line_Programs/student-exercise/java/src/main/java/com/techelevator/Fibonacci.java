package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Please enter a Fibonacci number: ");
		int fibNumber = keyboard.nextInt();
		String aChar = keyboard.nextLine();
		
		
		int i = 0, j = 1;
		while (i <= fibNumber) {
			System.out.print(i + "  ");
			int sum = i + j;
			i = j;
			j = sum;
			
			
		}
		
		
	}

}
