package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class VendingMachine {
	
	private Map<String, Product> mapOfInventory = new TreeMap<> ();
	private double userMoney;
	
	
	/**
	 * @return the mapOfInventory
	 */
	public Map<String, Product> getMapOfInventory() {
		return mapOfInventory;
	}

	public VendingMachine() throws FileNotFoundException {
		loadInventory();
	}
	public VendingMachine(double userMoney) {
		this.userMoney = userMoney; 
	}
	
		/**
	 * @return the userMoney
	 */
	public double getUserMoney() {
		return userMoney;
	}

	public void  loadInventory() throws FileNotFoundException {
		File inventoryFile = new File("vendingmachine.csv");
		Scanner readFile = new Scanner(inventoryFile);
		while (readFile.hasNext()) {
			String aLine = readFile.nextLine();
				
			String [] inventoryInformation = aLine.split("\\|");
					
			Product product = new Product(inventoryInformation[0], inventoryInformation[1],
					Double.parseDouble(inventoryInformation[2]), inventoryInformation[3]);
			 		
			mapOfInventory.put(inventoryInformation[0], product);
			}
			
		}
		
		@Override
		public String toString() {
			return "VendingMachine [mapOfInventory=" + mapOfInventory + "]";
		}

		public double addMoney(double newMoney) {
			userMoney += newMoney;
			return userMoney;
		}
		
		
		/**
		 * @param userMoney the userMoney to set
		 */
		public void setUserMoney(double userMoney) {
			this.userMoney = userMoney;
		}

		public String makeChange() {
			String yourChange = "";
		    double coinsGiven =  0;
		    DecimalFormat coinsValue = new DecimalFormat("###.##");
			double  cents   =   userMoney;
			int  quarters   =           0;
			int  dimes      =           0;
			int  nickels    =           0;
			
			if(cents == 0) {
				yourChange = "You have no change";
			}
				if(cents > 0) {
					cents = Double.parseDouble(coinsValue.format(cents));
					coinsGiven = (cents / .05);
					while(coinsGiven > 0) {
					if(coinsGiven == 1) {
						nickels += 1;
						coinsGiven -= 1;
					}
					if(coinsGiven == 2) {
						dimes += 1;
						coinsGiven -= 2;
					}
					if(coinsGiven == 3) {
						dimes += 1;
						nickels += 1;
						coinsGiven -= 3;
					}
					if(coinsGiven == 4) {
						dimes += 2;
						coinsGiven -= 4;
					}
					if(coinsGiven == 5) {
						quarters += 1;
						coinsGiven -= 5;
					}
					if(coinsGiven == 6) {
						quarters += 1;
						nickels += 1;
						coinsGiven -= 6;
					}
					if(coinsGiven == 7) {
						quarters += 1;
						dimes += 1;
						coinsGiven -= 7;
					}
					if(coinsGiven == 8) {
						quarters += 1;
						dimes +=1;
						nickels += 1;
						coinsGiven -= 8;
					}
					if(coinsGiven == 9) {
						quarters += 1;
						dimes += 2;
						coinsGiven -= 9;
					}
					if(coinsGiven == 10) {
						quarters += 2;
						coinsGiven -= 10;
					}
					if(coinsGiven == 11) {
						quarters += 2;
						nickels += 1;
						coinsGiven -= 11;
					}
					if(coinsGiven == 12) {
						quarters += 2;
						dimes += 1;
						coinsGiven -= 12;
					}
					if(coinsGiven == 13) {
						quarters += 2;
						dimes += 1;
						nickels +=1;
						coinsGiven -= 13;
					}
					if(coinsGiven == 14) {
						quarters += 2;
						dimes += 2;
						coinsGiven -= 14;
					}
					if(coinsGiven == 15) {
						quarters += 3;
						coinsGiven -= 15;
					}
					if(coinsGiven == 16) {
						quarters += 3;
						nickels += 1;
						coinsGiven -= 16;
					}
					if(coinsGiven == 17) {
						quarters += 3;
						dimes += 1;
						coinsGiven -= 17;
					}
					if(coinsGiven == 18) {
						quarters += 3;
						dimes += 1;
						nickels += 1;
						coinsGiven -= 18;
					}
					if(coinsGiven == 19) {
						quarters += 3;
						dimes += 2;
						coinsGiven -= 19;
					}
					if(coinsGiven == 20 || coinsGiven % 20 >= 1) {
						quarters += 4;
						coinsGiven -= 20;
					}
					}
					yourChange = "Your change is\n " + quarters + " quarter/s, " + dimes + " dime/s " + nickels + " nickel/s";
					
				}
			
			return yourChange;
			
		}
		public void audit(String name, String location, double userCurrent , double theBalance) throws FileNotFoundException {
			
			File auditData = new File("log.txt");
			try (PrintWriter addToAuditData = new PrintWriter(new FileOutputStream(auditData, true)))
					{
			
			Date date= new Date();
			
			String data = date + " " + name + " " + location + " " + userCurrent + " " + theBalance;
			addToAuditData.println(data + "\n");
			addToAuditData.print("");
			addToAuditData.close();
					}
					
	}		
		public void audit(String feedMoney, double userMoney2, double theBalance2) throws FileNotFoundException {
			File auditData = new File("log.txt");
			try (PrintWriter addToAuditData = new PrintWriter(new FileOutputStream (auditData, true)))
					{
			
			Date date = new Date();
			
			
			String data = date + " " + " " + feedMoney + " " + userMoney2 + " " + theBalance2;
					
			addToAuditData.println(data + "\n");
			addToAuditData.close();
		}
		}
			

		public void makeSalesReport() throws FileNotFoundException {
			
			File salesReport = new File("salesreport.txt");
			PrintWriter addToSalesReport = new PrintWriter(salesReport);
			
			Date date = new Date();
			addToSalesReport.println(date + "\n");
			
			Set<String> keySet = mapOfInventory.keySet();
			
			double totalAmountOfSales= 0.00;
			
			for(String aKey : keySet) {
				Product productLocation = mapOfInventory.get(aKey);
				int amountSold = 5 - productLocation.getStock();
				totalAmountOfSales = totalAmountOfSales + (amountSold * productLocation.getPrice());
				addToSalesReport.println(productLocation.getName() + " | " + amountSold);
				
			}
			addToSalesReport.println("\n Total Sales: $" + totalAmountOfSales);
			addToSalesReport.close();
		}

	}

