package items;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;

import characters.Player;
import game.GetData;
import game.Location;

public class ItemManager {

	ArrayList<Gold> golds;
	Mushroom mushroom;
	
	Player player;
	GetData data;
	
	int[][] map;
	
	long goldsDisappearTime;
	long goldsAppearTime;  //Time for how long it will be available
	long goldsTime;
	
	long mushroomDisappearTime;
	long mushroomAppearTime;
	long mushroomTime;
	
	boolean createGolds;
	boolean createMushroom;
	
	public ItemManager(Player player) {
		this.player = player;
		golds = new ArrayList<Gold>();
		goldsTime = System.currentTimeMillis();
		mushroomTime = System.currentTimeMillis();
		
		goldsDisappearTime = ThreadLocalRandom.current().nextLong(5000, 8000);
		mushroomDisappearTime = ThreadLocalRandom.current().nextLong(10000, 16000);
				
		goldsAppearTime = 5000;
		mushroomAppearTime = 7000;
		
		data = new GetData();
		map = data.getMap();
		
		createGolds = true;
		createMushroom = true;
	}
	
	public void drawItems(Graphics g) {
		golds.forEach((gold) -> gold.drawItem(g));
		if(mushroom != null)
			mushroom.drawItem(g);
	}
	
	public void run() {
		createItems();
		eraseItems();
		checkCollasion();
	}
	
	public void checkCollasion() {
		for (Iterator<Gold> iterator = golds.iterator(); iterator.hasNext();) {
			Gold gold = (Gold) iterator.next();
			if(gold.checkCollasion())
				iterator.remove();
			
		}
		if(mushroom != null)
			if(mushroom.checkCollasion())
				mushroom = null;
	}
	
	public void createItems() {
		if(((System.currentTimeMillis() - goldsTime) >= goldsDisappearTime) && createGolds) {
			for (int i = 0; i < 5; i++) {
				golds.add(new Gold(player, getRandomLocation()));
			}
			createGolds = false;
			goldsTime = System.currentTimeMillis();
		}
		
		if(((System.currentTimeMillis() - mushroomTime) >= mushroomDisappearTime) && createMushroom) {
			mushroom = new Mushroom(player, getRandomLocation());
			createMushroom = false;
			mushroomTime = System.currentTimeMillis();
		}
	}
	
	public void eraseItems() {
		if(((System.currentTimeMillis() - goldsTime) >= goldsAppearTime) && !createGolds) {
			golds.clear();
			createGolds = true;
			goldsDisappearTime = ThreadLocalRandom.current().nextLong(5000, 8000);
			goldsTime = System.currentTimeMillis();
		}
		
		if(((System.currentTimeMillis() - mushroomTime) >= mushroomAppearTime) && !createMushroom) {
			mushroom = null;
			createMushroom = true;
			mushroomDisappearTime = ThreadLocalRandom.current().nextLong(10000, 16000);
			mushroomTime = System.currentTimeMillis();
		}
		
	}
	
	public Location getRandomLocation() {
		boolean valid = false;
		Location location = null;
		while(!valid) {
			valid = true;
			location = new Location(ThreadLocalRandom.current().nextInt(0, 13), ThreadLocalRandom.current().nextInt(0, 11));
			for (int i = 0; i < golds.size(); i++) {
				if(golds.get(i).getLocation().isEqual(location))
					valid = false;
			}
			if (mushroom != null) {
				if(mushroom.getLocation().isEqual(location))
					valid = false;
			}
			
			if (map[location.getY()][location.getX()] == 0)
				valid = false;
		}
		return location;
	}
}
