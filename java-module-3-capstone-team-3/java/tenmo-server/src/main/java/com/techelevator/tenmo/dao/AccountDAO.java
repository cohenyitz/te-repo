package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;

public interface AccountDAO {
	
	public Account getUserAccount(int userID);
	
	public double deposit(int userID, double amount);

	public double withdraw(int userID, double amount);
}
