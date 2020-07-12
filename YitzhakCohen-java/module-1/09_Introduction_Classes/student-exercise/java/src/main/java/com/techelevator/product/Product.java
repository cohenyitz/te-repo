package com.techelevator.product;

public class Product {

	private String name;
	private double price;
	private double weightInOunces;
	
	public Product() {
		
		name = "Theraputic Full Spectrum Hemp Balm";
		price = 47;
		weightInOunces = 2;
		
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
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the weightInOunces
	 */
	public double getWeightInOunces() {
		return weightInOunces;
	}

	/**
	 * @param weightInOunces the weightInOunces to set
	 */
	public void setWeightInOunces(double weightInOunces) {
		this.weightInOunces = weightInOunces;
	}
	
	
	//
	// Write code here
	//
	
}
