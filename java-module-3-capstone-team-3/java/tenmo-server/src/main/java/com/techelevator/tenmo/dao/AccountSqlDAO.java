package com.techelevator.tenmo.dao;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.techelevator.tenmo.model.Account;

@Service 
public class AccountSqlDAO implements AccountDAO {

	private JdbcTemplate jdbcTemplate;

    public AccountSqlDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
	
	@Override
	public Account getUserAccount(int userID) {
		Account thisAccount = null;
        SqlRowSet result = jdbcTemplate.queryForRowSet("select * from accounts where user_id = ?", userID);
        if (result.next()) {
        	thisAccount = mapRowToAccount(result);
        }
        return thisAccount;
	}

	@Override
	public double deposit(int userID, double amount) {
		double oldBalance = getUserAccount(userID).getBalance();
		double newBalance = oldBalance += amount;
		String updateBalance = "update accounts set balance = ? where user_id = ?";
        jdbcTemplate.update(updateBalance, newBalance, userID);
        return newBalance;
	}
	
	@Override
	public double withdraw(int userID, double amount) {
		double oldBalance = getUserAccount(userID).getBalance();
		double newBalance = oldBalance -= amount;
		String updateBalance = "update accounts set balance = ? where user_id = ?";
        jdbcTemplate.update(updateBalance, newBalance, userID);
        return newBalance;
	}
	
	 private Account mapRowToAccount(SqlRowSet rs) {
		 Account account = new Account();
		 account.setAccountId(rs.getInt("account_id"));
	     account.setUserId((rs.getInt("user_id")));
	     account.setBalance(rs.getDouble("balance")); 
	     return account;
	    }
}
