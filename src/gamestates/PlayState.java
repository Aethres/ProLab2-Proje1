package gamestates;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

import characters.Enemy;
import characters.Enemy1;
import characters.Enemy2;
import characters.Player;
import characters.Player1;
import characters.Player2;
import game.GetData;
import game.Location;
import game.Map;
import items.ItemManager;

public class PlayState extends State{

	Map map;
	GetData data;
	Player player;
	String playerType;
	ArrayList<Enemy> enemies;
	ItemManager itemManager;
	boolean isPlayerMoved;
	
	
	public PlayState(JFrame frame, String playerType) {
		super(frame);
		isPlayerMoved = false;
		setSize(800, 660);
		
		
		data = new GetData();
		map = new Map(data.getMap(), this);
		
		frame.pack();
		setSize(800, 660);
		frame.setSize(800, 700);
		
		if(playerType == "player1")
			this.player = new Player1(1, "ali", "player1", 20, new Location(6,5), this);
		else if(playerType == "player2")
			this.player = new Player2(1, "ali", "player2", 20, new Location(6,5), this);
		

		itemManager = new ItemManager(player);
		
		enemies = new ArrayList<Enemy>(0);
		generateEnemies();
		thread.start();
		
		
		
		
	}
	
	public void generateEnemies() {
		
		if (data.getEnemy1().equals("Gargamel")) {
			System.out.println("sd");
			enemies.add(new Enemy2(1, "Gargamel", "Gargamel", data.getEnemy1Location()));
		}
		else if(data.getEnemy1().equals("Azman")) {
			enemies.add(new Enemy1(1, "Azman", "Azman", data.getEnemy1Location()));
		}
		if (data.getEnemy2().equals("Gargamel")) {
			enemies.add(new Enemy2(2, "Gargamel", "Gargamel", data.getEnemy2Location()));
		}
		else if(data.getEnemy2().equals("Azman")) {
			enemies.add(new Enemy1(2, "Azman", "Azman", data.getEnemy2Location()));
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		map.drawMap(g);
		enemies.forEach((enemy) -> enemy.drawPath(g, player.getLocation()));
		map.drawGrid(g);
		enemies.forEach((enemy) -> enemy.drawCharacter(g));
		player.drawCharacter(g);
		itemManager.drawItems(g);
		//player.getScore().drawScore();
		
		
		
		
	}
	
	Thread thread = new Thread(new Runnable() {
	    @Override
	    public void run() {
	    	while(true) {
	    		try {
					thread.sleep(15);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		isPlayerMoved = player.run();
	    		
	    		if(isPlayerMoved) {
	    			enemies.forEach((enemy) -> enemy.run(player.getLocation(), player));
	    		}
	    		
	    		itemManager.run();
	    		
	    		try {
					thread.sleep(15);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    			
	    		repaint();
	    		
	    	}
	    }
	});  
	
}
