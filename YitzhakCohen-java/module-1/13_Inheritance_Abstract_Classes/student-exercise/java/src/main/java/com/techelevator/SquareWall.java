package com.techelevator;

public class SquareWall extends RectangleWall {

	private int sideLength;
	//public SquareWall(String name, String color, int length, int height) {
	//	super(name, color, length, height);
		// TODO Auto-generated constructor stub
	//}

	public SquareWall(String name, String color, int sideLength) {
		super(name, color, sideLength, sideLength);
		this.sideLength = sideLength;
	}
	public String toString() {
		return getName() + " (" + (sideLength + "x" + sideLength) + ") " + "square";
	}
	
}
