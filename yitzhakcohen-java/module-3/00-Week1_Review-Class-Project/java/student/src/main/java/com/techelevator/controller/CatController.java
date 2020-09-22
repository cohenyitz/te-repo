package com.techelevator.controller;

import com.techelevator.model.CatCard;

import com.techelevator.model.CatCardDAO;
import com.techelevator.model.CatCardNotFoundException;
import com.techelevator.model.CatFact;
import com.techelevator.model.CatPic;
import com.techelevator.services.CatFactService;
import com.techelevator.services.CatPicService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.io.FileNotFoundException;
import java.util.List;

@RestController  // This tells the server there are Controllers in this file
@RequestMapping("/api/cards")  // Base path for all methods in this file

public class CatController {

    private CatCardDAO catCardDao;
    private CatFactService catFactService;
    private CatPicService catPicService;

    public CatController(CatCardDAO catCardDao, CatFactService catFactService, CatPicService catPicService) {
        this.catCardDao = catCardDao;
        this.catFactService = catFactService;
        this.catPicService = catPicService;
    }
//    GET /api/cards: Provides a list of all Cat Cards in the user's collection.
    @RequestMapping(path="", method=RequestMethod.GET)  // path="" is optional, but it's good documentation
    public List<CatCard> list() {
    	return catCardDao.list();  // Go to the DAO get all the CatCatf return to API caller
    }
    
//    GET /api/cards/{id}: Provides a Cat Card with the given ID.
    @RequestMapping(path="/{id}", method=RequestMethod.GET)
    public CatCard get(@PathVariable long id) throws CatCardNotFoundException {
    	return catCardDao.get(id);  // Go to the DAO get the CatCard for the id and return to API caller
    }
    
//    GET /api/cards/random: Provides a new, randomly created Cat Card containing information from
//    the cat fact and picture services.
    
    @RequestMapping(path="/random", method=RequestMethod.GET) 
    public CatCard getRandom() {
    	CatCard aCatCard = new CatCard();  // CatCard Object to returned
    	String aFact = "";    // ToDo - figure out how to get a random fact
    	CatPic anImgUrl = catPicService.getPic(); // Call a service to get a random picture how to get a random image
    	
    	aCatCard.setCatFact(aFact);
    	aCatCard.setImgUrl(anImgUrl.getFile());  // Get the file name from the CatPic object
    	return aCatCard;
    }
    
//    POST /api/cards: Saves a card to the user's collection.
    
//    PUT /api/cards: Updates a card in the user's collection.
    
//    DELETE /api/cards: Removes a card from the user's collection.

}
