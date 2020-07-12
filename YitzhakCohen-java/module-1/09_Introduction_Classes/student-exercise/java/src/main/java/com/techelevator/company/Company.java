package com.techelevator.company;

public class Company {

	private String name; // The company name.
	private int numberOfEmployees; // The number of employees at the company
	private double revenue; // The annual revenue of the company 
	private double expenses; // The annual expenses of the company
	
	public Company() {
		name = "Du Chanvre LLC";
		numberOfEmployees = 52;
		revenue = 975999;
		expenses = 222987;
		
	}
	

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
	 * @return the numberOfEmployees
	 */
	public int getNumberOfEmployees() {
		return numberOfEmployees;
	}


	/**
	 * @param numberOfEmployees the numberOfEmployees to set
	 */
	public void setNumberOfEmployees(int numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}


	/**
	 * @return the revenue
	 */
	public double getRevenue() {
		return revenue;
	}


	/**
	 * @param revenue the revenue to set
	 */
	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}


	/**
	 * @return the expenses
	 */
	public double getExpenses() {
		return expenses;
	}


	/**
	 * @param expenses the expenses to set
	 */
	public void setExpenses(double expenses) {
		this.expenses = expenses;
	}


	public String getCompanySize() {
		if (numberOfEmployees <= 50) {
			return "small";
		}
		if (numberOfEmployees >= 51 && numberOfEmployees <= 250) {
			return "medium";
		}
		if (numberOfEmployees > 250) {
			return "large";
		}
		return null;
	}
	
	public double getProfit() {
		double profit = revenue - expenses;
		return profit;
	}
	
	
	
	//
	// Write code here
	//
	
}
