package com.techelevator.tenmo;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import com.techelevator.tenmo.models.AuthenticatedUser;
import com.techelevator.tenmo.models.Transfer;
import com.techelevator.tenmo.models.User;
import com.techelevator.tenmo.models.UserCredentials;
import com.techelevator.tenmo.services.AccountServices;
import com.techelevator.tenmo.services.AuthenticationService;
import com.techelevator.tenmo.services.AuthenticationServiceException;
import com.techelevator.tenmo.services.TransferServices;
import com.techelevator.tenmo.services.UserServices;
import com.techelevator.view.ConsoleService;

public class App {

private static final String API_BASE_URL = "http://localhost:8080";
    
    private static final String MENU_OPTION_EXIT = "Exit";
    private static final String LOGIN_MENU_OPTION_REGISTER = "Register";
	private static final String LOGIN_MENU_OPTION_LOGIN = "Login";
	private static final String[] LOGIN_MENU_OPTIONS = { LOGIN_MENU_OPTION_REGISTER, 
														 LOGIN_MENU_OPTION_LOGIN, 
														 MENU_OPTION_EXIT 
														 };
	private static final String MAIN_MENU_OPTION_VIEW_BALANCE = "View your current balance";
	private static final String MAIN_MENU_OPTION_SEND_BUCKS = "Send TE bucks";
	private static final String MAIN_MENU_OPTION_VIEW_PAST_TRANSFERS = "View your past transfers";
	private static final String MAIN_MENU_OPTION_REQUEST_BUCKS = "Request TE bucks";
	private static final String MAIN_MENU_OPTION_VIEW_PENDING_REQUESTS = "View your pending requests";
	private static final String MAIN_MENU_OPTION_LOGIN = "Login as different user";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_VIEW_BALANCE, 
														MAIN_MENU_OPTION_SEND_BUCKS, 
														MAIN_MENU_OPTION_VIEW_PAST_TRANSFERS, 
														MAIN_MENU_OPTION_REQUEST_BUCKS, 
														MAIN_MENU_OPTION_VIEW_PENDING_REQUESTS, 
														MAIN_MENU_OPTION_LOGIN, MENU_OPTION_EXIT 
														};
	
    private AuthenticatedUser currentUser;
    private ConsoleService console;
    private AuthenticationService authenticationService;
	private AccountServices accountServices;
	private UserServices userServices;
	private TransferServices transferServices;


    public static void main(String[] args) 
    {
    	App app = new App(new ConsoleService(System.in, System.out), 
    			  new AuthenticationService(API_BASE_URL), 
    			  new AccountServices(API_BASE_URL), 
    			  new UserServices(API_BASE_URL), 
    			  new TransferServices(API_BASE_URL));
    	app.run();
    }
    Scanner tenmoScanner = new Scanner(System.in);
    String aLine = "";
    
    public App(ConsoleService console, 
    		   AuthenticationService authenticationService, 
    		   AccountServices accountServices, 
    		   UserServices userServices, 
    		   TransferServices transferServices) 
    {
		this.console = console;
		this.authenticationService = authenticationService;
		this.accountServices = accountServices;
		this.userServices = userServices;
		this.transferServices = transferServices;
	}

	public void run() {
		System.out.println("*********************");
		System.out.println("* Welcome to TEnmo! *");
		System.out.println("*********************");
		
		registerAndLogin();
		mainMenu();
	}

	private void mainMenu() {
		while(true) {
			String choice = (String)console.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			if(MAIN_MENU_OPTION_VIEW_BALANCE.equals(choice)) {
				viewCurrentBalance();
			} else if(MAIN_MENU_OPTION_VIEW_PAST_TRANSFERS.equals(choice)) {
				viewTransferHistory();
			} else if(MAIN_MENU_OPTION_VIEW_PENDING_REQUESTS.equals(choice)) {
				viewPendingRequests();
			} else if(MAIN_MENU_OPTION_SEND_BUCKS.equals(choice)) {
				sendBucks();
			} else if(MAIN_MENU_OPTION_REQUEST_BUCKS.equals(choice)) {
				requestBucks();
			} else if(MAIN_MENU_OPTION_LOGIN.equals(choice)) {
				login();
			} else {
				// the only other option on the main menu is to exit
				exitProgram();
			}
		}
	}

	private void viewCurrentBalance() {
		int userID = currentUser.getUser().getId(); //get user id 
		double currentBalance = accountServices.getUserAccount(currentUser.getToken(), userID).getBalance(); // calling on getUserAccount method in accountServices to be able to get the balance based on user id 
		console.viewCurrentBalance(currentBalance); // displaying information by calling on consoleService
		mainMenu();
	}

	private void viewTransferHistory() {
		int userID = currentUser.getUser().getId();
		int accountNumber = accountServices.getUserAccount(currentUser.getToken(), userID).getAccountId();
		Transfer [] transferHistory = transferServices.getTransferHistory(currentUser.getToken(), accountNumber);
		// store all data received in transferHistory array
		String[] fromOrTo = new String[transferHistory.length];
		String[] otherParty = new String[transferHistory.length];
		for (int i = 0; i < transferHistory.length; i++) {			//loop through transferHistory array
			if (transferHistory[i].getAccountFrom() == accountNumber) { //if account_From is equal to account number
				fromOrTo[i] = "To:   "; //set fromOrTo to that account number and otherParty gets set to account_To
				otherParty[i] = userServices.getUserWithAccount(currentUser.getToken(), transferHistory[i].getAccountTo()).getUsername();
			} else {
				fromOrTo[i] = "From: "; // else (if account_From is not equal to accountNumber..set fromOrTo to accountNumber and otherParty to account_From
				otherParty[i] = userServices.getUserWithAccount(currentUser.getToken(), transferHistory[i].getAccountFrom()).getUsername();
			}
		}
		console.viewTransferHistory(transferHistory, fromOrTo, otherParty);	
		
		int transferID = console.moreDetailsPrompt();
		
		viewTransferDetails(transferID);
	}
	
	private void viewTransferDetails(int transferID) {
		if (transferID == 0) {
			return;
		}
		Transfer selectATransfer = transferServices.getTransferById(currentUser.getToken(), transferID);
		String usernameFrom = userServices.getUserWithAccount(currentUser.getToken(), selectATransfer.getAccountFrom()).getUsername();
		String usernameTo = userServices.getUserWithAccount(currentUser.getToken(), selectATransfer.getAccountTo()).getUsername();
		
		String accountType = "";
		if (selectATransfer.getTransferTypeId() == 1) {
			accountType = "Request";
		} else {
			accountType = "Send";
		}
		
		String status = "";
		if (selectATransfer.getTransferStatusId() == 1) {
			status = "Pending";
		} else if (selectATransfer.getTransferStatusId() == 2) {
			status = "Approved";
		} else status = "Rejected";
	
		console.displayTransferDetails(selectATransfer, usernameFrom, usernameTo, accountType, status);	
	}

	private void viewPendingRequests() {
		int userID = currentUser.getUser().getId();
		int accountNumber = accountServices.getUserAccount(currentUser.getToken(), userID).getAccountId();
		Transfer [] pendingRequests = transferServices.getPendingTransfers(currentUser.getToken(), accountNumber);
		
		String[] otherParty = new String[pendingRequests.length];
		for (int i = 0; i < pendingRequests.length; i++) {
			otherParty[i] = userServices.getUserWithAccount(currentUser.getToken(), pendingRequests[i].getAccountTo()).getUsername();
		}
		console.viewPendingRequests(pendingRequests, otherParty);
		
		approveOrReject(userID);
	}
	
	private void approveOrReject(int userIDFrom) {
		int transactionToApproveReject = console.approveRejectPrompt();
		if (transactionToApproveReject == 0) {
			return;
		}
		Transfer theTransfer = transferServices.getTransferById(currentUser.getToken(), transactionToApproveReject);
		int userIDTo = userServices.getUserWithAccount(currentUser.getToken(), theTransfer.getAccountTo()).getId();
		double amount = theTransfer.getAmount();
		
		int approvalChoice = console.DisplayApproveRejectScreen();
		if (approvalChoice == 0) {
			return;
		}
		
		if (approvalChoice == 1) {
			
			if(amount> accountServices.getUserAccount(currentUser.getToken(), userIDFrom).getBalance()) {
				console.displayNotEnoughFunds();
				return;
			}
			
			theTransfer.setTransferStatusId(2);
			transferServices.updateTransferStatus(currentUser.getToken(), theTransfer);
			accountServices.withdraw(currentUser.getToken(), userIDFrom, amount);
			accountServices.deposit(currentUser.getToken(), userIDTo, amount);
		}
		
		if (approvalChoice == 2 ) {
			theTransfer.setTransferStatusId(3);
			transferServices.updateTransferStatus(currentUser.getToken(), theTransfer);
		}
		
	}

	private void sendBucks() {
		User[] listOfUsers = userServices.listAll(currentUser.getToken());
		int idToSendFrom = currentUser.getUser().getId();
		console.displayUsers(listOfUsers, idToSendFrom);
		
		int idToSendTo = console.sendBucksPrompt();
		if (idToSendTo == 0) {
			return;
		}
		
		double amountToSend = console.amountToSendPrompt();
		int accountFrom = accountServices.getUserAccount(currentUser.getToken(), idToSendFrom).getAccountId();
		int accountTo = accountServices.getUserAccount(currentUser.getToken(), idToSendTo).getAccountId();
		
		if(amountToSend > accountServices.getUserAccount(currentUser.getToken(), idToSendFrom).getBalance()) {
			console.displayNotEnoughFunds();
			return;
		}
		
		transferServices.makeSend(currentUser.getToken(), accountFrom, accountTo, amountToSend);

		accountServices.withdraw(currentUser.getToken(), idToSendFrom, amountToSend);
		accountServices.deposit(currentUser.getToken(), idToSendTo, amountToSend);
	}

	private void requestBucks() {
		User[] users = userServices.listAll(currentUser.getToken());
		int idRequestFrom = currentUser.getUser().getId();
		console.displayUsers(users, idRequestFrom);
		
		int idToRequestFrom = console.requestBucksPrompt();
		if (idToRequestFrom == 0) {
			return;
		}
		
		double amountToRequest = console.amountToRequestPrompt();
		int acountFrom = accountServices.getUserAccount(currentUser.getToken(), idRequestFrom).getAccountId();
		int acountTo = accountServices.getUserAccount(currentUser.getToken(), idToRequestFrom).getAccountId();
		transferServices.makeRequest(currentUser.getToken(), acountFrom, acountTo, amountToRequest);
	}
	
	private void exitProgram() {
		System.exit(0);
	}

	private void registerAndLogin() {
		while(!isAuthenticated()) {
			String choice = (String)console.getChoiceFromOptions(LOGIN_MENU_OPTIONS);
			if (LOGIN_MENU_OPTION_LOGIN.equals(choice)) {
				login();
			} else if (LOGIN_MENU_OPTION_REGISTER.equals(choice)) {
				register();
			} else {
				// the only other option on the login menu is to exit
				exitProgram();
			}
		}
	}

	private boolean isAuthenticated() {
		return currentUser != null;
	}

	private void register() {
		System.out.println("Please register a new user account");
		boolean isRegistered = false;
        while (!isRegistered) //will keep looping until user is registered
        {
            UserCredentials credentials = collectUserCredentials();
            try {
            	authenticationService.register(credentials);
            	isRegistered = true;
            	System.out.println("Registration successful. You can now login.");
            } catch(AuthenticationServiceException e) {
            	System.out.println("REGISTRATION ERROR: "+e.getMessage());
				System.out.println("Please attempt to register again.");
            }
        }
	}

	private void login() {
		System.out.println("Please log in");
		currentUser = null;
		while (currentUser == null) //will keep looping until user is logged in
		{
			UserCredentials credentials = collectUserCredentials();
		    try {
				currentUser = authenticationService.login(credentials);
			} catch (AuthenticationServiceException e) {
				System.out.println("LOGIN ERROR: "+e.getMessage());
				System.out.println("Please attempt to login again.");
			}
		}
	}
	
	private UserCredentials collectUserCredentials() {
		String username = console.getUserInput("Username");
		String password = console.getUserInput("Password");
		return new UserCredentials(username, password);
	}
	
}
