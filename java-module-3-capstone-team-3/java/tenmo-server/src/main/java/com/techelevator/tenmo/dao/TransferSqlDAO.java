package com.techelevator.tenmo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;

@Service
public class TransferSqlDAO implements TransferDAO {

	private JdbcTemplate jdbcTemplate;

    public TransferSqlDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
	
	@Override
	public void createSend(Transfer newSend) {
		String insertTransfer = "insert into transfers "
				              + "(transfer_type_id, "
				              + "transfer_status_id, "
				              + "account_from, account_to, "
				              + "amount) values(?,?,?,?,?)";
        jdbcTemplate.update(insertTransfer, 
        		            newSend.getTransferTypeId(),
        		            newSend.getTransferStatusId(), 
        		            newSend.getAccountFrom(), 
        		            newSend.getAccountTo(), 
        		            newSend.getAmount());
	}
	
	@Override
	public void createRequest(Transfer newRequest) {
		String insertTransfer = "insert into transfers "
				              + "(transfer_type_id, "
				              + "transfer_status_id, "
				              + "account_from, account_to, "
				              + "amount) values(?,?,?,?,?)";
        jdbcTemplate.update(insertTransfer, 
        		            newRequest.getTransferTypeId(), 
        		            newRequest.getTransferStatusId(), 
        		            newRequest.getAccountFrom(), 
        		            newRequest.getAccountTo(), 
        		            newRequest.getAmount());
	}

	@Override
	public List<Transfer> listAll() {
		List<Transfer> transfers = new ArrayList<>();
        String sql = "select * from transfers";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Transfer transfer = mapRowToTransfer(results);
            transfers.add(transfer);
        }

        return transfers;
	}

	@Override
	public Transfer getByID(int transferID) {
		for (Transfer transfer : this.listAll()) {
            if( transfer.getTransferId() == transferID) {
                return transfer;
            }
        }
        return null;
	}
	
	
	public List<Transfer> getTransferHistory(int accountId) {	//this method gets transfer history where account_from
			List<Transfer> transferHistroy = new ArrayList<>(); //	and account_to equals to accountid provided by user 
			String sql = "select * " + 
						 "from transfers " + 
					     "where account_from = ? " + 
					     "OR account_to = ? " ;
					
			 SqlRowSet results = jdbcTemplate.queryForRowSet(sql, accountId, accountId);
		        while(results.next()) {
		            Transfer transfer = mapRowToTransfer(results);
		            transferHistroy.add(transfer);
		        }

		        return transferHistroy;
		}
	
	public List<Transfer> getPendingTransfers(int accountId) {
		List<Transfer> transferHistroy = new ArrayList<>();
		String sql = "select * " + 
					 "from transfers " + 
				     "where account_from = ? " + 
				     "and transfer_status_id = 1 " ;
				
		 SqlRowSet results = jdbcTemplate.queryForRowSet(sql, accountId);
	        while(results.next()) {
	            Transfer transfer = mapRowToTransfer(results);
	            transferHistroy.add(transfer);
	        }

	        return transferHistroy;
	}
	
	public void updateStatus(Transfer theTransfer) {
		String insertUpdate = "update transfers "
	                        + "set transfer_status_id = ? "
				            + "where transfer_id = ?";
		jdbcTemplate.update(insertUpdate, 
							theTransfer.getTransferStatusId(), 
							theTransfer.getTransferId());
	}

	
	private Transfer mapRowToTransfer(SqlRowSet rs) {
        Transfer transfer = new Transfer();
        transfer.setTransferId(rs.getInt("transfer_id"));
        transfer.setTransferTypeId(rs.getInt("transfer_type_id"));
        transfer.setTransferStatusId(rs.getInt("transfer_status_id"));
        transfer.setAccountFrom(rs.getInt("account_from"));
        transfer.setAccountTo(rs.getInt("account_to"));
        transfer.setAmount(rs.getDouble("amount"));
        return transfer;
    }

	@Override
	public Transfer getTransferById(int transferID) {
		Transfer aTransfer = new Transfer();
		String sql = "SELECT * " +
					 "FROM transfers " +
					 "WHERE transfer_id = ? ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, transferID);			 
		if(results.next()) {
			aTransfer = mapRowToTransfer(results);
		}
		return aTransfer;
	}

}
