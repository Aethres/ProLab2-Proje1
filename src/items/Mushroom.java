package items;

import characters.Player;
import game.Location;

public class Mushroom extends Item{

	public Mushroom() {
		// TODO Auto-generated constructor stub
	}

	public Mushroom(Player player, Location location) {
		super(player, location);
		itemImage = data.getMushroomImage();
	}
	
	
	
}
