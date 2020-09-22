package com.techelevator;

public class TriangleWall extends Wall{

	private int base;
	private int height;
	
	/**
	 * @return the base
	 */
	public int getBase() {
		return base;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	public TriangleWall(String name, String color) {
		super(name, color);
		
	}
	
	public TriangleWall(String name, String color, int base, int height) {
		super(name, color);
		this.base = base;
		this.height = height;
	}
	
	public int getArea() {
		int area = (base * height) / 2;
		return area;
	}
	
	public String toString() {
		return getName() + " (" + (base + "x" + height) + ") " + "triangle";
	}
	
	
	

}
