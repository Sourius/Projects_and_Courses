package model.decks;

import java.util.ArrayList;

import model.Card;
import model.Deck;
import model.Rank;
import model.Suit;

public class TestDeck extends Deck {
	public TestDeck() {
		cards = new ArrayList<>();
		for(int i = 0; i < 20; ++i) {
			cards.add(new Card(Rank.ACE,Suit.CLUBS));
		}
		shuffle();
	}
}
