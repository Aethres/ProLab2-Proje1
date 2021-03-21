package characters;

import game.Location;

public class Enemy2 extends Enemy{

	public Enemy2(int enemyID, String enemyName, String enemyType, Location location) {
		super(enemyID, enemyName, enemyType, location);
		this.characterImage = data.getEnemy1();
	}
	
}
