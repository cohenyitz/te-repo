package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Module1CodingAssessment {

	public static void main(String[] args) throws FileNotFoundException {
	
		
		File tellerInput = new File("TellerInput.csv");
		Scanner readFile = new Scanner(tellerInput);
		
		while(readFile.hasNext()) {
			String aLine = readFile.nextLine();
			String[] tellerInfo = aLine.split(",");

			
			TellerMachine test = new TellerMachine( tellerInfo[0], Double.parseDouble(tellerInfo[1]),  Double.parseDouble(tellerInfo[2]) ); {
				test.toString();
				System.out.println(test);
			}
			
		}

	}

}
