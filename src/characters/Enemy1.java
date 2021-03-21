package characters;

import game.Location;

public class Enemy1 extends Enemy{
	
	public Enemy1(int enemyID, String enemyName, String enemyType, Location location) {
		super(enemyID, enemyName, enemyType, location);
		this.characterImage = data.getEnemy1();
	}
	
}
