package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public abstract class Deck {
	protected ArrayList<Card> cards;
	
	public void shuffle() {
		Random random = new Random();
		for(int i = 0; i < cards.size(); i++) {
			Collections.swap(cards, i, random.nextInt(cards.size()));
		}
	}
	
	public Card removeTopCard() {
		return cards.remove(0);
	}
	
	public void returnCardToDeck(Card card) {
		cards.add(card);
	}
}
