package com.techelevator.model.park;

import java.time.LocalDate;
import java.util.Date;

public class Park {

	private Long parkId;
	private String name;
	private String location;
	private LocalDate establishDate; //do we want java.sql.date instead of java.util.Date? -- thinking using the util is better
	private int area;
	private int visitors;
	private String description;
	
	
	public Long getParkId() {
		return parkId;
	}
	public void setParkId(Long parkId) {
		this.parkId = parkId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public LocalDate getEstablishDate() {
		return establishDate;
	}
	public void setEstablishDate(LocalDate establishDate) {
		this.establishDate = establishDate;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public int getVisitors() {
		return visitors;
	}
	public void setVisitors(int visitors) {
		this.visitors = visitors;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Park name: " + name + "\n"  + location + "\n"  + description;
	}
	
	
	
	
	
	
}
