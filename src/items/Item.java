package items;

import java.awt.Graphics;
import java.awt.image.BufferedImage;


import characters.Player;
import game.GetData;
import game.Location;
import game.Map;

public abstract class Item {

	int score;
	BufferedImage itemImage;
	Location location;
	GetData data;
	Player player;
	
	public Item() {
		score = 0;
	}
	
	public Item(Player player, Location location) {
		this.player = player;
		this.location = location;
		data = new GetData();
	}
	
	public void drawItem(Graphics g) {
		
		//g.drawImage(itemImage, location.getX() * Map.TILE_SIZE, location.getY()* Map.TILE_SIZE - characterImage.getHeight(), characterImage.getWidth(), characterImage.getHeight(), null);
	}
	
}
