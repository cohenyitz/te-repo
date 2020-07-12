package com.techelevator.tenmo.services;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.techelevator.tenmo.models.Transfer;


public class TransferServices {

	private static String AUTH_TOKEN = "";
    private RestTemplate restTemplate = new RestTemplate();
    private final String TRANSFERS_URL;
	
    public TransferServices(String url) {
    	this.TRANSFERS_URL = url + "/transfers";
    }
    
    public void makeSend(String userToken, int accountFrom, int accountTo, double amount) {
    	AUTH_TOKEN = userToken;
    	Transfer thisSend = makeNewSend(accountFrom, accountTo, amount);
        try {
        	restTemplate.exchange(TRANSFERS_URL + "/send", 
        			                         HttpMethod.POST, makeTransferEntity(thisSend), 
        			                         Transfer.class).getBody();
        } catch (RestClientResponseException ex) {
        }
    }
    
    public void makeRequest(String userToken, int accountFrom, int accountTo, double amount) {
    	AUTH_TOKEN = userToken;
    	Transfer thisRequest = makeNewRequest(accountFrom, accountTo, amount);
        try {
        	restTemplate.exchange(TRANSFERS_URL + "/request", 
        			              HttpMethod.POST, makeTransferEntity(thisRequest), 
        			              Transfer.class).getBody();
        } catch (RestClientResponseException ex) {
        }
    }
    
    public Transfer getTransferById(String userToken, int transferID) {
    	AUTH_TOKEN = userToken;
    	Transfer aTransfer = null;
    	try {
    		aTransfer = restTemplate.exchange(TRANSFERS_URL + "/getById/" + transferID, HttpMethod.GET, makeAuthEntity(), Transfer.class).getBody();
    	} catch (RestClientResponseException ex) {
    }
    return aTransfer;
    }
    
    public Transfer[] listAll() {
    	Transfer [] allTransfers = null;
        try {
        	allTransfers = restTemplate.exchange(TRANSFERS_URL, HttpMethod.GET, makeAuthEntity(), Transfer[].class).getBody();
        } catch (RestClientResponseException ex) {
            
        }
        return allTransfers;
    }
    
    public Transfer[] getTransferHistory(String userToken, int accountId) { //interact with APIs on server (controller) to get transfer history based on given accountid
    	AUTH_TOKEN = userToken;
    	
    	Transfer [] allTransfers = null;
        try {
        	allTransfers = restTemplate.exchange(TRANSFERS_URL + "/" + accountId, HttpMethod.GET, makeAuthEntity(), Transfer[].class).getBody();
        } catch (RestClientResponseException ex) {
            
        }
        return allTransfers;
    }
    
    public Transfer[] getPendingTransfers(String userToken, int accountId) {
    	AUTH_TOKEN = userToken;
    	
    	Transfer [] pendingTransfers = null;
        try {
        	pendingTransfers = restTemplate.exchange(TRANSFERS_URL + "/pending/" + accountId, HttpMethod.GET, makeAuthEntity(), Transfer[].class).getBody();
        } catch (RestClientResponseException ex) {
            
        }
        return pendingTransfers;
    }
    
    public void updateTransferStatus(String userToken, Transfer theTransfer) {
    	AUTH_TOKEN = userToken;
        try {
        	restTemplate.exchange(TRANSFERS_URL + "/update_status", 
        			                         HttpMethod.POST, makeTransferEntity(theTransfer), 
        			                         Transfer.class).getBody();
        } catch (RestClientResponseException ex) {
        }
    }

    
    private Transfer makeNewSend(int accountFrom, int accountTo, double amount) {
    	Transfer thisSend = new Transfer();
    	thisSend.setTransferTypeId(2);
    	thisSend.setTransferStatusId(2);
    	thisSend.setAccountFrom(accountFrom);
    	thisSend.setAccountTo(accountTo);
    	thisSend.setAmount(amount);
    	return thisSend;
    }
    
    private Transfer makeNewRequest(int accountFrom, int accountTo, double amount) {
    	Transfer thisRequest = new Transfer();
    	thisRequest.setTransferTypeId(1);
    	thisRequest.setTransferStatusId(1);
    	thisRequest.setAccountFrom(accountTo);
    	thisRequest.setAccountTo(accountFrom);
    	thisRequest.setAmount(amount);
    	return thisRequest;
    }
    
    private HttpEntity makeAuthEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(AUTH_TOKEN);
        HttpEntity entity = new HttpEntity<>(headers);
        return entity;
    }
    
    private HttpEntity makeTransferEntity(Transfer newTransfer) {
    	HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(AUTH_TOKEN);
        HttpEntity<Transfer> entity = new HttpEntity<>(newTransfer, headers);
        return entity;
    }
    
}
