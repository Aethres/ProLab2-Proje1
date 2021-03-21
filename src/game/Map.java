package game;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Map {
	
	public static int TILE_SIZE = 60;
	
	int[][] map;
	JPanel jpanel;
	
	public Map(int[][] map, JPanel jpanel) {
		this.map = map;
		this.jpanel = jpanel;
	}
	
	
	public void drawMap(Graphics g) {
	
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if(map[i][j] == 0)
					g.setColor(new Color(30, 30, 40));
				else if(map[i][j] == 1)
					g.setColor(new Color(200, 200, 200));
				g.fillRect(TILE_SIZE * j, TILE_SIZE * i, TILE_SIZE, TILE_SIZE);
				
			}
	}
		
	}
	public void drawGrid(Graphics g) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				g.setColor(new Color(0,0,0));
				g.drawRect(TILE_SIZE * j, TILE_SIZE * i, TILE_SIZE, TILE_SIZE);
			}
		}
	}
}
