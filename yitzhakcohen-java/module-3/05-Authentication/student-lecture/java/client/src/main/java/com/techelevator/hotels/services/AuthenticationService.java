package com.techelevator.hotels.services;

import com.techelevator.hotels.models.LoginDTO;
import org.springframework.http.*;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Map;

public class AuthenticationService {

    private String BASE_URL;
    private RestTemplate restTemplate = new RestTemplate();
    private ConsoleService console = new ConsoleService();

    public AuthenticationService(String url) {		// The server URL is passed into the constructor 
        this.BASE_URL = url;						// Storing URL passed in as BASE_URL
    }

    // This method is called to login a user
    // Receives the login String user,password
    // Returns a ResponseEntity<Map>
    
    public ResponseEntity<Map> login(String credentials) throws AuthenticationServiceException {
        // LoginDTO is a class defined to hold the username and password of a user
    	LoginDTO loginDTO = new LoginDTO(credentials);	// Data Transfer Object (DTO) for the username and password
        
    	HttpHeaders headers = new HttpHeaders();		// Setup HTTP Headers for request
    	
        headers.setContentType(MediaType.APPLICATION_JSON); // Set Content-Type to APPLICATION_JSON
        
        HttpEntity<LoginDTO> entity = new HttpEntity<>(loginDTO, headers); // Build request header with loginDTO object and Content-Type
        
        // ResponseEntity is a class to hold response data from an HTTP request
        ResponseEntity<Map> response = null;	// Response is null right now as we have not issued the request
        
        try {	// Use 'convenience method' called exchange() to makkeAPI call to login and get response
            response = restTemplate.exchange(BASE_URL + "/login", HttpMethod.POST, entity, Map.class);
        } catch(RestClientResponseException ex) {
            if (ex.getRawStatusCode() == 401 && ex.getResponseBodyAsString().length() == 0) {
                String message = ex.getRawStatusCode() + " : {\"timestamp\":\"" + LocalDateTime.now() + "+00:00\",\"status\":401,\"error\":\"Invalid credentials\",\"message\":\"Login failed: Invalid username or password\",\"path\":\"/login\"}";
                throw new AuthenticationServiceException(message);
            }
            else {
                String message = ex.getRawStatusCode() + " : " + ex.getResponseBodyAsString();
                throw new AuthenticationServiceException(message);
            }
        }
        return response;	// Response will be null if the request fails and will have the response from login if it didnt
    }

}
