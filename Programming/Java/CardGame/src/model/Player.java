package model;

public class Player implements IPlayer{
	private String name;
	private Hand hand;
	
	public Player(String n) {
		name = n;
		hand = new Hand();
	}
	
	public String getName() {
		return name;
	}

	public void addCardToHand(Card card) {
		hand.addCard(card);
	}
	
	public Card getCard(int index) {
		return hand.getCard(index);
	}
	
	public Card removeCard() {
		return hand.removeCard();
	}
}
