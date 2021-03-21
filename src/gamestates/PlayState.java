package gamestates;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;

import characters.Enemy;
import characters.Enemy1;
import characters.Player;
import characters.Player1;
import characters.Player2;
import game.GetData;
import game.Location;
import game.Map;

public class PlayState extends State{

	Map map;
	GetData data;
	Player player;
	String playerType;
	Enemy enemy;
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
		
		enemy = new Enemy1(1, "aaaaaa", "aaa", new Location(3,0));
		
		
		thread.start();
		
		
		
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		map.drawMap(g);
		enemy.drawPath(g, player.getLocation());
		map.drawGrid(g);
		enemy.drawCharacter(g);
		player.drawCharacter(g);
		
		
		
		
	}
	
	Thread thread = new Thread(new Runnable() {
	    @Override
	    public void run() {
	    	while(true) {
	    		//
	    		isPlayerMoved = player.run();
	    		
	    		if(isPlayerMoved) {
	    			enemy.run(player.getLocation());
	    		}
	    		
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
