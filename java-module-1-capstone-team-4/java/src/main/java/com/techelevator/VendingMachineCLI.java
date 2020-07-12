package com.techelevator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**************************************************************************************************************************
*  This is your Vending Machine Command Line Interface (CLI) class
*
*  It is the main process for the Vending Machine
*
*  THIS is where most, if not all, of your Vending Machine interactions should be coded
*  
*  It is instantiated and invoked from the VendingMachineApp (main() application)
*  
*  Your code should be placed in here
***************************************************************************************************************************/
import com.techelevator.view.Menu;         // Gain access to Menu class provided for the Capstone

public class VendingMachineCLI {
	
	
	
    // Main menu options defined as constants

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE      = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT          = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS,
													    MAIN_MENU_OPTION_PURCHASE,
													    MAIN_MENU_OPTION_EXIT
													    };
	
	private Menu vendingMenu;              // Menu object to be used by an instance of this class
	private VendingMachine theInventory;
	private VendingMachine theBank;
	public VendingMachineCLI(Menu menu) throws FileNotFoundException {  
		this.vendingMenu = menu;           // Make the Menu the user object passed, our Menu
		this.theInventory = new VendingMachine();
		this.theBank = new VendingMachine(0);
	}
	



	/**************************************************************************************************************************
	*  VendingMachineCLI main processing loop
	*  
	*  Display the main menu and process option chosen
	*
	*  It is invoked from the VendingMachineApp program
	*
	*  THIS is where most, if not all, of your Vending Machine objects and interactions 
	*  should be coded
	*
	*  Methods should be defined following run() method and invoked from it
	 * @throws FileNotFoundException 
	*
	***************************************************************************************************************************/

	public void run() throws FileNotFoundException {

		boolean shouldProcess = true;         // Loop control variable
		
		while(shouldProcess) {                // Loop until user indicates they want to exit
			
			String choice = (String)vendingMenu.getChoiceFromOptions(MAIN_MENU_OPTIONS);  // Display menu and get choice
			
			switch(choice) {                  // Process based on user menu choice
			
				case MAIN_MENU_OPTION_DISPLAY_ITEMS:
					displayItems();           // invoke method to display items in Vending Machine
					break;                    // Exit switch statement
			
				case MAIN_MENU_OPTION_PURCHASE:
					purchaseItems();          // invoke method to purchase items from Vending Machine
					break;                    // Exit switch statement
			
				case MAIN_MENU_OPTION_EXIT:
					endMethodProcessing();    // Invoke method to perform end of method processing
					shouldProcess = false;    // Set variable to end loop
					break;                    // Exit switch statement
			}	
		}
		return;                               // End method and return to caller
	}
/********************************************************************************************************
 * Methods used to perform processing
 * @throws FileNotFoundException 
 ********************************************************************************************************/
	public void displayItems() throws FileNotFoundException {      // static attribute used as method is not associated with specific object instance
		Map<String, Product> theProducts = theInventory.getMapOfInventory();
        Set<String> theKeys = theProducts.keySet(); // Get all the keys from the Map
		
		 for(String aKey : theKeys) {  // loop through the keys from the map
			 System.out.println("Location: " + aKey + " -- " + theProducts.get(aKey));
		 }
	}
	
	public void purchaseItems() throws FileNotFoundException {	 // static attribute used as method is not associated with specific object instance
		boolean keepShopping = true;
		Map<String, Product> theProducts = theInventory.getMapOfInventory();
        Set<String> theKeys = theProducts.keySet();
        Scanner keyboard = new Scanner(System.in);
		
        if(theBank.getUserMoney() == 0) {
			System.out.println("Please add money. Money needs to be in whole dollars ($1, $2, $5, $10)");
			
			double userMoneyInput = theBank.addMoney(keyboard.nextDouble());
			System.out.println("Balance: " + theBank.getUserMoney());
			keyboard.nextLine();
			String feedMoney = "FEED MONEY:";
			theInventory.audit(feedMoney ,  userMoneyInput, theBank.getUserMoney());
			} 
			if(theBank.getUserMoney() > 0) {
				System.out.println("Add more money? (y/n)");
				if(keyboard.nextLine().equals("n")) {
					while(keepShopping == true) {
					 for(String aKey : theKeys) {  
						 System.out.println("Location: " + aKey + " -- " + theProducts.get(aKey));
					 }
					System.out.println("Please make your selection ");
					String selection = keyboard.nextLine();
					if(theProducts.get(selection) == null || theProducts.get(selection).getStock() == 0) {
						System.out.println("Please make another selection");
					} else {
						theProducts.get(selection).setStock(theProducts.get(selection).getStock() - 1);
						theInventory.makeSalesReport();
						double afterPurchase = theBank.getUserMoney() - theProducts.get(selection).getPrice();
						theInventory.audit(theProducts.get(selection).getName() , theProducts.get(selection).getLocation(),  theBank.getUserMoney(), afterPurchase);
						
					System.out.println("You selected: " + theProducts.get(selection).getName() + ",\n" + theProducts.get(selection).consumptionNoise() 
							+ "\nYour balance is: " + theBank.addMoney(-theProducts.get(selection).getPrice()) + " -- Would you like to make another purchase? (y/n)");
					if(keyboard.nextLine().equals("y")){
						keepShopping = true;
					}
					else { keepShopping = false;
					}
					}
					System.out.println("Press 3 to get change and exit");
				}
				}else {
					System.out.println("Please add money. Money needs to be in whole dollars ($1, $2, $5, $10)");
					theBank.addMoney(keyboard.nextDouble());
					keyboard.nextLine();
					System.out.println("Balance: " + theBank.getUserMoney() + "\nPress 2 to make a selection or add more money");
					
				}	
			}
	}
	
	public void endMethodProcessing() throws FileNotFoundException { // static attribute used as method is not associated with specific object instance
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please type y to receive change");
		if(keyboard.nextLine().equals("y")) {
			System.out.println(theBank.makeChange()+ "\n \n Thank You, Have A Great Day!");
			String giveMoney = "GIVE MONEY:";
			double changeGiven = theBank.getUserMoney() - theBank.getUserMoney();
			theInventory.audit(giveMoney , theBank.getUserMoney(), changeGiven);
		} else {
			System.out.println("Invalid entry");
		}	
	}	
}
