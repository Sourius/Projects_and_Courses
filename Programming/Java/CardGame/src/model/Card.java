package model;

public class Card {
	private Rank rank;
	private Suit suit;
	private boolean faceUp;
	
	public Card(Rank r, Suit s) {
		rank = r;
		suit = s;
		faceUp = false;
	}
	
	public Rank getRank() {
		return rank;
	}
	
	public Suit getSuit() {
		return suit;
	}

	public boolean isFaceUp() {
		return faceUp;
	}

	public void setFaceUp(boolean faceUp) {
		this.faceUp = faceUp;
	}

	public void flip() {
		// TODO Auto-generated method stub
		
	}
	
}
