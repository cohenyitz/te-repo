package com.techelevator.tenmo.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.tenmo.dao.TransferSqlDAO;
import com.techelevator.tenmo.model.Transfer;

@PreAuthorize("isAuthenticated()")
@RestController
public class TransferController {

private TransferSqlDAO transferDAO;
	
	public TransferController(TransferSqlDAO tranfserDAO) {
		this.transferDAO = tranfserDAO;
	}
	
    @RequestMapping(path = "/transfers/send", method = RequestMethod.POST)
    public void makeSend(@RequestBody Transfer newSend) {
    	transferDAO.createSend(newSend);
    }
    
    @RequestMapping(path = "/transfers/request", method = RequestMethod.POST)
    public void makeRequest(@RequestBody Transfer newRequest) {
    	transferDAO.createRequest(newRequest);
    }
    
    @RequestMapping(path="/transfers/{accountNumber}", method = RequestMethod.GET)		
    public List <Transfer> getTransferHistory(@PathVariable int accountNumber) {
    	return  transferDAO.getTransferHistory(accountNumber); //returning a list of transfers based on accountNumber(aka id)
    }														   // talks to DAO to get data 
    
    @RequestMapping(path="/transfers/pending/{accountNumber}", method = RequestMethod.GET)		
    public List <Transfer> getPendingTransfers(@PathVariable int accountNumber) {
    	return  transferDAO.getPendingTransfers(accountNumber);
    }

    @RequestMapping(path = "/transfers/getById/{transferID}", method = RequestMethod.GET)
    public Transfer getTransferByID(@PathVariable int transferID) {
    	return transferDAO.getTransferById(transferID);
    }
    
    @RequestMapping(path = "/transfers/update_status", method = RequestMethod.POST)
    public void updateStatus(@RequestBody Transfer theTransfer) {
    	transferDAO.updateStatus(theTransfer);
    }
}


