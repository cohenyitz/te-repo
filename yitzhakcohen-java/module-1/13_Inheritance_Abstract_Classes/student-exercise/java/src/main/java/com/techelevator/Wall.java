package com.techelevator;

public abstract class Wall {
	
	private String name;
	private String color;
	
	
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}



	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}



	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}



	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}



	public  Wall(String name, String color) {
		this.name = name;
		this.color = color;
	}
	
	public abstract int getArea();

}
