package com.techelevator;

public class IntroToClassesCard {
	
	public static void main(String[] args) {
        
        /*
         *  This program will demonstrate several concepts presented in the Java cohort
		 *  in the topic Introduction to Classes 
		 *  
		 *  This is the application program - uses objects instantiated from classes
		 *  								  and their methods to get its work done
		 *  		
        */
	
		// Instantiate a PlayingCard object - data-type name = new data-type()
;		
		PlayingCard aCard = new PlayingCard();	// run the PlayingCard() constructor 
		
		PlayingCard anotherCard = new PlayingCard(1, "Clubs", "Green", false);	// run the 4 argument constructor
		
		System.out.println("anotherCard contains: " + anotherCard);
		
		System.out.println("aCard contains: " + aCard);	// Display the contents of PlayingCard object
		//									  + PlayingCard Object - println() doesn't know what to with it
		//							println() - Can I convert a PlayingCard to something I know about?
		//									  Yes - it can be converted to a string because it has it's own toString()
		//									  Convert the PlayingCard Object to a String object using toString()
		//									  Now println() displays the String object of PlayingCard toString()
		//									
		
		System.out.println("Card value is: " + aCard.getCardValue() + "Suit is: " + aCard.getCardSuit());
		
		aCard.setCardValue(13);	// Change the card value using method provided by the class
		
		System.out.println("Card value is: " + aCard.getCardValue() + "Suit is: " + aCard.getCardSuit());
		
		System.out.println("aCard is a face card: " + aCard.isFaceCard());
		
	}
}
		 

