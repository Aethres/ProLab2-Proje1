package characters;

import javax.swing.JPanel;

import game.Location;
import items.ItemManager;

public class Player2 extends Player {

	public Player2(int playerID, String playerName, String playerType, int score, Location location, JPanel panel) {
		super(playerID, playerName, playerType, score, location, panel);
		this.characterImage = data.getPlayer2();
	}

}
