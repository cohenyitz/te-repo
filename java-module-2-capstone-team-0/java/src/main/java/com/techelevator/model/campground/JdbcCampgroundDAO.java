package com.techelevator.model.campground;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.model.campground.Campground;

public class JdbcCampgroundDAO implements CampgroundDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcCampgroundDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	//need price method
	

	@Override
	public List<Campground> getAllCampgrounds() {
		List<Campground> listOfCampgrounds = new ArrayList<Campground>();
		
		String getAllCampgroundsSQL = "select campground_id, park_id, name, open_from_mm, open_to_mm, daily_fee"
									+ "from campground"
									+ "order by name asc";
		SqlRowSet resultFromSQL = jdbcTemplate.queryForRowSet(getAllCampgroundsSQL);
		
		while(resultFromSQL.next()) {
			Campground aCampground = mapRowToCampground(resultFromSQL);
			listOfCampgrounds.add(aCampground);
		}
		return listOfCampgrounds;
	}

	@Override
	public Campground getACampgroundByName(String name) { // do we need parameters with all the info about the campground
		
		
		Campground aCampground = new Campground();
		
		//String searchForCampground = "%" + name + "%";
		String getACampgroundByNameSQL = "select campground_id, park_id, name, open_from_mm, open_to_mm, daily_fee  "
									   + "from campground "
									   + "where name = ?";
		SqlRowSet resultFromSQL = jdbcTemplate.queryForRowSet(getACampgroundByNameSQL, name);
		//System.out.println(resultFromSQL.next());
		if(resultFromSQL.next()) {
			aCampground = mapRowToCampground(resultFromSQL);
			
		}
		//System.out.println(aCampground);
		return aCampground;
	}

	@Override
	public Campground getCampgroundById(long campgroundId) {
		Campground campgroundById = new Campground();
		
		String getCampgroundByIdSQL = "select campground_id, park_id, name, open_from_mm, open_to_mm, daily_fee "
									+ "from campground "
									+ "where campground_id = ?";
		SqlRowSet resultFromSQL = jdbcTemplate.queryForRowSet(getCampgroundByIdSQL, campgroundId);
		
		if(resultFromSQL.next()) {
			campgroundById = mapRowToCampground(resultFromSQL);
		}
		
		return campgroundById;
	}
	


	@Override
	public List<Campground> getAllCampgroundsByPName(String parkName) {
		List<Campground> listOfCampgrounds = new ArrayList<Campground>();
		
		String getAllCampgroundsSQL = "select campground_id, campground.park_id, campground.name, open_from_mm, open_to_mm, daily_fee "
									+ "from campground "
									+ "Inner Join park "
									+ "on campground.park_id = park.park_id "
									+ "where park.name = ?  " ;
		SqlRowSet resultFromSQL = jdbcTemplate.queryForRowSet(getAllCampgroundsSQL, parkName);
		
		while(resultFromSQL.next()) {
			Campground aCampground = mapRowToCampground(resultFromSQL);
			listOfCampgrounds.add(aCampground);
		}
		return listOfCampgrounds;
	
		}
	
	private Campground mapRowToCampground(SqlRowSet aRow) {
		Campground aCampground = new Campground();
		
		aCampground.setCampgroundId(aRow.getLong("campground_id"));
		aCampground.setParkId(aRow.getInt("park_id"));
		aCampground.setName(aRow.getString("name"));
		aCampground.setOpenFromMM(aRow.getString("open_from_mm"));
		aCampground.setOpenToMM(aRow.getString("open_to_mm"));
		aCampground.setDailyFee(aRow.getDouble("daily_fee"));
		
		return aCampground;
	}
	
	
	
}
