package com.techelevator.auctions.controller;

import com.techelevator.auctions.DAO.AuctionDAO;
import com.techelevator.auctions.DAO.MemoryAuctionDAO;
import com.techelevator.auctions.model.Auction;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// @ RequestMapping is outside the class - indicated the base path for all controllers in the file

@RequestMapping("/auctions") //base path for all controllers in theis file
public class AuctionController {

    private AuctionDAO dao;

    public AuctionController() {
        this.dao = new MemoryAuctionDAO();
    }
//    @RequestMapping (path="/frank")
//    public void FrankController() {	//handle "/auctions/frank" path - base path from above and path=, default method=GET
//        //What ever the frankController will do
//    }
  
    
    @RequestMapping(path="/{id}", method = RequestMethod.GET)
    public Auction get(@PathVariable int id) {
    	return dao.get(id);
        }
    
    @RequestMapping(method = RequestMethod.POST)
    public Auction create(@RequestBody Auction auction) {
    	return dao.create(auction);
    }

    @RequestMapping(method = RequestMethod.GET) 
    public List<Auction> searchByTitle(@RequestParam(value = "title_like", required = false, defaultValue ="")String title_like
    		, @RequestParam(value = "currentBid_lte", required = false, defaultValue = "0")double currentBid_lte) {
    	
    	if (!title_like.isEmpty() && currentBid_lte > 0) {
    		return dao.searchByTitleAndPrice(title_like,currentBid_lte); 
    	}
    	if (currentBid_lte > 0) {
			return dao.searchByPrice(currentBid_lte);
    	}
    	if (!title_like.isEmpty()) {
    		return dao.searchByTitle(title_like);
    	}
    	return dao.list();
}
}