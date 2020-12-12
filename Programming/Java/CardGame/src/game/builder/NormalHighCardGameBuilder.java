package game.builder;

import controller.GameController;
import game.CardGame;
import game.factory.DeckFactory;
import game.factory.EvaluatorFactory;
import game.factory.DeckFactory.DeckType;
import game.factory.EvaluatorFactory.EvaluatorType;
import view.GameSwing;

public class NormalHighCardGameBuilder implements GameBuilder{
	private CardGame cardGame;
	
	public NormalHighCardGameBuilder() {
		GameSwing gs = new GameSwing();
		gs.createAndShowGUI();
		GameController gc = new GameController(
				gs, 
				DeckFactory.makeDeck(DeckType.NORMAL), 
				EvaluatorFactory.makeEvaluator(EvaluatorType.HIGH)
		);
		cardGame = new CardGame(gc);
	}
	
	public CardGame getGame() {
		return cardGame;
	}
}
