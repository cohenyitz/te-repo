package com.techelevator.model.site;

import java.time.LocalDate;
import java.util.List;

public interface SiteDAO {
	
	
	//get all sites as Site objects and return them in an ArrayList 
	public List<Site> getAllSites();
	
	//get site by max occupancy
	//public Site getSiteByMaxOccupancy(int maxoc);
	
	//get site by id
	public Site getSiteById(Long siteId);
	
	
	
	//check for AVAILABLE sites SHOULD RETURN TYPE BE VOID??
	//public List<Site> getAllAvailSites( LocalDate toDate, 
			                                 // LocalDate fromDate , int campgroundId, String openFromMM, String openToMM );
	
	//return an ArrayList of AVAILABLE Site objects
	//public List<Site> getAllAvailableSites();
	
	
	//get all AVAILIBLE sites by campground_id 
	public List<Site> getAllAvailSitesByCGId( LocalDate toDate, LocalDate fromDate , long campgroundId, String openFromMM, String openToMM );
	
	//get an AVAILABLE site by max occupancy
	//public Site getAvailSiteByMaxOc(int maxoc);
	
	//get an AVAILABLE site by id
	//public Site getAvailSiteById(Long id); 
	
	//get AVAILABLE site by cost per night
	//public Site getAvailSiteByCost(double costPerNight);
	
	//get AVAILABLE site by accessibility 
	//public Site getAvailSiteByAccess(boolean accessible);

}
