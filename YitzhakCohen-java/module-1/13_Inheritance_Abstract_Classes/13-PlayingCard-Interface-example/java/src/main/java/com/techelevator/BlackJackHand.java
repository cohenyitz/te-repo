package com.techelevator;

import java.util.ArrayList;

// implements means you will provide all the methods required by the interface

public class BlackJackHand	 implements CardHand {

	private int numCardsInHand = 2;
	
	private ArrayList<PlayingCard> aHand;
	
	public BlackJackHand() {
		aHand = new ArrayList<PlayingCard>(numCardsInHand);
	}
	
	// @Overide asks the compiler to be sure what follows is a valid override for the method
	
	@Override
	public ArrayList<PlayingCard> getHand() {
		return aHand;
	}

	@Override
	public void addCard(PlayingCard aCard) {
		aHand.add(aCard);
		numCardsInHand++;
	}

	@Override
	final public void emptyHand() {		// final on a method meant it cannot be overriden by a sub-class
		aHand.clear();

	}

	@Override
	public void show() {
		for (PlayingCard aCard : aHand)
		{
			System.out.println(aCard);
		}
			return;
	}
	
	public void dealHand(CardDeck aDeck) {
		for (int i=0; i < numCardsInHand; i++ ) {
			aHand.add(aDeck.dealCard());
		}	
	}
	
}
	
