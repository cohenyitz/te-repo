package com.techelevator.reservations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//
// This is our main server app -main() and @SpringBootApplication
//
// SpringBoot is a framework to implement REST server application
//
@SpringBootApplication	// Tells SpringBoot that this is a server app
public class HotelReservationsApplication {

    public static void main(String[] args) {
    	// SpringApplication.run() - is SpringBoot method to start server for the app
    	// Pass .run the class that is the application
        SpringApplication.run(HotelReservationsApplication.class, args);
    }

}
