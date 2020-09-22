package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDAO;
import com.techelevator.reservations.dao.MemoryHotelDAO;
import com.techelevator.reservations.dao.MemoryReservationDAO;
import com.techelevator.reservations.dao.ReservationDAO;
import com.techelevator.reservations.models.Hotel;
import com.techelevator.reservations.models.Reservation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//
// This holds controllers for this server app
//
// This is where we assign url paths to functions
//
@RestController		// This tells the server there are controllers in this file
public class HotelController {

    private HotelDAO hotelDAO;
    private ReservationDAO reservationDAO;

    public HotelController() {
        this.hotelDAO = new MemoryHotelDAO();
        this.reservationDAO = new MemoryReservationDAO(hotelDAO);
    }

    /**
     * Return All Hotels
     *
     * @return a list of all hotels in the system
     * 
     * Function to handle Get request with /hotels path in the server url
     * 
     * 
     */
    @RequestMapping(path = "/hotels", method = RequestMethod.GET)
    public List<Hotel> list() {
        return hotelDAO.list();
    }

    /**
     * Return hotel information
     *
     * @param id the id of the hotel
     * @return all info for a given hotel
     * 
     * Function to handle GET request with /hotels/id path in the server
     * 
     */
    @RequestMapping(path = "/hotels/{id}", method = RequestMethod.GET)
    public Hotel get(@PathVariable int id) {
        return hotelDAO.get(id);
    }
    //Write a controller to return all reservations when we get the path "/reservations"
    @RequestMapping(path="/reservations", method=RequestMethod.GET) 
    public List<Reservation> allReservations() {
    	return reservationDAO.findAll();
    }
    
    // Write a controller to add a reservation to our Reservation resource 
    //		using the path "/hotels/id/reservations" for a POST request
    //
    // http:localhost:8080/hotel/1/reservations - should add a reservation for hotel id 1
    //
    // The data for the new reservation will be in the body of the request since its a POST
    //
    // Use @ReqestBody to get the reservation data 
    // Use @PathVariable to get the hotel id
    
    @RequestMapping(path="hotels/{id}/reservations", method=RequestMethod.POST) // POST method is used to add data
    public Reservation addAReservation(@RequestBody Reservation aReservation // Create a reservation object using the data in the request body
    								  ,@PathVariable("id") int hotelId)		 // Get the id variable from path and store in an int called hotelId
    		
    {
    	// 1. Call the DAO to add a Reserveration aobject to the data resource (create)
    	// 2. Return the Reservation objectadded to the resource to called of the API
    	return reservationDAO.create(aReservation, hotelId);
    }
    
    
    
    

}
