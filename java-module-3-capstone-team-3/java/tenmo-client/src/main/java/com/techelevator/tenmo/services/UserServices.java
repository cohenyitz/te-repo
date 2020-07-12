package com.techelevator.tenmo.services;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.techelevator.tenmo.models.User;

public class UserServices {

	private static String AUTH_TOKEN = "";
    private RestTemplate restTemplate = new RestTemplate();
    private final String USERS_URL;
	
    public UserServices(String url) {
    	this.USERS_URL = url + "/users";
    }
    
    public User[] listAll(String userToken) {
    	AUTH_TOKEN = userToken;
    	User[] users = null;
        try {
        	users = restTemplate.exchange(USERS_URL, HttpMethod.GET, makeAuthEntity(),User[].class).getBody();
        } catch (RestClientResponseException ex) {
            
        }
        return users;
    }
    
    public User getUserWithAccount(String userToken, int accountNumber) {
    	AUTH_TOKEN = userToken;
    	User user = null;
        try {
        	user = restTemplate.exchange(USERS_URL + "/" + accountNumber, HttpMethod.GET, makeAuthEntity(), User.class).getBody();
        } catch (RestClientResponseException ex) {
            
        }
        return user;
    }
    
    private HttpEntity makeAuthEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(AUTH_TOKEN);
        HttpEntity entity = new HttpEntity<>(headers);
        return entity;
    }

}
