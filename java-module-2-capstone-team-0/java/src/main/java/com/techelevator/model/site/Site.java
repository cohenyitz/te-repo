package com.techelevator.model.site;

import java.time.LocalDate;

public class Site {
	private Long siteId;
	private int maxoc;
	private LocalDate fromDate;
	private LocalDate toDate;
	private boolean accessible;
	//private double costPerNight;
	private long campgroundId;
	private int siteNumber;
	private boolean utilities;
	private int maxRvLength;
	
	
	
//also make a constructor and toString method 
	
	@Override
	public String toString() {
		return "Site [siteId=" + siteId  + ", siteNumber=" + siteNumber
				
				+  ", accessible=" + accessible + ", campgroundId=" + campgroundId +  ", utilities=" + utilities  + ", maxoc=" + maxoc + ", maxRvLength=" + maxRvLength + "]";
	}
	
	
	public int getSiteNumber() {
		return siteNumber;
	}


	public void setSiteNumber(int siteNumber) {
		this.siteNumber = siteNumber;
	}


	public long getCampgroundId() {
		return campgroundId;
	}
	public void setCampgroundId(long campgroundId) {
		this.campgroundId = campgroundId;
	}
	
	public boolean isUtilities() {
		return utilities;
	}
	public void setUtilities(boolean utilities) {
		this.utilities = utilities;
	}
	public int getMaxRvLength() {
		return maxRvLength;
	}
	public void setMaxRvLength(int maxRvLength) {
		this.maxRvLength = maxRvLength;
	}
	public Long getSiteId() {
		return siteId;
	}
	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}
	public int getMaxoc() {
		return maxoc;
	}
	public void setMaxoc(int maxoc) {
		this.maxoc = maxoc;
	}
	public LocalDate getFromDate() {
		return fromDate;
	}
	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}
	public LocalDate getToDate() {
		return toDate;
	}
	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}
	public boolean isAccessible() {
		return accessible;
	}
	public void setAccessible(boolean accessible) {
		this.accessible = accessible;
	}
	//public double getCostPerNight() {
		//return costPerNight;
	//}
	//public void setCostPerNight(double costPerNight) {
		//this.costPerNight = costPerNight;
	//}
}



