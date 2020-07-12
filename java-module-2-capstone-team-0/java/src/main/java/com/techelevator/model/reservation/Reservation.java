package com.techelevator.model.reservation;

import java.time.LocalDate;

public class Reservation {
	
	private Long reservationId;
	private long siteId;
	private String name;
	private LocalDate fromDate;
	private LocalDate toDate;
	private LocalDate createDate;
	
	//Create constructor and toString()
	
	
	public Long getReservationId() {
		return reservationId;
	}

	@Override
	public String toString() {
		return "Reservation [reservationId=" + reservationId + ", siteId=" + siteId + ", name=" + name + ", fromDate="
				+ fromDate + ", toDate=" + toDate + ", createDate=" + createDate + "]";
	}
	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}
	
	public long getSiteId() {
		return siteId;
	}

	public void setSiteId(long siteId) {
		this.siteId = siteId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public LocalDate getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

}
