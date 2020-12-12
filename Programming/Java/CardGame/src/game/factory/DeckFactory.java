package game.factory;

import model.Deck;
import model.decks.NormalDeck;
import model.decks.SmallDeck;
import model.decks.TestDeck;

public class DeckFactory {
	public enum DeckType{
		NORMAL,
		SMALL,
		TEST
	}
	
	public static Deck makeDeck(DeckType type) {
		switch(type) {
			case NORMAL: return new NormalDeck();
			case SMALL: return new SmallDeck();
			case TEST: return new TestDeck();	
		}
		return new NormalDeck();
	}
}
