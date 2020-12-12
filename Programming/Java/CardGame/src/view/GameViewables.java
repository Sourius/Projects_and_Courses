package view;

import java.util.Vector;

import controller.GameController;

public class GameViewables implements GameViewable {

	private Vector<GameViewable> views;
	
	public GameViewables() {
		views = new Vector<>();
	}
	
	public void addViewable(GameViewable view) {
		views.add(view);
	}
	
	@Override
	public void setController(GameController gc) {
		for(GameViewable view : views) {
			view.setController(gc);
		}
	}

	@Override
	public void promptForPlayerName() {
		for(GameViewable view : views) {
			view.promptForPlayerName();
		}
	}

	@Override
	public void promptForFlip() {
		for(GameViewable view : views) {
			view.promptForFlip();
		}
	}

	@Override
	public void promptForNewGame() {
		for(GameViewable view : views) {
			view.promptForNewGame();
		}
	}

	@Override
	public void showPlayerName(int playerIndex, String playerName) {
		for(GameViewable view : views) {
			view.showPlayerName(playerIndex, playerName);
		}
	}

	@Override
	public void showCardForPlayer(int playerIndex, String playerName, String rank, String suit) {
		for(GameViewable view : views) {
			view.showCardForPlayer(playerIndex, playerName, rank, suit);
		}
	}

	@Override
	public void showFaceDownCardForPlayer(int playerIndex, String playerName) {
		for(GameViewable view : views) {
			view.showFaceDownCardForPlayer(playerIndex, playerName);
		}
	}

	@Override
	public void showWinner(String winnerName) {
		for(GameViewable view : views) {
			view.showWinner(winnerName);
		}
	}

}
