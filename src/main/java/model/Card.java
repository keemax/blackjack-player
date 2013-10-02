package model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Card {

	private int rank;
	private int value;

	public enum Suit { 
		CLUBS, DIAMONDS, HEARTS, SPADES 
	}

    private Suit suit;

	public Suit getSuit() {
		return suit;
	}

	public int getRank() {
		return rank;
	}
	
	public int getValue() {
		return value;
	}

}
