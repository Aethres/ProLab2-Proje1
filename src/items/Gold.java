package items;

import characters.Player;
import game.Location;

public class Gold extends Item{
	
	public Gold(Player player, Location location) {
		super(player, location);
		itemImage = data.getGoldImage();
		score = 5;
	}
}
