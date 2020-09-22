package com.techelevator.calculator;

public class Calculator {

	private int result;
	
	public Calculator() {
		result = 0;
		
	}
	
	public int add(int addend) {
		this.result = result + addend;
		return result;
	}

	
	
	public int multiply(int multiplier) {
		return result = result * multiplier;
	}
	public int power(int exponent) {
		
		if (Math.pow(result, exponent)  < 0) {
			return Math.abs(result);
		}
		
	
		return result = (int) Math.pow(result, exponent);
	}
	
	public void reset() {
		result = 0;
	}
	
	public int subtract(int subtrahend) {
		result = result - subtrahend;
		return result;
	}
	
	/**
	 * @return the result
	 */
	public int getResult() {
		return result;
	}

	
}
