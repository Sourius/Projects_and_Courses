package game;

import controller.GameController;

public class CardGame {
	private GameController gc;
	
	public CardGame(GameController gc) {
		this.gc = gc;
	}
	
	public void run() {
		gc.run();
	}
}
