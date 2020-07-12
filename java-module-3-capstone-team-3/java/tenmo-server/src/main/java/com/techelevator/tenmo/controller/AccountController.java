package com.techelevator.tenmo.controller;

import java.security.Principal;

import javax.activation.DataSource;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.tenmo.dao.AccountSqlDAO;
import com.techelevator.tenmo.dao.UserSqlDAO;
import com.techelevator.tenmo.model.Account;

@RestController
@PreAuthorize("isAuthenticated()")
public class AccountController {
	
	private UserSqlDAO userDAO;
	private AccountSqlDAO accountDAO;
	
	public AccountController(UserSqlDAO userDAO, AccountSqlDAO accountDAO) {
		this.userDAO = userDAO;
		this.accountDAO = accountDAO;
	}
	
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(path = "/users/{userID}/account", method = RequestMethod.GET)
	public Account getUserAccount(@PathVariable int userID) {
		return accountDAO.getUserAccount(userID); // // calls and gets user account data from AccountDAO and SQL
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(path = "/users/{userID}/withdraw", method = RequestMethod.GET)
	public double withdraw(@PathVariable int userID, @RequestParam double amount) {
		return accountDAO.withdraw(userID, amount);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(path = "/users/{userID}/deposit", method = RequestMethod.GET)
	public double deposit(@PathVariable int userID, @RequestParam double amount) {
		return accountDAO.deposit(userID, amount);
	}
	
}
