package game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Goal {

	BufferedImage image;
	Location location;
	GetData data;
	
	public Goal() {
		location = new Location(12, 7);
		data = new GetData();
		image = data.getGoal();
	}
	
	
	public void draw(Graphics g) {
		g.drawImage(image, (location.getX() + 1) * Map.TILE_SIZE, (1 + location.getY())* Map.TILE_SIZE - image.getHeight(), image.getWidth(), image.getHeight(), null);
		
	}


	public Location getLocation() {
		return location;
	}


	public void setLocation(Location location) {
		this.location = location;
	}
	
	
}
