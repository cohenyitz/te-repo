package com.techelevator;

/**
 * CreditCardAccount
 */
public class CreditCardAccount implements Accountable {
	
	private String accountHolder;
	private String accountNumber;
	private int debt;
	
	
	
/**
	 * @return the accountHolder
	 */
	public String getAccountHolder() {
		return accountHolder;
	}



	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}



	/**
	 * @return the debt
	 */
	public int getDebt() {
		return debt;
	}


	public CreditCardAccount(String accountHolder, String accountNumber) {
		this.accountHolder = accountHolder;
		this.accountNumber = accountNumber;
		this.debt = 0;
	}

	public int pay(int amountToPay) {
		debt = debt - amountToPay;
		return debt;
	}
	
	public int charge(int amountToCharge) {
		debt = debt + amountToCharge;
		return debt;
	}
/*******************************************************************
 * Place the code for  your CreditCard class here
 *******************************************************************/


    public int getBalance() {
    	//***************************************************************
    	// This should return the negative of the debt data member
    	//***************************************************************
    	
        return -debt;
    }

 

}