package com.techelevator;

import java.util.ArrayList;

// Interfae defines methods must be defined by anyone who implements the interface

// If you want to be a type of CardHand you must at least have these behaivors

// A list of method signatures followed by a semi-colon

// Any class that implemetns this interface must override these methods


public interface CardHand {
	
	public ArrayList<PlayingCard> getHand();		// Return all the cards in 

	public void addCard(PlayingCard aCard);
	
	public void emptyHand();

	public void show();

}
