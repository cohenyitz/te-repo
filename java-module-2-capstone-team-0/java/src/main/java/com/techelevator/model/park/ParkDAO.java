package com.techelevator.model.park;

import java.util.List;

public interface ParkDAO {

	/**
	 * Get a list of all parks
	 * 
	 * @return list in alphabetical order
	 */
	public List<Park> getAllParks();
	
	/**
	 * Search for a park by name. Use iLike
	 * 
	 * @param String name should contain name of park being searched for
	 * 
	 * @return  all matching parks specified in search
	 */
	public Park getAParkByName(String name);
	
	/**
	 * Get a Park from the datastore that belongs to the given id.
	 * 
	 * @param parkId is the id to get from the datastore
	 * 
	 * @return a filled out Park object
	 * 
	 */
	public Park getAparkById(long parkId);
}
