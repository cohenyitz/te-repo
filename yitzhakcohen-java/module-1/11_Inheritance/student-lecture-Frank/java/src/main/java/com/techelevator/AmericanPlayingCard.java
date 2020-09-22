package com.techelevator;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
/****************************************************************************************************
 * American Playing Card Class - subclass of generic PlayingCard
 * 
 * Only things different from the super class are defined in the subclass
 * 
 * The sub-class automatically gains access to everything in the super class
 * 
 ***************************************************************************************************/

public class AmericanPlayingCard extends PlayingCard{ // when sub-class is instantiated the super is also 
	/************************************************************************************************
	 * Constants for values related to American Playing Cards
	 ***********************************************************************************************/	
	private static final int    DEFAULTCARDVALUE = 0;
	private static final String DEFAULTCOLOR     = "BLACK";
	private static final String DEFAULTSUIT      = "Joker";
	private static final int    MAXVALUE         = 13;
	private static final int    MINVALUE         = 0;

	/**************************************************************************************************
	 * Maps used to validate/limit suits, colors and value names for American Playing Cards
	 * 
	 * Since all instances of AmericaPlayingCard objects use the exact same suits and values
	 * the Maps are static so only one needs to be created for the class
	 * 
	 *************************************************************************************************/	
	
	private static Map<String,  String> suitMap  = new HashMap<String , String>();  
	private static Map<Integer, String> valueMap = new TreeMap<Integer, String>(); 
	
	/***************************************************************************************************
	 *Invoke method to populate maps with valid suits, colors & value names for American Playing Cards
	 *
	 * method to initialize the suitMap and valueMap it must be static cause the Maps are static
	 * (only static methods may change static objects)
	 *
	 **************************************************************************************************/	
	
	static {             // static method to initialize maps before are ever used 
       initializeMaps(); // invoke the number method to initialize the Maps
    }
	/***************************************************************************************************
	 * 0-arg / Default Constructor
	 * 
	 * The first thing a sub-class constructor must do is invoke a super-class ctor
	 * 	with the data it needs to initialize a super-class.
	 * 
	 * After the super-class ctor is run, the sub-class does whatever it needs to do 
	 * initialize the sub-class 
	 * 
	 **************************************************************************************************/		
	public AmericanPlayingCard() 	// A default AmericanPlayingCard should have defaults for all data
	{
		super(DEFAULTCARDVALUE, DEFAULTSUIT, DEFAULTCOLOR);  // Invoke 3-arg ctor in superclass
	} 
	/***************************************************************************************************
	 * 2-arg Constructor for a user provided value and suit
	 ***************************************************************************************************/	
	public AmericanPlayingCard(int value, String suit) {
		super(value, suit, suitMap.get(suit));       // Determine color and call super class 3-arg ctor
	
		if (value > MAXVALUE) {                      // If value provided is greater than max value allowed         
			setValue(MAXVALUE);                      //      set it to max value allowed
		}
		if (value < MINVALUE) {                      // If value provided is greater than min value allowed  
			setValue(MINVALUE);                      //      set it to min value allowed
		}
	}
	/****************************************************************************************************
	 * Initialize Maps to valid suit/color combinations and value names
	 ***************************************************************************************************/	
	private static void initializeMaps() {
		suitMap.put("SPADES"  , "BLACK");
		suitMap.put("CLUBS"   , "BLACK");
		suitMap.put("DIAMONDS", "RED");
		suitMap.put("HEARTS"  , "RED");
		
		valueMap.put(0,"Joker");
		valueMap.put(1,"Ace");
		valueMap.put(2,"Two");
		valueMap.put(3,"Three");
		valueMap.put(4,"Four");
		valueMap.put(5,"Five");
		valueMap.put(6,"Six");
		valueMap.put(7,"Seven");
		valueMap.put(8,"Eight");
		valueMap.put(9,"Nine");
		valueMap.put(10,"Ten");
		valueMap.put(11,"Jack");
		valueMap.put(12,"Queen");
		valueMap.put(13,"King");
	}
	/****************************************************************************************************
	 * toString() Override
	 ***************************************************************************************************/
	@Override
	public String toString() {
		return "AmericanPlayingCard: " 
	          +"Value: "  + valueMap.get(getValue())
	          +" - Color: " + suitMap.get(getSuit()) 
			  +" - Suit: "  + getSuit()
			  +" - super.toString()=" + super.toString() + "\n";  // Invoke super class toString()in case we need it
	}
	/***************************************************************************************
	 * clone() method to create a copy of an AmericanPlayingCard from an AmericanPlayingCard
	 ***************************************************************************************/
	public AmericanPlayingCard clone() {
		return new AmericanPlayingCard(this.getValue(), this.getSuit()); // Use the 2-arg ctor to create new object
	}
	/****************************************************************************************************
	 * method to display an American PlayingCard
	 ***************************************************************************************************/
	public void showCard() {
		System.out.println(this.toString());  // Use the toString() method to format the data
	}
	

}
