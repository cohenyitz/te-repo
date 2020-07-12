package com.techelevator.model.site;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;





public class JdbcSiteDAO implements SiteDAO {

	private JdbcTemplate jdbcTemplate;
	
	public JdbcSiteDAO(DataSource dataSource) {
	this.jdbcTemplate = new JdbcTemplate(dataSource);
	}


	//METHODS
	@Override
	public List<Site> getAllSites() {
		List<Site> theSites= new ArrayList<Site>(); // code what you want to return 
		String getAllSitesSQL = "select site_id, campground_id, site_number, max_occupancy, accessible, max_rv_length, utilities"
				              + "from site"; // get the SQL
		SqlRowSet resultFromSQL = jdbcTemplate.queryForRowSet(getAllSitesSQL); // get the SQL results
		while(resultFromSQL.next()) { //loop thru them 
			Site aSite = mapRowToSite(resultFromSQL); // make an object for that row
			theSites.add(aSite); // add that object to the list of objects 
		}
		return theSites; // return the list 
	}

	//@Override
	//public Site getSiteByMaxOccupancy(int maxoc) { // uncommented this out so that i can upload :))))
		//Site aSite = new Site();
		//String getSiteByMaxOcSQL = "select site_id, campground_id, site_number, max_occupancy, accessible, max_rv_length, utilities"
				//+ "from site where max_occupancy = ? ";
		//SqlRowSet resultFromSQL = jdbcTemplate.queryForRowSet(getSiteByMaxOcSQL, maxoc);
		///if(resultFromSQL.next()) {
		//	aSite = mapRowToSite(resultFromSQL);
		//}
		//return aSite;
	//}

	@Override
	public Site getSiteById(Long siteId) {
		Site aSite = new Site();
		String getSiteByIdSQL = "select site_id, campground_id, site_number, max_occupancy, accessible, max_rv_length, utilities "
				+ " from site where site_id = ? ";
		SqlRowSet resultFromSQL = jdbcTemplate.queryForRowSet(getSiteByIdSQL, siteId);
		if(resultFromSQL.next()) {
			aSite = mapRowToSite(resultFromSQL);
		}
		return aSite;
	}
	

//	@Override
//	public List<Site> getAllAvailSites( LocalDate toDate, LocalDate fromDate , int campgroundId, String openFromMM, String openToMM ) { // i erased site id from parameter... should i put it back 
//		
//		List<Site> availSites = new ArrayList<Site>();
//		String availabilitySQL = "select * "  
//		                        +"from site "  
//		                        +" where site_id IN(select site.site_id"                    
//		                                          +"from site "
//		                                          +" where site.site_id NOT IN  " 
//		                                                                     +" (select reservation.site_id"      
//		                                                                     +" from reservation "  
//		                                                                     +" where ? < to_date " 
//		                                                                     +" and ? > from_date))"   
//		                                                                     +" and campground_id IN (select site.campground_id"          
//		                                                                                           +"from site "
//		                                                                                           +"where site.campground_id in (select campground_id"   
//		                                                                                           +"from campground"   
//		                                                                                           +"where ? >= cast(open_from_mm as Integer)"  //how do i get the user input month
//		                                                                                           +" and ? <= cast(open_to_mm as Integer)))"   //^^ 
//		                                                                                           +" and campground_id = ? "                 
//		   +"limit 5; "
//		   +";";
//	
//	
//		SqlRowSet resultFromSQL = jdbcTemplate.queryForRowSet(availabilitySQL, toDate, fromDate, openFromMM, openToMM, campgroundId);
//		while(resultFromSQL.next()) {
//			Site aSite = mapRowToSite(resultFromSQL);
//			availSites.add(aSite);
//		}
//	return availSites;
//	
//	}

	//@Override
	//public List<Site> getAllAvailableSites() {
		// TODO Auto-generated method stub
		//return null;
	//}

	@Override
	public List<Site> getAllAvailSitesByCGId( LocalDate toDate, LocalDate fromDate , long campgroundId, String openFromMM, String openToMM){ // i erased site id from parameter... should i put it back??
	//
		List<Site> availSites = new ArrayList<Site>();
		String availabilitySQL = "select * "  
		                        +"from site "  
		                        +" where site_id IN(select site.site_id "                    
		                                          +"from site "
		                                          +" where site.site_id NOT IN  " 
		                                                                     +" (select reservation.site_id "      
		                                                                     +" from reservation "  
		                                                                     +" where ? < to_date " 
		                                                                     +" and ? > from_date)) "   
		                                                                     +" and ? IN (select site.campground_id "          
		                                                                                           +"from site "
		                                                                                           +"where site.campground_id in (select campground_id "   
		                                                                                           +"from campground "   
		                                                                                           +"where ? >= open_from_mm  "  //how do i get the user input month
		                                                                                           +" and ? <= open_to_mm )) "   //^^ 
		                                                                                           +" and campground_id = ? "                 
		   +"limit 5; "
		   +";";
	
	
		SqlRowSet resultFromSQL = jdbcTemplate.queryForRowSet(availabilitySQL, toDate, fromDate, campgroundId, openFromMM, openToMM, campgroundId);
		while(resultFromSQL.next()) {
			Site aSite = mapRowToSite(resultFromSQL);
			availSites.add(aSite);
		}
	return availSites;
	
	}
		
	
	//@Override
	//public Site getAvailSiteByMaxOc(int maxoc) {
		// TODO Auto-generated method stub
		//return null;
	//}

	//@Override
	//public Site getAvailSiteById(Long id) {
		// TODO Auto-generated method stub
		//return null;
	//}

	//@Override
	//public Site getAvailSiteByCost(double costPerNight) {
		// TODO Auto-generated method stub
		//return null;
	//}

//	@Override
//	public Site getAvailSiteByAccess(boolean accessible) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	//HELPER METHODS
	private long getNextSiteId() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_site_id')");
		if(nextIdResult.next()) {
			return nextIdResult.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an id for the new site");
		}
	}
	
	private Site mapRowToSite(SqlRowSet aRow) {
	Site aSite = new Site(); 
	aSite.setSiteId(aRow.getLong("site_id"));	
	aSite.setCampgroundId(aRow.getLong("campground_id"));	
	aSite.setSiteNumber(aRow.getInt("site_number"));
	aSite.setMaxoc(aRow.getInt("site_number"));
	aSite.setAccessible(aRow.getBoolean("accessible"));
	aSite.setMaxRvLength(aRow.getInt("max_rv_length"));
	aSite.setUtilities(aRow.getBoolean("utilities"));
	return aSite;
	}
	
	
}
