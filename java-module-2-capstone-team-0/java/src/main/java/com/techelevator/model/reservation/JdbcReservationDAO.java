package com.techelevator.model.reservation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;



public class JdbcReservationDAO implements ReservationDAO {
	
private JdbcTemplate jdbcTemplate;
	
	public JdbcReservationDAO(DataSource dataSource) {
	this.jdbcTemplate = new JdbcTemplate(dataSource);
	}



	
	@Override
	public List<Reservation> getAllReservations() {
		List<Reservation> theReservations = new ArrayList<Reservation>();
		String getAllReservationsSQL = "Select reservation_id, site_id, name, from_date, to_date, create_date from reservation ";
		
		SqlRowSet resultFromSQL = jdbcTemplate.queryForRowSet(getAllReservationsSQL);
		while(resultFromSQL.next()) {
			Reservation aReservation = mapRowToReservation(resultFromSQL);
			theReservations.add(aReservation);
		}
		return null;
	}




	@Override
	public Reservation getReservationByName(String name) {
		Reservation aReservation = new Reservation();
		String likeSearchString = "%" + name + "%";
		String getReservationByNameSQL = "Select reservation_id, site_id, name, from_date, to_date, create_date"
									   + " from reservation"
									   + "where name ilike ? ";
		
		SqlRowSet resultFromSQL = jdbcTemplate.queryForRowSet(getReservationByNameSQL,likeSearchString ); 
		if(resultFromSQL.next()) {
			aReservation = mapRowToReservation(resultFromSQL);
		}
		return aReservation;
	}




	@Override
	public Reservation getReservationById(Long reservationId) {
		Reservation aReservation = new Reservation();
		String getReservationByIdSQL = "Select reservation_id, site_id, name, from_date, to_date, create_date"
									   + " from reservation"
									   + "where reservation_id = ? ";
		
		SqlRowSet resultFromSQL = jdbcTemplate.queryForRowSet(getReservationByIdSQL, reservationId); 
		if(resultFromSQL.next()) {
			aReservation = mapRowToReservation(resultFromSQL);
		}
		return aReservation;
	}
		
	@Override
	public Reservation getReservationByCreateDate(LocalDate createDate) {
		Reservation aReservation = new Reservation();
		String getReservationByCreateDateSQL = "Select reservation_id, site_id, name, from_date, to_date, create_date"
									   + " from reservation"
									   + "where create_date = ? ";
		
		SqlRowSet resultFromSQL = jdbcTemplate.queryForRowSet(getReservationByCreateDateSQL, createDate); 
		if(resultFromSQL.next()) {
			aReservation = mapRowToReservation(resultFromSQL);
		}
		return aReservation;
	}
	

	@Override  
	public Reservation saveReservation(long siteId, String name, LocalDate fromDate, LocalDate toDate, LocalDate createDate) {
	Reservation aReservation = new Reservation();  
		aReservation.setReservationId((getNextReservationId()));  
		aReservation.setSiteId(siteId);
		aReservation.setName(name);
		aReservation.setFromDate(fromDate);
		aReservation.setToDate(toDate);
		aReservation.setCreateDate(createDate);
		String createReservationSQL = "Insert Into reservation(reservation_id, site_id, name, from_date, to_date, create_date) values(?,?,?,?,?,?)";// one placeholder ? for each column value in row
		jdbcTemplate.update(createReservationSQL , aReservation.getReservationId()
												 , aReservation.getSiteId()
				                           		 , aReservation.getName()
				                           		 , aReservation.getFromDate()
				                           		 , aReservation.getToDate()
				                           		 , aReservation.getCreateDate()
				                           		 );
		return aReservation;
	}
		
	
	
	
	
	
	
	
	
   //DO I NEED TO INCLUDE ALL THE REST OF THE gets in ALL THE UPDATE METHODS
//	@Override
//	public void updateReservationName(Reservation updatedReservation) {
//		String updateSQL = "Update reservation"
//						 + "Set name = ?"
//						 + "Where reservation_id = ?";
//		jdbcTemplate.update(updateSQL,updatedReservation.getName(), updatedReservation.getReservationId());
//	}
//
//
//
//
//	@Override
//	public void updateReservationToDate(Reservation updatedReservation) {
//		String updateSQL = "Update reservation"
//				 + "Set to_date = ?"
//				 + "Where reservation_id = ?";
//jdbcTemplate.update(updateSQL,updatedReservation.getName(), updatedReservation.getReservationId());
//}
//		
//
//
//
//
//	@Override
//	public void updateReservationFromDate(Reservation updatedReservation ) {
//		String updateSQL = "Update reservation"
//				 + "Set from_date?"
//				 + "Where reservation_id = ?";
//jdbcTemplate.update(updateSQL,updatedReservation.getName(), updatedReservation.getReservationId());
//}
//		
//
//
//
//	@Override
//	public void updateReservationSite(Reservation updatedReservation) {
//		String updateSQL = "Update reservation"
//				 + "Set site_id = ?"
//				 + "Where reservation_id = ?";
//jdbcTemplate.update(updateSQL,updatedReservation.getName(), updatedReservation.getReservationId());
//}
//		
//
//
//
//
//	@Override
//	public void deleteReservation(Long reservationId) {
//		String deleteReservationSQL = "Delete From reservation where reservation_id = ?";
//		jdbcTemplate.update(deleteReservationSQL, reservationId);
//	}
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//HELPER METHODS
		private long getNextReservationId() {
			SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('reservation_reservation_id_seq')");
			if(nextIdResult.next()) {
				return nextIdResult.getLong(1);
			} else {
				throw new RuntimeException("Something went wrong while getting an id for the new reservation");
			}
		}

		
		private Reservation mapRowToReservation(SqlRowSet aRow) {
			Reservation aReservation = new Reservation();
			aReservation.setReservationId(aRow.getLong("reservation_id"));
			aReservation.setSiteId(aRow.getInt("site_id"));
			aReservation.setName(aRow.getString("name"));
			aReservation.setFromDate(aRow.getDate("from_date").toLocalDate());
			aReservation.setToDate(aRow.getDate("to_date").toLocalDate());
			aReservation.setCreateDate(aRow.getDate("create_date").toLocalDate());
			
			return aReservation;
			
		}




	
		
		
}
