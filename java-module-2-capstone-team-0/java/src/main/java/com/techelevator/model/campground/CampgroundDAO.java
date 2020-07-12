package com.techelevator.model.campground;

import java.util.List;

public interface CampgroundDAO {
	
	/**
	 * Get a list of all parks
	 * 
	 * @return list in alphabetical order
	 * 
	 */
	public List<Campground> getAllCampgrounds();
	
	/**
	 * Search for a Campground by name. Use iLike
	 * 
	 * @param String name should contain name of Campground being searched for
	 * 
	 * @return  all matching parks specified in search
	 * 
	 */
	public Campground getACampgroundByName(String name);
	
	/**
	 * Get a Campground from the datastore that belongs to the given id.
	 * 
	 * @param campgroudId is the id to get from the datastore
	 * 
	 * @return a filled out Campground object
	 * 
	 */
	public Campground getCampgroundById(long campgroundId);


    public List<Campground> getAllCampgroundsByPName(String parkName); 
}