package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FizzWriter {
	
	public static void main(String[] args) throws FileNotFoundException {
	
			try (PrintWriter dataOutput = new PrintWriter("FizzBuzz.txt")) {
				
		
				for (int i = 1; i <= 300; i++) {
					if (i % 3 == 0 && i % 5 == 0) {
						dataOutput.println("FizzBuzz");
					}
					else if (i % 3 == 0) {
						dataOutput.println("Fizz");
					}
					else if (i % 5 == 0) {
					dataOutput.println("Buzz");
					} else {
						dataOutput.println(i);
					}	
				}	
				
				
						}
			}		
	
}
