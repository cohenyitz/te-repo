package com.techelevator;

public class TellerMachine {
	
	private String manufacturer;
	private double deposits;
	private double withdrawals;
	private double balance;
	
	public TellerMachine(String manufacturer, double deposits, double withdrawals) {
		this.manufacturer = manufacturer;
		this.deposits = deposits;
		this.withdrawals = withdrawals;
		this.balance = deposits - withdrawals;
	}

	public TellerMachine() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the manufacturer
	 */
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * @param manufacturer the manufacturer to set
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	/**
	 * @return the deposits
	 */
	public double getDeposits() {
		return deposits;
	}

	/**
	 * @param deposits the deposits to set
	 */
	public void setDeposits(double deposits) {
		this.deposits = deposits;
	}

	/**
	 * @return the withdrawals
	 */
	public double getWithdrawals() {
		return withdrawals;
	}

	/**
	 * @param withdrawals the withdrawals to set
	 */
	public void setWithdrawals(double withdrawals) {
		this.withdrawals = withdrawals;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	public boolean checkCardNumber() {
		String cardNumber = "";
		if (cardNumber.startsWith("5") && cardNumber.length()== 15) {
			return true;
		}
		if (cardNumber.startsWith("4") && cardNumber.length()== 12 || cardNumber.length() == 15) {
			return true;
		}
		if (cardNumber.startsWith("3") && cardNumber.substring(1).equals("4") || cardNumber.substring(1).equals("7")) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "ATM [manufacturer=" + manufacturer + ", balance=" + balance + "]";
	}
	
	
}
