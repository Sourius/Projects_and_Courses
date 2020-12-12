package model;

public class WinningPlayer implements IPlayer {
	private IPlayer player;
	
	public WinningPlayer(IPlayer player) {
		this.player = player;
	}
	
	@Override
	public String getName() {
		return "*****"+player.getName()+"*****";
	}

	@Override
	public void addCardToHand(Card card) {
		player.addCardToHand(card);
	}

	@Override
	public Card getCard(int index) {
		return player.getCard(index);
	}

	@Override
	public Card removeCard() {
		return player.removeCard();
	}

}
