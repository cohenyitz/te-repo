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
		
		System.out.println("--------Start of Polymorphism stuff-------");
		
		aUSACard3.showCard();        // Ran the AmericanPlayingCard showCard() method
		aSwissCard4.showCard();      // Ran the SwissPlayingCard showCard() method
		anItalianCard1.showCard();   // Ran the ItalianClayingCard showCard() method
		
		System.out.println("--------Super class assigned sub class object -------");
		
	
		PlayingCard aCard = aUSACard3;   // A sub-class object may be assigned to a super class object
		aCard.showCard();                // The class of the object in the variable determines which method is run
		                                 //     NOT the class of object used to run the method
		
		aCard = aSwissCard4;             // A sub-class object may be assigned to a super class object
		aCard.showCard();                // The class of the object in the variable determines which method is run
                                         //     NOT the class of object used to run the method
		
		
		aCard = anItalianCard1;          // A sub-class object may be assigned to a super class object
		aCard.showCard();                // The class of the object in the variable determines which method is run
                                         //     NOT the class of object used to run the method
		
		System.out.println("--------Polymorphism Demo Using an Array -------");
		
		PlayingCard[] someCards = new PlayingCard[5];
		
		someCards[0] = aSwissCard4;
		someCards[1] = aUSACard3;
		someCards[2] = anItalianCard1;
		someCards[3] = aUSACard;
		someCards[4] = anItalianCard2;
		
		for(int i=0; i< someCards.length; i++) {
			someCards[i].showCard();  // The method for class IN the element is run NOT the class of the element
		}                             // The element is a PlayingCard class, the object inthe element is a subclass
	}                                 //        so the sub class method runs

}
