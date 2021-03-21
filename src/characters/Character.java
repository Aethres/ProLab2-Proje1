package characters;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game.GetData;
import game.Location;
import game.Map;

public abstract class Character {

	int id;
	String name, characterType;
	Location location;
	BufferedImage characterImage;
	GetData data;
	int[][] map;
	
	public Character() {
		this.data = new GetData();
		map = data.getMap().clone();
	}

	public Character(int id, String name, String characterType, Location location) {
		this.id = id;
		this.name = name;
		this.characterType = characterType;
		this.location = location;
		this.data = new GetData();
		map = data.getMap().clone();
	}
	
	public void drawCharacter(Graphics g) {
		g.drawImage(characterImage, location.getX() * Map.TILE_SIZE, (1 + location.getY())* Map.TILE_SIZE - characterImage.getHeight(), characterImage.getWidth(), characterImage.getHeight(), null);
		
	}

	public Location getLocation() {
		return location;
	}
	
	
	
}
