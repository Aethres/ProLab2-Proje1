package items;

import java.awt.Graphics;
import java.awt.image.BufferedImage;


import characters.Player;
import game.GetData;
import game.Location;
import game.Map;

public abstract class Item {

	int score;
	double DisappearTime;
	double AppearTime;
	double startTime;
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
		g.drawImage(itemImage, location.getX() * Map.TILE_SIZE, (1 + location.getY())* Map.TILE_SIZE - itemImage.getHeight(), itemImage.getWidth(), itemImage.getHeight(), null);
		
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
	public boolean checkCollasion() {
		if(player.getLocation().isEqual(location)) {
			addScore();
			return true;
		}
		return false;
	}
	
	public void addScore() {
		player.getScore().addScore(score);
	}
}
