package com.techelevator.dog;

public class Dog {

	private boolean isSleeping;
	
	public Dog() {
		isSleeping = false;
		
		
	}

	/**
	 * @return the isSleeping
	 */
	public boolean isSleeping() {
		return isSleeping;
	}
	
	public String makeSound() {
		if (isSleeping) {
			return "Zzzzz...";
		}
		if (!isSleeping) {
			return "Woof!";
		}
		return null;
	}
	
	public void sleep() {
		isSleeping = true;
	}
	
	public void wakeUp() {
		isSleeping = false;
	}

	//
	// Write code here
	//
	
}
