package game.builder;

import controller.GameController;
import game.CardGame;
import game.factory.DeckFactory;
import game.factory.EvaluatorFactory;
import game.factory.DeckFactory.DeckType;
import game.factory.EvaluatorFactory.EvaluatorType;
import view.GameSwing;

public class SmallHighCardGameBuilder implements GameBuilder {
	private CardGame cardGame;
	
	public SmallHighCardGameBuilder() {
		GameSwing gs = new GameSwing();
		gs.createAndShowGUI();
		GameController gc = new GameController(
				gs, 
				DeckFactory.makeDeck(DeckType.SMALL), 
				EvaluatorFactory.makeEvaluator(EvaluatorType.HIGH)
		);
		cardGame = new CardGame(gc);
	}
	
	public CardGame getGame() {
		return cardGame;
	}
}
