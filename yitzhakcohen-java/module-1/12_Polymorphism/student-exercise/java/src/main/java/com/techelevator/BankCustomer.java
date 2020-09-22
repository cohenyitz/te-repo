package com.techelevator;

import java.util.ArrayList;
import java.util.List;

/**
 * BankCustomer
 */
public class BankCustomer  implements Accountable {


	private String name;
	private String address;
	private String phoneNumber;
	private List<Accountable> accounts = new ArrayList<> ();
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @return the accounts
	 */
	public Accountable[] getAccounts() {
		return accounts.toArray(new Accountable[accounts.size()]);
	}
	
	/**
	 * @param accounts the accounts to set
	 */
	public void setAccounts(List<Accountable> accounts) {
		this.accounts = accounts;
	}
	
	
	public void addAccount(Accountable newAccount) {
		accounts.add(newAccount);
	}
	
	@Override
	public int getBalance() {
		return 0;
	}
	
	public boolean isVip() {
		int total = 0;
		for (int i =0; i < accounts.size(); i++) {
			total = total + accounts.get(i).getBalance();
		}
		if (total >= 25000) {
			return true;
		}
		return false;
	}
	
	
}