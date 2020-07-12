package com.techelevator.model;

import java.util.List;

public interface CatCardDAO {

	List<CatCard> list();					// return all CatCards	

	CatCard get(long id);					// return a single CatCard

	boolean save(CatCard cardToSave);	    // add.insert a CatCard

	boolean update(long id, CatCard card);  // update a CatCard

	boolean delete(long id);				// remove a CatCard

}
