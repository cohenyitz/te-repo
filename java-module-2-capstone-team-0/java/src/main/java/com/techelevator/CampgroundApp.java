package com.techelevator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.model.campground.Campground;
import com.techelevator.model.campground.JdbcCampgroundDAO;
import com.techelevator.model.park.JdbcParkDAO;
import com.techelevator.model.park.Park;
import com.techelevator.model.park.ParkDAO;
import com.techelevator.model.reservation.*;
import com.techelevator.model.site.JdbcSiteDAO;
import com.techelevator.model.site.Site;
import com.techelevator.view.*;

public class CampgroundApp  {
	
	/****************************************************************************************************
	 * This is the Campground Reservation system application program
	 * 
	 * Any and all user interactions should be placed in the CampgroundUI class 
	 *     which is in the com.techelevator.view package.
	 *     
	 * This application program should instantiate a CampgroundUI object 
	 *      and use its methods to interact with the user.
	 *      
	 * This application program should contain no user interactions.
	 * 
	 * Any and all database accesses should be placed in the appropriate
	 *     com.techelevator.model.tablename package component
	 *     
	 * This application program should instantiate DAO objects and use the methods
	 *     in the DAO to interact with the database tables.   
	 *     
	 * There should be no SQL in this application program
	 *   
	 ***************************************************************************************************/
	
	//Adding this line because it is saying that everything is up to date but its not... i have made changes :)
	// IT IS STILL NOT LETTIN ME UPLOAD UGHHHHHHHHH
	public static void main(String[] args) {
		
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/campground");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");

		CampgroundUI userInterface = new CampgroundUI();  // Object to manage user interactions;
		                                                  // Feel free to change the name
		
		
		/****************************************************************************************************
		 * Instantiate any DAOs you will be using here
		 ***************************************************************************************************/
		JdbcParkDAO aParkDao = new JdbcParkDAO(dataSource);
		JdbcCampgroundDAO aCampgroundDao = new JdbcCampgroundDAO(dataSource);
		JdbcSiteDAO aSiteDao = new JdbcSiteDAO(dataSource);
		JdbcReservationDAO aReservationDao = new JdbcReservationDAO(dataSource);
		/****************************************************************************************************
		 * Your application programming logic goes here
		 ***************************************************************************************************/
		userInterface.welcomeUser();
		
		List<Park> listOfParks = aParkDao.getAllParks(); //call DAO method
		//userInterface.parkInfo(listOfParks);
		String userChoice = userInterface.pickAPark(listOfParks); //get info from UI
		Park aPark = aParkDao.getAParkByName(userChoice); // call DAO method
		
		List<Campground> listOfCampgrounds = aCampgroundDao.getAllCampgroundsByPName(aPark.getName()); // call DAO method 							
		
		String userChoice2 = userInterface.pickACampground(listOfCampgrounds); // changed this to an object so that i can do a .getName() 
																				// getting issues now in the UI
		//Campground test = aCampgroundDao.getCampgroundById(Long.parseLong(userChoice2));
		
		Campground aCampground = aCampgroundDao.getACampgroundByName(userChoice2); 
		//System.out.println(test);
		
		LocalDate userChoice3 = userInterface.getFromDate(); 
		LocalDate userChoice4 = userInterface.getToDate();
		List<Site> listOfSites = aSiteDao.getAllAvailSitesByCGId(userChoice4, userChoice3, aCampground.getCampgroundId(), aCampground.getOpenFromMM(), aCampground.getOpenToMM());
		
		Site userChoice5 = userInterface.pickASite(listOfSites);
		
		Site aSite = aSiteDao.getSiteById((userChoice5.getSiteId())); // issue looking for an int but userChoice5 is a String i think the 
		
		String userChoice6 = userInterface.createReservation();
		Reservation aReservation = aReservationDao.saveReservation(userChoice5.getSiteId(), userChoice6, userChoice3, userChoice4, LocalDate.now());//saveReservation(aSite.getSiteId(), userChoice6, userChoice3, userChoice4, LocalDate.now());
		
		
														//should we switch in saveReservation back to an int and date instead of long and localdate
		System.out.println("Your reservation details: ");
		System.out.println(aReservation+ "\n");
		userInterface.goodbyeUser();
	}
}
