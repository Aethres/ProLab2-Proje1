package gamestates;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;

import game.GetData;
import game.Map;

public class PlayState extends State{

	Map map;
	GetData data;
	
	public PlayState(JFrame frame) {
		super(frame);
		System.out.println("a2");
		setSize(800, 660);
		
		data = new GetData();
		map = new Map(data.getMap(), this);
		
		frame.pack();
		frame.setSize(800, 700);
		thread.start();
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		map.drawMap(g);
		
		
		
		
	}
	
	Thread thread = new Thread(new Runnable() {
	    @Override
	    public void run() {
	    	while(true) {
	    		//paintComponent(getGraphics());
	    		
	    	}
	    }
	});  
	
}
