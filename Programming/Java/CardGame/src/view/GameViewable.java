package view;

import controller.GameController;

public interface GameViewable {
	public void setController(GameController gc);
	public void promptForPlayerName();
	public void promptForFlip();
	public void promptForNewGame();
	public void showPlayerName(int playerIndex, String playerName);
	public void showCardForPlayer(int playerIndex, String playerName, String rank, String suit);
	public void showFaceDownCardForPlayer(int playerIndex, String playerName);
	public void showWinner(String winnerName);
}