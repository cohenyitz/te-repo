package com.techelevator.model.reservation;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ReservationDAO {
	
	public List<Reservation> getAllReservations();
	//public List<Reservation> getAllReservationsByFromDate();
	//public List<Reservation> getAllReservationsByToDate();
	//public List<Reservation> getAllReservationsByCreateDate();
	public Reservation getReservationByName(String name);
	public Reservation getReservationById(Long reservationId);
	public Reservation getReservationByCreateDate(LocalDate createDate);
	public Reservation saveReservation(long siteId, String name, LocalDate startDate, LocalDate endDate, LocalDate createDate);
	//public void updateReservationName(Reservation updatedReservation);
	//public void updateReservationToDate(Reservation updatedReservation);
	//public void updateReservationFromDate(Reservation updatedReservation);
	//public void updateReservationSite(Reservation updatedReservation);
	//public void deleteReservation(Long reservationId);

}
