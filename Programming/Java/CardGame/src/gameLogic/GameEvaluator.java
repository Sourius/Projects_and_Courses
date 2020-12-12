package gameLogic;

import java.util.List;

import model.IPlayer;
import model.Player;

public interface GameEvaluator {
	public IPlayer evaluateWinner(List<IPlayer> players);
}
