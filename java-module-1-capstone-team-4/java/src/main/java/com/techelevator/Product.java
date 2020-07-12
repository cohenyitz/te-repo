package com.techelevator;

public class Product {
	
	private String      name;
	private double     price;
	private String      type;
	private String  location;
	private int        stock;
	
	
	public Product(String name, int stock) {
		this.name  =  name;
		this.stock = stock;
	}
	
	public Product(String location, String name, double price, String type) {
		this.location = location;
		this.name  =  name;
		this.price = price;
		this.type  =  type;
		this.stock =     5;
	}
	public Product(String location, String name, double price, String type, int stock) {
		this.name     =     name;
		this.price    =    price;
		this.type     =     type;
		this.location = location;
		this.stock    =    stock;
	}
	

	
	@Override
	public String toString() {
		return name + ", " + price + ", " + type + ", " + location + ", Available: " + stock;
				
	}

	/**
	 * @return the stock
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * @param stock the stock to set
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
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
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	public String consumptionNoise() {
		String noise = "";
		if(type.equals("Chip")) {
			noise = "Crunch Crunch, Yum!";
		}
		if(type.equals("Candy")) {
			noise = "Munch Munch, Yum!";
		}
		if(type.equals("Drink")) {
			noise = "Glug Glug, Yum!";
		}
		if(type.equals("Gum")) {
			noise = "Chew Chew, Yum!";
		}
		return noise;
			
	}
	
}
