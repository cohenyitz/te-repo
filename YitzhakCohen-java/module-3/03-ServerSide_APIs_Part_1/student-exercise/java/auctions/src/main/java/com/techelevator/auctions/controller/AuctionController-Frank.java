package com.techelevator.auctions.controller;

import com.techelevator.auctions.DAO.AuctionDAO;
import com.techelevator.auctions.DAO.MemoryAuctionDAO;
import com.techelevator.auctions.model.Auction;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// @RequestMapping is outside the class - indicates the base path for all Controllers in the file
@RequestMapping("/auctions")      // base path for all controllers in this file
public class AuctionController {

    private AuctionDAO dao;

    public AuctionController() {
        this.dao = new MemoryAuctionDAO();
    }
@RequestMapping(path="/frank")   // handle "/auctions/frank" path - base path from above and path=
                                 // Since there is not= method= default is to handle GET requests
    public void FrankController() {
        // What ever the frankController will does
    }

}
