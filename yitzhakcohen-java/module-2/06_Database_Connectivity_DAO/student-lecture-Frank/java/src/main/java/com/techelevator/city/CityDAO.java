package com.techelevator.city;

import java.util.List;
							///------C.R.U.D = Create, Read, Update, Delete----

public interface CityDAO {   // interface names tablenameDAO
//
// These are typical methods required for a DAO
//	
	// Create a new row in table from a POJO
	public void save(City newCity);         // save the to the database when given a completed object
	
	// Various Search (Read) methods
	public City findCityById(long id);      // search by primary key
	public List<City> findCityByCountryCode(String countryCode); // search by other common values
	public List<City> findCityByDistrict(String district);
	
	// Update methods - change values in a row from a POJO  
	public void update(City city);         // update a entry in the data base given a object
	
	// Delete methods - Remove a row from data-base using a primary key
	public void delete(long id);           // delete by primary key
	
	
	// Usually have a method to return all rows in the table as POJO objects
	public List<City> allCities();         // return all rows from the table as POJO
}
