package com.techelevator.view;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.techelevator.model.campground.Campground;
import com.techelevator.model.park.Park;
import com.techelevator.model.park.ParkDAO;
import com.techelevator.model.reservation.Reservation;
import com.techelevator.model.site.Site;

public class CampgroundUI {

	/*******************************************************************************************************
	 * This is the CampgroundUI class
	 * 
	 * All user interactions should be coded here
	 * 
	 * The application program will instantiate an object of this class and use the object to interact
	 * with the user.
	 * 
	 * And data required from the user for the application will be acquired by methods of this class
	 * and sent back to the user either as the return value from the method or in an object returned
	 * from the method.
	 * 
	 * Any messages the application programmer wishes to display to the user may be sent to methods of
	 * this class as variables or objects.  Any messaging method may also have "canned" messages the
	 * user may request by a message id.
	 * 
	 *******************************************************************************************************/


	/*******************************************************************************************************
	 * Menu class object
	 * 
	 * Use this Menu object for ALL Menu choices presented to the user
	 * 
	 * This is the same Menu class discussed in module 1 and made available in the module 1 capstone
	 * 
	 * 
	 ******************************************************************************************************/

	Menu CampMenu = new Menu(System.in, System.out);  // Define menu for keyboard input and screen output

	/*******************************************************************************************************
	 * Class member variables, objects, constants and methods should be coded here. 
	 ******************************************************************************************************/
	public void welcomeUser() {
		System.out.println("Welcome to National Park Campsite");

	}

	//NEED TO PUT IN DEFENSE CODING

	public String pickAPark(List<Park> listOfParks) {
		System.out.println("\nPlease enter a name of the park you wish to visit. \n");
		String [] parkInfo = new String[listOfParks.size()];

		for(int i = 0; i < parkInfo.length; i++) { 
			parkInfo[i] = listOfParks.get(i).getName();//+  "\n Location: "+ listOfParks.get(i).getLocation() + "\n Established: "
					 //+ listOfParks.get(i).getEstablishDate() +"\n Area: " + listOfParks.get(i).getArea() + "\n Annual Visitors: "
					//+listOfParks.get(i).getVisitors() + "\n" + listOfParks.get(i).getDescription() +"\n";

		}
		//parkInfo[parkInfo.length -1] = "Quit";
		String parkChoice = (String) CampMenu.getChoiceFromOptions(parkInfo);

		return parkChoice;
	}
	// added all the info about the park but i dont think we want that...i think we just want the name so that we can return a String not a whole object 
	
	
//	public void parkInfo(List<Park> listOfParks) {
//		String [] parkInfo = new String[listOfParks.size()];
//
//		for(int i = 0; i < parkInfo.length; i++) { 
//			parkInfo[i] = listOfParks.get(i).getName()+  "\n Location: "+ listOfParks.get(i).getLocation() + "\n Established: "
//					 + listOfParks.get(i).getEstablishDate() +"\n Area: " + listOfParks.get(i).getArea() + "\n Annual Visitors: "
//					+listOfParks.get(i).getVisitors() + "\n" + listOfParks.get(i).getDescription() +"\n";
//
//		System.out.println(parkInfo);
//		}
//	
//	}
	
	
	
	

	public String pickACampground(List<Campground> listOfCampgrounds) { // i changed the return type to an Object
		System.out.println("\nPlease enter a number of the campground you wish to visit. \n");
		String [] campgroundInfo = new String[listOfCampgrounds.size()];

		for(int i = 0; i < campgroundInfo.length; i++) {
			campgroundInfo[i] = listOfCampgrounds.get(i).getName(); //+ "\n Month Open: " + listOfCampgrounds.get(i).getOpenFromMM() + "\n Month Closed: "
					//+ listOfCampgrounds.get(i).getOpenToMM() + "\n Daily Fee: $" + listOfCampgrounds.get(i).getDailyFee() + "\n" + listOfCampgrounds.get(i).getCampgroundId().toString();	
		}

		String campgroundChoice = (String) CampMenu.getChoiceFromOptions(campgroundInfo); // was a String and cast to a String so i changed that to an object 
		return campgroundChoice; // changed to an Object 
	}

	
	
	
	
	
// yitz...you added all the info about the campground in pickACampground maybe we should take it all out and just have
// get a name so that we can return a String not a Campground Object 

public LocalDate getFromDate()  { 
		System.out.println("Please enter the date you wish to come. YYYY-MM-DD ");

		Scanner userInput = new Scanner(System.in);
		String userResponse = userInput.nextLine();
		String fromDate = userResponse;

		LocalDate test = LocalDate.parse(fromDate);
		

	//System.out.println("Oops input invalid"); once we put in defense coding 

return test;	
	}


	public LocalDate getToDate()  { 
		System.out.println("Please enter the date you wish to leave. YYYY-MM-DD ");

		Scanner userInput = new Scanner(System.in);
		String userResponse = userInput.nextLine();
		String toDate = userResponse;
		LocalDate test = LocalDate.parse(toDate);
		return test ;
	}

	public Site pickASite(List<Site> listOfSites) {
		System.out.println("Please enter a site you wish to book");

		Site[] sites = new Site[listOfSites.size()];

		for(int i = 0; i < sites.length; i++) {
			sites[i] = listOfSites.get(i);
		}
		Site siteChoice = (Site) CampMenu.getChoiceFromOptions(sites);
		return siteChoice;
	}
	
	public String createReservation() {
		System.out.println("Please enter the name you wish to save you reservation under");
		Scanner userInput = new Scanner(System.in);
		String userResponse = userInput.nextLine();
		String userName = userResponse;
		return userName;
	}
	
	public void goodbyeUser() {
		System.out.println("Thank You For Booking With Us Have A Great Day :) ");
	}
}






	// i think i want to call the Menu method getChoiceFromUserInput however it is not allowing me to call that method
	//because if it gets the dates the user put in... 
	//i can create a String and set it equal to the results of calling the getToDate method in my app 
	//and then i can pass those results into the toDate parameter of the getallavailsitesbycgid  








//public String userInput(LocalDate fromDate, LocalDate toDate) {
//String [] campgroundDates = new String [1];
//campgroundDates = "What is the arrival date? (mm/dd/yyyy) \n"; 

//String userFromDate = (String) CampMenu.getChoiceFromOptions(options).getChoiceFromUserInput(campgroundDates);
//System.out.println("What is the departure date? (mm/dd/yyyy) \n");
//String userInput = (String) CampMenu.getChoiceFromOptions();
//return   campgroundWish;




// WHAT IF WE JUST ASK THE USER WHICH CAMPGROUND THEY WOULD LIKE TO VISIT
// THEN THEY ENTER A NUMBER OF WHICH WHICH CAMPGROUND
// THE NEXT SCREEN ASKS THEM TO ENTER FROM_DATE AND TO_DATE
// THEN WE SHOW THEM THE AVAILABLE SITES BASED ON THEIR DATES




