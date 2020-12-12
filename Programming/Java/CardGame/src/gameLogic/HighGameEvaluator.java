package gameLogic;

import java.util.List;

import model.Card;
import model.IPlayer;
import model.Player;

public class HighGameEvaluator implements GameEvaluator{
	@Override
	public IPlayer evaluateWinner(List<IPlayer> players) {
		IPlayer bestPlayer = null;
		int bestRank = -1;
		int bestSuit = -1;
		
		for(IPlayer player: players) {
			boolean newBestPlayer = false;
			
			if(bestPlayer == null) newBestPlayer = true;
			else {
				Card playerCard = player.getCard(0);
				int cardRank = playerCard.getRank().value();
				
				if(cardRank >= bestRank) newBestPlayer = true;
				else if(playerCard.getSuit().value() > bestSuit) newBestPlayer = true;
			}
			
			if(newBestPlayer) {
				bestPlayer = player;
				Card playerCard = player.getCard(0);
				bestRank = playerCard.getRank().value();
				bestSuit = playerCard.getSuit().value();
			}
		}
		return bestPlayer;
	}
}
