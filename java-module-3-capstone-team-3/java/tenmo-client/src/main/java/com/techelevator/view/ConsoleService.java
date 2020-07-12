package com.techelevator.view;


import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.List;
import java.util.Scanner;

import com.techelevator.tenmo.models.AuthenticatedUser;
import com.techelevator.tenmo.models.Transfer;
import com.techelevator.tenmo.models.User;
import com.techelevator.tenmo.services.AccountServices;
import com.techelevator.tenmo.services.TransferServices;
import com.techelevator.tenmo.services.UserServices;

public class ConsoleService {

	private PrintWriter out;
	private Scanner in;
	private TransferServices transferServices;
	

	public ConsoleService(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output, true);
		this.in = new Scanner(input);
	}

	public Object getChoiceFromOptions(Object[] options) {
		Object choice = null;
		while (choice == null) {
			displayMenuOptions(options);
			choice = getChoiceFromUserInput(options);
		}
		out.println();
		return choice;
	}

	private Object getChoiceFromUserInput(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if (selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch (NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will be null
		}
		if (choice == null) {
			out.println("\n*** " + userInput + " is not a valid option ***\n");
		}
		return choice;
	}

	private void displayMenuOptions(Object[] options) {
		out.println();
		for (int i = 0; i < options.length; i++) {
			int optionNum = i + 1;
			out.println(optionNum + ") " + options[i]);
		}
		out.print("\nPlease choose an option >>> ");
		out.flush();
	}

	/***********************************************************
	 Added Use Case 6 - Transfer details
	 ***********************************************************/
	
	public void displayTransferDetails(Transfer selectATransfer, 
									   String usernameFrom, 
									   String usernameTo, 
									   String accountType, 
									   String status) 
	{
		System.out.println("----------------");
		System.out.println("Transfer Details");
		System.out.println("----------------");
		System.out.println("Id: " + selectATransfer.getTransferId());
		System.out.println("From: " + usernameFrom);
		System.out.println("To: " + usernameTo);
		System.out.println("Type: " + accountType);
		System.out.println("Status: " + status);
		System.out.println("Amount: " + currencyFormatter(selectATransfer.getAmount()));
	}
	/***********************************************************
	 Use Case 6 - End 
	 ***********************************************************/
	
	public String getUserInput(String prompt) {
		out.print(prompt+": ");
		out.flush();
		return in.nextLine();
	}

	public Integer getUserInputInteger(String prompt) {
		Integer result = null;
		do {
			out.print(prompt+": ");
			out.flush();
			String userInput = in.nextLine();
			try {
				result = Integer.parseInt(userInput);
			} catch(NumberFormatException e) {
				out.println("\n*** " + userInput + " is not valid ***\n");
			}
		} while(result == null);
		return result;
	}
	
	public void viewCurrentBalance(double currentBalance) {
		System.out.println("The current balance is: " + currencyFormatter(currentBalance));
	}
	
	public void viewTransferHistory(Transfer[] transfers, String[] fromOrTo, String[] otherParty) {
		System.out.println("------------------------------------------------");
		System.out.println(String.format("%1$-15s", "Transfer ID") + String.format("%1$-16s", "From/To") + String.format("%1$-5s", "Amount"));
		System.out.println("------------------------------------------------");
		for (int i = 0; i < transfers.length; i++) {
			System.out.println(String.format("%1$-15s",transfers[i].getTransferId()) 
					           + String.format("%1$-6s", fromOrTo[i])  
							   + String.format("%1$-10s",otherParty[i]) 
							   + currencyFormatter(transfers[i].getAmount()));
		}
		System.out.println("------------------------------------------------");
	}

	public void viewPendingRequests(Transfer[] pendingRequests, String[] otherParty) {
		System.out.println("------------------------------------------------");
		System.out.println(String.format("%1$-15s", "Pending ID") + String.format("%1$-16s", "To") + String.format("%1$-5s", "Amount"));
		System.out.println("------------------------------------------------");
		for (int i = 0; i < pendingRequests.length; i++) {
			System.out.println(String.format("%1$-15s",pendingRequests[i].getTransferId()) 
							   + String.format("%1$-16s",otherParty[i]) 
							   + currencyFormatter(pendingRequests[i].getAmount()));
		}
		System.out.println("------------------------------------------------");
	}
	
	public void displayUsers(User[] users, int currentID) {
		System.out.println("------------------------------------------------");
		System.out.println(String.format("%1$-15s", "User's ID") + String.format("%1$-10s", "Name"));
		for (User user : users) {
			if (user.getId() != currentID) {
			System.out.println(String.format("%1$-15s",user.getId()) + String.format("%1$-10s",user.getUsername()));
			}
		}
		System.out.println("------------------------------------------------");
	}
	public int sendBucksPrompt() {
		System.out.print("Enter ID of user you are sending to (0 to cancel): "); // prompt user to see what id  to send money to
		Scanner userInput = new Scanner(System.in);
		int idPrompt = userInput.nextInt();
		userInput.nextLine();
		return idPrompt;
	}
	
	public int requestBucksPrompt() {
		System.out.print("Enter ID of user you are requesting from (0 to cancel): "); // prompt user to see what id  to send money to
		Scanner userInput = new Scanner(System.in);
		int idPrompt = userInput.nextInt();
		userInput.nextLine();
		return idPrompt;
	}
	
	public double amountToSendPrompt() {
		System.out.print("Enter amount: $");
		Scanner userInput = new Scanner(System.in);
		double amountPrompt = userInput.nextDouble();
		userInput.nextLine();
		return amountPrompt;
	}
	
	public double amountToRequestPrompt() {
		System.out.print("Enter amount: $");
		Scanner userInput = new Scanner(System.in);
		double amountPrompt = userInput.nextDouble();
		userInput.nextLine();
		return amountPrompt;
	}
	
	public int moreDetailsPrompt() {
		System.out.print("Please enter transfer ID to view details (0 to cancel): "); // prompt user to see what id  to send money to
		Scanner userInput = new Scanner(System.in);
		int idPrompt = userInput.nextInt();
		userInput.nextLine();
		return idPrompt;
	}
	
	public int approveRejectPrompt() {
		System.out.print("Please enter transfer ID to approve/reject (0 to cancel): "); // prompt user to see what id  to send money to
		Scanner userInput = new Scanner(System.in);
		int idPrompt = userInput.nextInt();
		userInput.nextLine();
		return idPrompt;
	}
	
	public int DisplayApproveRejectScreen() {
		System.out.println("------------------------------------------------");
		System.out.println("1: Approve");
		System.out.println("2: Reject");
		System.out.println("0: Don't approve or reject");
		System.out.println("------------------------------------------------");
		System.out.print("Please chose an option: "); // prompt user to see what id  to send money to
		Scanner userInput = new Scanner(System.in);
		int option = userInput.nextInt();
		userInput.nextLine();
		return option;
	}
	
	public void displayNotEnoughFunds() {
		System.out.println("");
		System.out.println("Sorry, you do not have enough funds to send this amount");
	}

	public String currencyFormatter(double amount) {
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
		return currencyFormatter.format(amount);
	}
}
