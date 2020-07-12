package com.techelevator;

public class Airplane {
	
	private String planeNumber;
	private int bookedFirstClassSeats;
	private int availableFirstClassSeats;
	private int totalFirstClassSeats;
	private int bookedCoachSeats;
	private int availableCoachSeats;
	private int totalCoachSeats;
	
	
	
	/**
	 * @return the planeNumber
	 */
	public String getPlaneNumber() {
		return planeNumber;
	}



	/**
	 * @return the bookedFirstClassSeats
	 */
	public int getBookedFirstClassSeats() {
		return bookedFirstClassSeats;
	}



	/**
	 * @return the availableFirstClassSeats
	 */
	public int getAvailableFirstClassSeats() {
		return availableFirstClassSeats;
	}



	/**
	 * @return the totalFirstClassSeats
	 */
	public int getTotalFirstClassSeats() {
		return totalFirstClassSeats;
	}



	/**
	 * @return the bookedCoachSeats
	 */
	public int getBookedCoachSeats() {
		return bookedCoachSeats;
	}



	/**
	 * @return the availableCoachSeats
	 */
	public int getAvailableCoachSeats() {
		return availableCoachSeats;
	}



	/**
	 * @return the totalCoachSeats
	 */
	public int getTotalCoachSeats() {
		return totalCoachSeats;
	}



	public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {
		this.planeNumber = planeNumber;
		this.totalFirstClassSeats = totalFirstClassSeats;
		this.totalCoachSeats = totalCoachSeats;
		this.availableFirstClassSeats = totalFirstClassSeats - bookedFirstClassSeats;
		this.availableCoachSeats = totalCoachSeats - bookedCoachSeats;
	}
	
	public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats) {
		if (forFirstClass && totalNumberOfSeats < availableFirstClassSeats ) {
			availableFirstClassSeats = availableFirstClassSeats - totalNumberOfSeats;
			bookedFirstClassSeats = bookedFirstClassSeats + totalNumberOfSeats;
			return true;
		}
		if(!forFirstClass && availableCoachSeats >= totalNumberOfSeats) {
			availableCoachSeats = availableCoachSeats - totalNumberOfSeats;
			bookedCoachSeats = bookedCoachSeats + totalNumberOfSeats;
			return true;
		}
		return false;
	}

}
