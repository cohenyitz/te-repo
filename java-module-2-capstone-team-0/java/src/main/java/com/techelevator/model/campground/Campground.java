package com.techelevator.model.campground;

public class Campground {
	
	private Long campgroundId;
	private int parkId;
	private String name;
	private String openFromMM;
	private String openToMM;
	private double dailyFee;
	
	//need a way to get price for total
	
	
	public Long getCampgroundId() {
		return campgroundId;
	}
	public void setCampgroundId(Long campgroundId) {
		this.campgroundId = campgroundId;
	}
	public int getParkId() {
		return parkId;
	}
	public void setParkId(int parkId) {
		this.parkId = parkId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOpenFromMM() {
		return openFromMM;
	}
	public void setOpenFromMM(String openFromMM) {
		this.openFromMM = openFromMM;
	}
	public String getOpenToMM() {
		return openToMM;
	}
	public void setOpenToMM(String openToMM) {
		this.openToMM = openToMM;
	}
	public double getDailyFee() {
		return dailyFee;
	}
	public void setDailyFee(double dailyFee) {
		this.dailyFee = dailyFee;
	}
	
	@Override
	public String toString() {
		return "Campground [campgroundId=" + campgroundId + ", parkId=" + parkId + ", name=" + name + ", openFromMM="
				+ openFromMM + ", openToMM=" + openToMM + ", dailyFee=" + dailyFee + "]";
	}
	
	
	
	

}
