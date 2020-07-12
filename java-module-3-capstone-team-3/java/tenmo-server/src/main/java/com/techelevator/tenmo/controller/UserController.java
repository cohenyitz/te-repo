package com.techelevator.tenmo.controller;

import java.util.List;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.tenmo.dao.AccountSqlDAO;
import com.techelevator.tenmo.dao.UserSqlDAO;
import com.techelevator.tenmo.model.User;

@PreAuthorize("isAuthenticated()") 
@RestController
public class UserController {

	private UserSqlDAO userDAO;
	
	
	public UserController(UserSqlDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@PreAuthorize("permitAll()") // Allow access to this method without authorization
    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public List<User> listAll() {
        return userDAO.findAll();
    }
	
	
	@RequestMapping(path = "/users/{accountNumber}", method = RequestMethod.GET)
    public User getUserWithAccount(@PathVariable int accountNumber) {
        return userDAO.getUserWithAccount(accountNumber);
    }
}
