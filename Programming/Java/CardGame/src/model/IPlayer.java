package model;

public interface IPlayer {
	public String getName();
	public void addCardToHand(Card card);
	public Card getCard(int index);
	public Card removeCard();
}
