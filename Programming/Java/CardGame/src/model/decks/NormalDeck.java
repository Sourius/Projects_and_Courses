package model.decks;

import java.util.ArrayList;

import model.Card;
import model.Deck;
import model.Rank;
import model.Suit;

public class NormalDeck extends Deck {
	public NormalDeck() {
		this.cards = new ArrayList<>();
		for(Rank rank: Rank.values()) {
			for(Suit suit: Suit.values()) {
				System.out.println("Creating card["+rank+", "+suit+"]");
				this.cards.add(new Card(rank,suit));
			}
		}
		shuffle();
	}
}
