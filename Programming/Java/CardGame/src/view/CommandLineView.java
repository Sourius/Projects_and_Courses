package view;

import java.util.Scanner;

import controller.GameController;

public class CommandLineView implements GameViewable{
	private GameController controller;
	Scanner input = new Scanner(System.in);
	
	@Override
	public void setController(GameController gc) {
		controller = gc;
	}

	@Override
	public void promptForPlayerName() {
		System.out.println("Enter Player Name: ");
		String name = input.nextLine();
		if(name.isEmpty()) controller.startGame();
		else controller.addPlayer(name);
	}

	@Override
	public void promptForFlip() {
		System.out.println("Press enter to reveal cards");
		input.nextLine();
		controller.flipCards();
	}
	
	@Override
	public void promptForNewGame() {
		System.out.println("Press enter to deal again");
		input.nextLine();
		controller.startGame();
	}
	
	@Override
	public void showPlayerName(int playerIndex, String playerName) {
		System.out.println("[" + playerIndex + "][" + playerName + "]");
	}
	
	@Override
	public void showCardForPlayer(int playerIndex, String playerName, String rank, String suit) {
		System.out.println("[" + playerName + "][" + rank +"][" + suit + "]");
	}
	
	@Override
	public void showFaceDownCardForPlayer(int playerIndex, String playerName) {
		System.out.println("[" + playerName + "][][]");
	}
	
	@Override
	public void showWinner(String winnerName) {
		System.out.println("[" + winnerName + "]");
	}
}
