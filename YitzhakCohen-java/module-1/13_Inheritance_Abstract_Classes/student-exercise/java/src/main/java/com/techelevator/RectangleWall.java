package com.techelevator;

public class RectangleWall extends Wall {

	
	private int length;
	private int height;
	
	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}
	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}
	
	
	public RectangleWall(String name, String color, int length, int height) {
		super(name, color);
		this.length = length;
		this.height = height;
	
	}
	
	public int getArea() {
		int area = length * height;
		return area;
	}
	
	public String toString() {
		return getName() + " (" + (length + "x" + height) + ") "+ "rectangle";
	}
}
