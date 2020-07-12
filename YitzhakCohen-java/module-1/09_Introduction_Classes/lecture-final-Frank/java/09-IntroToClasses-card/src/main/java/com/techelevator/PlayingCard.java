package com.techelevator;

public class PlayingCard {

	// This is our class to model a Playing Card
	
	// Define the data members for the class
	
	// access data-type name;  access is public or private
	//                         public - any one has can access
	//                         private - only members of the class have access (Encapsulation)
	
	// If you want to allow users to retrieve or change member data, you must provides methods to do so
	//     "Getters" are methods users can use to retrieve values in member data
	//     "Setters" are methods users can use to change values in member data
	
	private int     cardValue;   // Ace=1, Jack=11, Queen=12, King=13
	private String  cardColor;
	private String  cardSuit;
	private boolean faceUp;
	
	
	// Define class methods for the class
	
	// When a class is instantiated, a special method called a constructor is run to initialize the object
	// If no constructors are defined for a class, Java runs a default constructor 
	//     that initializes   numerics to 0, Strings (and other objects) to null and booleans to false
	//
	// If you want other than the Java default values for data in our object you need define constructors
	
	// a constructor has the (1) same name as the class and (2) no return type (not even void) and (3) public
	
	public PlayingCard() {  // constructor to initialize object to default values - a default constructor
		cardValue = 8;
		cardSuit  = "heart";
		cardColor = "red";
		faceUp    = true;	
	}
	
	// a constructor to allow the user to specify the value, color, suit, face-up status when they instantiate it
	//      4-argument constructor - set the data mebers to the values passed in by the user
	
	public PlayingCard(int theValue, String theSuit, String theColor, boolean ifFaceUp) {
		cardValue = theValue;
		cardSuit  = theSuit;
		cardColor = theColor;
		faceUp    = ifFaceUp;
	}
	

// Getters and Setters for the member data
	
	
	public int getCardValue() {
		return cardValue;
	}
//  access return method(oarameters) - void - nothing is returned
	public void setCardValue(int cardValue) {
		this.cardValue = cardValue;
	}

	public String getCardColor() {
		return cardColor;
	}

	public void setCardColor(String cardColor) {
		this.cardColor = cardColor;
	}

	public String getCardSuit() {
		return cardSuit;
	}

	public void setCardSuit(String cardSuit) {
		this.cardSuit = cardSuit;
	}

	public boolean isFaceUp() {
		return faceUp;
	}

	public void setFaceUp(boolean faceUp) {
		this.faceUp = faceUp;
	}
	
	// Provide users the ability to determine if a card is a face card (value=11,12,13)
	public boolean isFaceCard() {
		if (cardValue >= 11) {
			return true;
		}
		return false;
	}
	
	
	
	
	// a toString() method if available will be used to convert an object of the class to a String
	//     The class knows what a String of it's object should look like
		
	//  access return name(parameters)	
	public String toString() {
		String aString = "Value=" + cardValue + " - Color=" + cardColor + " - " + "Suit=" + cardSuit + " - " 
	                              + "Face-up: " + faceUp;
		return aString;
	}
	
}
