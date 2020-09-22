package com.techelevator;

public class UsePlayingCards {

	public static void main(String[] args) {
		
		AmericanPlayingCard aUSACard  = new AmericanPlayingCard(1, "HEARTS");
		System.out.println("aUSACard is :");
		aUSACard.showCard();

		AmericanPlayingCard aUSACard2 = new AmericanPlayingCard(14, "SPADES");
		System.out.println("aUSACard2 is :" );
		aUSACard2.showCard();
		
		AmericanPlayingCard aUSACard3 = new AmericanPlayingCard(-1, "SPADES");
		System.out.println("aUSACard3 is :");
		aUSACard3.showCard();
			
		AmericanPlayingCard aUSACard4 = new AmericanPlayingCard(11, "JASON");
		System.out.println("aUSACard4 is :");
		aUSACard4.showCard();
		
		ItalianPlayingCard anItalianCard1 = new ItalianPlayingCard(13, "SWORDS");
		System.out.println("anItalianCard1 is :");
		anItalianCard1.showCard();
		
		ItalianPlayingCard anItalianCard2 = new ItalianPlayingCard(9, "COINS");
		System.out.println("anItalianCard2 is :");
		anItalianCard2.showCard();
		
		ItalianPlayingCard anItalianCard3 = new ItalianPlayingCard(11, "JASON");
		System.out.println("anItalianCard3 is :");
		anItalianCard3.showCard();
		
		SwissPlayingCard aSwissCard1 = new SwissPlayingCard(13, "ROSES");
		System.out.println("aSwissCard1 is :");
		aSwissCard1.showCard();
		
		SwissPlayingCard aSwissCard2 = new SwissPlayingCard(9, "SHIELDS");
		System.out.println("aSwissCard2 is :");
		aSwissCard2.showCard();
			
		SwissPlayingCard aSwissCard3 = new SwissPlayingCard(10, "ACORNS");
		System.out.println("anSwissCard3 is :");
		aSwissCard3.showCard();
			
		SwissPlayingCard aSwissCard4 = new SwissPlayingCard(11, "JASON");
		System.out.println("anSwissCard4 is :");
		aSwissCard4.showCard();	
		
		
		/*
		 * polymorphism stuff starts here
		 * 
		 */
		System.out.println("------- polymorphism stuff starts here --------\n");
		
		aUSACard3.showCard();			// Run the AmericanPlayingCard showCard();
		anItalianCard1.showCard();		// Run the ItalianPlayingCard showCard();
		aSwissCard4.showCard();			// Run the SwissPlayingCard showCard();
		
		System.out.println("------- Use Polymorphism by having a super-class object refernce a subclass--------\n");
		
		PlayingCard aCard;				// Define a super-class reference that right now points to 
		
		aCard = aUSACard3;				// Have the super-class reference point to a sub-class object
		aCard.showCard();				// Use the super-class object to run a method
										// 		the sub-class showCard() method runs
		
		aCard = aSwissCard4;			// Have the super-class reference point to a sub-class object
		aCard.showCard();				// Use the super-class object to run a method
										// 		the sub-class showCard() method runs
		
		aCard = anItalianCard1;			// Have the super-class reference point to a sub-class object
		aCard.showCard();				// Use the super-class object to run a method
										// 		the sub-class showCard() method runs
		
		
		System.out.println("------- Use Polymorphism using an array --------\n");
		
		PlayingCard[] someCards = new PlayingCard[5];
		
		someCards[0] = aSwissCard4;		// Put a sub-class in the super-class array 
		someCards[1] = aUSACard3;		// Put a sub-class in the super-class array 
		someCards[2] = anItalianCard1;	// Put a sub-class in the super-class array 
		someCards[3] = aUSACard;		// Put a sub-class in the super-class array 
		someCards[4] = anItalianCard2;	// Put a sub-class in the super-class array 
		
		for (int i = 0; i < someCards.length; i++) {
			someCards[i].showCard();	// The method for the class IN the element is run
										// 		NOT the method OF the element class
		}
		
		
	}

}
