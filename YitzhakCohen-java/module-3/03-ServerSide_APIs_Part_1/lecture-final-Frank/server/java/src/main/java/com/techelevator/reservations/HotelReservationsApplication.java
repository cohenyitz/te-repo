package com.techelevator.reservations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//
// This is our main server app - main() and @SpringBootApplication
//
// SpringBoot is a framework to implement REST server applications
//
@SpringBootApplication // Tell SpringBoot that is a server app
public class HotelReservationsApplication {

    public static void main(String[] args) {
    	// SpringApplication.run() - Spring Boot method to start a server for the app`
    	// Pass .run the Class that is the application
        SpringApplication.run(HotelReservationsApplication.class, args);
    }

}
