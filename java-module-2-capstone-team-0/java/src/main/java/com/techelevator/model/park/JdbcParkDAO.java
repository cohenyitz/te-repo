package com.techelevator.model.park;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.techelevator.model.park.Park;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;




public class JdbcParkDAO implements ParkDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public  JdbcParkDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	

	@Override
	public List<Park> getAllParks() {
		List<Park> listOfParks = new ArrayList<Park>();
		
		String getAllParksSQL = "select park_id, name, location, establish_date, area, visitors, description "
							  + "from park "
							  + "order by name asc";
		
		SqlRowSet resultFromSQL = jdbcTemplate.queryForRowSet(getAllParksSQL);
		
		while(resultFromSQL.next()) { 
			Park aPark = mapRowToPark(resultFromSQL); 
			listOfParks.add(aPark);	
		}
		return listOfParks;
	}

	@Override
	public Park getAParkByName(String name) {
		Park park = new Park();
		
		String searchForPark = "%" + name +"%";
		String getAParkByNameSQL = "select park_id, name, location, establish_date, area, visitors, description "
								 + "from park "
								 + "where name ilike ?";
		SqlRowSet resultFromSQL = jdbcTemplate.queryForRowSet(getAParkByNameSQL, name);
		
		while(resultFromSQL.next()) {
			park = mapRowToPark(resultFromSQL);
			}
	return park;
	}

	@Override
	public Park getAparkById(long parkId) {
		Park aParkById = new Park();
		
		String searchParkByIdSQL = "select park_id, name, location, establish_date, area, visitors, description"
								 + "from park"
								 + "where park_id = ?";
		SqlRowSet resultFromSQL = jdbcTemplate.queryForRowSet(searchParkByIdSQL, parkId);
		
		if(resultFromSQL.next()) {
			aParkById = mapRowToPark(resultFromSQL);
		}
		return aParkById;
	}


	private Park mapRowToPark(SqlRowSet aRow) {
		Park aPark = new Park();
		
		aPark.setParkId(aRow.getLong("park_id"));
		aPark.setName(aRow.getString("name"));
		aPark.setLocation(aRow.getString("location"));
		aPark.setEstablishDate(aRow.getDate("establish_date").toLocalDate());
		aPark.setArea(aRow.getInt("area"));
		aPark.setVisitors(aRow.getInt("visitors"));
		aPark.setDescription(aRow.getString("description"));
		
		return aPark;
	}
	


}
