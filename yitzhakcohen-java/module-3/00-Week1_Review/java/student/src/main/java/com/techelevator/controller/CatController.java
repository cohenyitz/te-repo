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
import java.util.List;

@RestController // This tells the sever there are controllers in the file
@RequestMapping("/api/cards")	// Base path for all methods in this file
public class CatController {

    private CatCardDAO catCardDao;
    private CatFactService catFactService;
    private CatPicService catPicService;

    public CatController(CatCardDAO catCardDao, CatFactService catFactService, CatPicService catPicService) {
        this.catCardDao = catCardDao;
        this.catFactService = catFactService;
        this.catPicService = catPicService;
    }
    
    @RequestMapping(path="", method = RequestMethod.GET)
    public List<CatCard> list() {
    	return catCardDao.list();	// Go to the DAO get all the CatCard return to API caller
    }
    
    @RequestMapping(path="/{id}", method = RequestMethod.GET)
    public CatCard get(@PathVariable long id) throws CatCardNotFoundException{
    	return catCardDao.get(id);	// Go to the DAO get the CsatCard for the id and return to API caller
    }
    
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path="/random", method = RequestMethod.GET)
    public CatCard getRandom() {
    	CatCard aCatCard = new CatCard();
    	CatFact aFact = catFactService.getFact();		// ToDo figure out how to get a random fact
    	CatPic anImgUrl = catPicService.getPic();	// call a service  to get a random image
    	
    	aCatCard.setCatFact(aFact.getText());
    	aCatCard.setImgUrl(anImgUrl.getFile());	// get the file name from the CatPic object
    	
    	return aCatCard;
    	
    }
    
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path="", method = RequestMethod.POST)
    public boolean save(@Valid @RequestBody CatCard card) {
    	return catCardDao.save(card);
    }
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path="", method = RequestMethod.PUT)
    public boolean update(@Valid @RequestBody long cardId, @RequestBody CatCard changedCard) {
    	return catCardDao.update(cardId, changedCard);
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT) 
    @RequestMapping(path="", method = RequestMethod.DELETE)
    public boolean delete(long id) {  
    	return catCardDao.delete(id);
    }

}
