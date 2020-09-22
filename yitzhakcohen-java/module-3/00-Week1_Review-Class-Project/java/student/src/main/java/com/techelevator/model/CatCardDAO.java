package com.techelevator.model;

import java.util.List;

public interface CatCardDAO {

	List<CatCard> list();              // return all CatCard

	CatCard get(long id);              // return a single CatCard

	boolean save(CatCard cardToSave);  // add.insert a CatCard

	boolean update(long id, CatCard card);  // Update a CatCard

	boolean delete(long id);                // Remove a CatCard

}
