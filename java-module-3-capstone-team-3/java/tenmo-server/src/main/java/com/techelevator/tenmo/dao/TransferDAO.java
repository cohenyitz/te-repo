package com.techelevator.tenmo.dao;

import java.util.List;

import com.techelevator.tenmo.model.Transfer;

public interface TransferDAO {
	
	public void createSend(Transfer newSend);
	
	public void createRequest(Transfer newRequest);
	
	public List<Transfer> listAll();
	
	public Transfer getByID(int transferID);
	
	public List<Transfer> getTransferHistory(int accountId);
	
	public List<Transfer> getPendingTransfers(int accountId);

	public Transfer getTransferById(int transferID);
	
	public void updateStatus(Transfer theTransfer);
}
