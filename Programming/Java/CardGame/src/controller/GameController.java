package controller;

import java.util.ArrayList;

import gameLogic.GameEvaluator;
import model.Card;
import model.Deck;
import model.IPlayer;
import model.Player;
import model.WinningPlayer;
import view.GameViewable;
import view.GameViewables;

public class GameController {
	enum GameState{
		AddingPlayers,
		CardsDealt,
		WinnerRevealed,
		AddingView
	}
	
	private Deck deck;
	private ArrayList<IPlayer> players;
	private IPlayer winner;
	private GameViewables views;
	private GameState gameState;
	private GameEvaluator evaluator;
	
	public GameController(GameViewable view, Deck deck, GameEvaluator evaluator) {
		views = new GameViewables();
		this.deck = deck;
		players = new ArrayList<>();
		gameState = GameState.AddingPlayers;
		this.evaluator = evaluator;
		views.addViewable(view);
		view.setController(this);
	}
	
	public void addViewable(GameViewable newView) {
		GameState currentState = gameState;
		gameState = GameState.AddingView;
		newView.setController(this);
		views.addViewable(newView);
		try {
			Thread.sleep(1000);
		} catch(Exception e) {
			e.printStackTrace();
		}
		gameState = currentState;
	}
	
	public void run() {
		while(true) {
			switch (gameState) {
				case AddingPlayers:
					views.promptForPlayerName();
					break;
				
				case CardsDealt:
					views.promptForFlip();
					break;
				
				case WinnerRevealed:
					views.promptForNewGame();
					break;
				case AddingView:
					break;
			}
		}
	}	
	
	public void addPlayer(String playerName) {
		if(gameState == GameState.AddingPlayers) {
			players.add(new Player(playerName));
			views.showPlayerName(players.size(),playerName);
		}
	}

	public void startGame() {
		if(gameState != GameState.CardsDealt) {
			deck.shuffle();
			int playerIndex = 1;
			for(IPlayer player : players) {
				player.addCardToHand(deck.removeTopCard());
				playerIndex++;
				views.showFaceDownCardForPlayer(playerIndex, player.getName());	
			}
			gameState = GameState.CardsDealt;
		}
	}
	
	public void flipCards() {
		int playerIndex = 1;
		
		for(IPlayer player: players) {
			Card playerCard = player.getCard(0);
			playerCard.flip();
			playerIndex++;
			views.showCardForPlayer(playerIndex, player.getName(), playerCard.getRank().toString(), 
					playerCard.getSuit().toString());
			
		}
		
		evaluateWinner();
		displayWinner();
		rebuildDeck();
		gameState = GameState.WinnerRevealed;
	}
	
	private void restartGame() {
		rebuildDeck();
		players.clear();
		gameState = GameState.AddingPlayers;
	}
	
	private void evaluateWinner() {
		winner = new WinningPlayer(evaluator.evaluateWinner(players));
	}
	
	private void displayWinner() {
		views.showWinner(winner.getName());
	}
	
	private void rebuildDeck() {
		for(IPlayer player: players) {
			deck.returnCardToDeck(player.removeCard());
		}
	}
}
