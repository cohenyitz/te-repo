package com.techelevator.tenmo.services;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.techelevator.tenmo.models.Account;
import com.techelevator.tenmo.models.User;
import com.techelevator.view.ConsoleService;

public class AccountServices {
	
	private static String AUTH_TOKEN = "";
    private RestTemplate restTemplate = new RestTemplate();
    private final String USERS_URL;
	
    public AccountServices(String url) {
    	this.USERS_URL = url + "/users";
    }
    
	public Account getUserAccount(String userToken, int userID) { 
		AUTH_TOKEN = userToken;
		Account userAccount = null;
        try {
        	userAccount = restTemplate.exchange(USERS_URL + "/" //Use the restTemplate.exchange method to send an HTTP GET request to the server
                                               + userID + "/account"
                                               , HttpMethod.GET, makeAuthEntity()
                                               , Account.class).getBody(); //use .getBody() to get data out of response body, once we get info back from server
        } catch (RestClientResponseException ex) {
            
        }
        return userAccount;
	}
	
	
	public double withdraw(String userToken, int userID, double amountToWithdraw) {
    	AUTH_TOKEN = userToken;
    	double newBalance = 0;
    	try {
    		newBalance = restTemplate.exchange(USERS_URL + "/" + userID + "/withdraw?amount=" + amountToWithdraw, 
    										   HttpMethod.GET, makeAuthEntity(), double.class).getBody();
        } catch (RestClientResponseException ex) {
            
        }
        return newBalance;
	}
	
	public double deposit(String userToken, int userID, double amountToDeposit) {
    	AUTH_TOKEN = userToken;
    	double newBalance = 0;
    	try {
    		newBalance = restTemplate.exchange(USERS_URL + "/"+ userID + "/deposit?amount=" + amountToDeposit, 
    										   HttpMethod.GET, makeAuthEntity(), double.class).getBody();
        } catch (RestClientResponseException ex) {
            
        }
        return newBalance;
	}
	
	private HttpEntity makeAuthEntity() {
	        HttpHeaders headers = new HttpHeaders();
	        headers.setBearerAuth(AUTH_TOKEN);
	        HttpEntity entity = new HttpEntity<>(headers);
	        return entity;
	}
	

}
