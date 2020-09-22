package com.techelevator.hotels;

import java.util.Scanner;

import org.springframework.web.client.RestTemplate;

public class App {
	
	 // private static are common attributes for a constant - static - only one defined 
	private static final String API_BASE_URL = "http://localhost:3000/";  // This is the home URL for our server
	                                                                      // Starting point for all our API calls
	
	// Define a RestTemplate object to make our API calls

	private static final RestTemplate restTemplate =new RestTemplate();   // Framework API interface object

    public static void main(String[] args) {
    	run();
    }

    private static void run() {
        Hotel[] hotels = null;
        Scanner scanner = new Scanner(System.in);
        int menuSelection = 999;
        
        int hotelWeWant = 1;  // Somehow you get a value for the hotel id you want (from database, user keyboard, calculation)
        int starsWeWant = 3;  // Somehow you get a value for the stars you want (from database, user keyboard, calculation)

        
        printGreeting();

        while(menuSelection != 0) {
            try {
                menuSelection = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException exception) {
                System.out.println("Error parsing the input for menu selection.");
            }
            System.out.println("");
            if (menuSelection == 1) {
            	// Call the hotel API to get all the hotels it knows about and pass it to printHotels().
                // Constructing the URL to be: "http://localhost:3000/hotels"  
            	//                             We are telling RestTemplate we want an array of Hotel objects returnd
            	//                             You want it to turn JSON from the API in array of Hotel objects
               printHotels(restTemplate.getForObject(API_BASE_URL + "hotels", Hotel[].class));   // Array of Hotel objects returned 
            } else if (menuSelection == 2) {
               printReviews(restTemplate.getForObject(API_BASE_URL + "reviews", Review[].class));
            } else if (menuSelection == 3) {
            	 printHotel(restTemplate.getForObject(API_BASE_URL + "hotels/" + hotelWeWant, Hotel.class));  // Single Hotel object returned
            } else if (menuSelection == 4) {
            	 printReviews(restTemplate.getForObject(API_BASE_URL + "reviews?hotelID="+hotelWeWant, Review[].class));
            } else if (menuSelection == 5) {
            	 printHotels(restTemplate.getForObject(API_BASE_URL + "hotels?stars="+starsWeWant, Hotel[].class));   // Array of Hotel objects returned 
                 
            } else if (menuSelection == 6) {
                System.out.println("Not implemented - Create a custom Web API query here");
            } else if (menuSelection == 0) {
                continue;
            } else {
                System.out.println("Invalid Selection");
            }
            menuSelection = 999;
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();
            printGreeting();
        }
        scanner.close();
        System.exit(0);
    }

    private static void printGreeting() {
        System.out.println("");
        System.out.println("Welcome to Tech Elevator Hotels. Please make a selection: ");
        System.out.println("1: List Hotels");
        System.out.println("2: List Reviews");
        System.out.println("3: Show Details for Hotel ID 1");
        System.out.println("4: List Reviews for Hotel ID 1");
        System.out.println("5: List Hotels with star rating 3");
        System.out.println("6: Custom Query");
        System.out.println("0: Exit");
        System.out.println("");
        System.out.print("Please choose an option: ");
    }

    private static void printHotels(Hotel[] hotels) {
        System.out.println("--------------------------------------------");
        System.out.println("Hotels");
        System.out.println("--------------------------------------------");
        for (Hotel hotel : hotels) {
            System.out.println(hotel.getId() + ": " + hotel.getName());
        }
    }

    private static void printHotel(Hotel hotel) {
        System.out.println(hotel.toString());
    }

    private static void printReviews(Review[] reviews) {
        for (Review review : reviews) {
            System.out.println(review.toString());
        }
    }

}
