package characters;

import javax.swing.JPanel;

import characters.Player.moveStates;
import game.Location;

public class Player1 extends Player{

	public Player1(int playerID, String playerName, String playerType, int score, Location location, JPanel panel) {
		super(playerID, playerName, playerType, score, location, panel);
		this.characterImage = data.getPlayer1();
	}
	
	@Override
	public boolean run() {
		boolean isMoved = false;
		move();
		move();
		if(moveState != moveStates.IDLE)
			isMoved = true;
		
		moveState = moveStates.IDLE;
		
		return isMoved;
	}

}
