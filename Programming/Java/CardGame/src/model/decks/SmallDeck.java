package model.decks;

import java.util.ArrayList;

import model.Card;
import model.Deck;
import model.Rank;
import model.Suit;

public class SmallDeck extends Deck{
	public SmallDeck() {
		this.cards = new ArrayList<>();
		for(Rank rank: Rank.values()) {
			for(Suit suit: Suit.values()) {
				if(rank.value() >= 7) {
					System.out.println("Creating card["+rank+", "+suit+"]");
					this.cards.add(new Card(rank,suit));
				}
			}
		}
		shuffle();
	}
}
