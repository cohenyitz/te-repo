package com.techelevator.shoppingcart;

public class ShoppingCart {

	private int totalNumberOfItems;
	private double totalAmountOwed;
	
	public ShoppingCart() {
		totalNumberOfItems = 0;
		totalAmountOwed = 0.0;
		
	}
	
	/**
	 * @return the totalNumberOfItems
	 */
	public int getTotalNumberOfItems() {
		return totalNumberOfItems;
	}

	/**
	 * @return the totalAmountOwed
	 */
	public double getTotalAmountOwed() {
		return totalAmountOwed;
	}
	
	public double getAveragePricePerItem() {
		double averagePrice = totalAmountOwed / totalNumberOfItems;
		
		if (totalNumberOfItems < 1) {
			return 0.0;
		}
		return averagePrice;
	}
	
	public void addItems (int numberOfItems, double pricePerItem) {
		this.totalNumberOfItems = numberOfItems;
		totalAmountOwed = pricePerItem * numberOfItems;
	}
	
	public void empty() {
		totalNumberOfItems = 0;
		totalAmountOwed = 0.0;
	}
}
	
	

