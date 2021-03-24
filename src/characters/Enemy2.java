package characters;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import characters.Enemy.Node;
import characters.Enemy.Moves;
import game.Location;
import game.Map;

public class Enemy2 extends Enemy{

	public Enemy2(int enemyID, String enemyName, String enemyType, Location location) {
		super(enemyID, enemyName, enemyType, location);
		this.characterImage = data.getEnemy2();
	}
	
	@Override
	public ArrayList<Node> getNearNodes(int[][] map, Node node, Node[][] nodes, Location goal) {
		ArrayList<Node> nearNodes = new ArrayList<>(0);
		int x = node.location.getX();
		int y = node.location.getY();
		Node tempNode = null;
		//check up
		if(y-1 >= 0 ) {
			if(map[y-1][x] == 1) {
				tempNode = nodes[y-1][x];
				if(y-2 >= 0 ) {
					if(map[y-2][x] == 1 && (tempNode.location.getX() != goal.getX() || tempNode.location.getY() != goal.getY()))
						tempNode = nodes[y-2][x];
				}	
				if(nodes[tempNode.location.getY()][tempNode.location.getX()].isVisited)
					tempNode = null;
			}
		}
		
			
		if(tempNode != null)
			nearNodes.add(tempNode);
		tempNode = null;
			
			
		//check down
		if(y < map.length-1 ) {
			if(map[y+1][x] == 1) {
				tempNode = nodes[y+1][x];
				if(y < map.length-2 ) {
					if(map[y+2][x] == 1 && (tempNode.location.getX() != goal.getX() || tempNode.location.getY() != goal.getY()))
						tempNode = nodes[y+2][x];
				}	
				if(nodes[tempNode.location.getY()][tempNode.location.getX()].isVisited)
					tempNode = null;
			}
		}
		
			
		if(tempNode != null)
			nearNodes.add(tempNode);
		tempNode = null;
		//check left
		if(x-1 >= 0 ) {
			if(map[y][x-1] == 1) {
				tempNode = nodes[y][x-1];
				if(x-2 >= 0 ) {
					if(map[y][x-2] == 1 && (tempNode.location.getX() != goal.getX() || tempNode.location.getY() != goal.getY()))
						tempNode = nodes[y][x-2];
				}	
				if(nodes[tempNode.location.getY()][tempNode.location.getX()].isVisited)
					tempNode = null;
			}
		}
		
			
		if(tempNode != null)
			nearNodes.add(tempNode);
		tempNode = null;
		//check right
		if(x < map[0].length-1 ) {
			if(map[y][x+1] == 1) {
				tempNode = nodes[y][x+1];
				if(x < map[0].length-2 ) {
					if(map[y][x+2] == 1 && (tempNode.location.getX() != goal.getX() || tempNode.location.getY() != goal.getY()))
						tempNode = nodes[y][x+2];
				}	
				if(nodes[tempNode.location.getY()][tempNode.location.getX()].isVisited)
					tempNode = null;
			}
		}
		
			
		if(tempNode != null)
			nearNodes.add(tempNode);
		tempNode = null;
		
		return nearNodes;
	}

	
	@Override
	public void run(Location goal) {
		ArrayList<Moves> path = shortestPath(goal);
		move(path.get(0));
		move(path.get(0));
		
		
	}
	
	public void drawPath(Graphics g, Location goal) {
		ArrayList<Moves> path = shortestPath(goal);
		
		
		int x = location.getX(), y = location.getY(), a = 0;
		int alpha = 255 / (path.size() + 1);
		
		g.setColor(new Color(255, 0, 0, alpha * (++a) ));
		
		g.fillRect(Map.TILE_SIZE * x + 1, Map.TILE_SIZE * y, Map.TILE_SIZE, Map.TILE_SIZE);
		
		for (int i = 0; i < path.size(); i++) {
			g.setColor(new Color(255, 0, 0, alpha * (++a) ));
			switch (path.get(i)) {
				case DOWN:
					y++;
					if(checkDown(x,y) && !checkPlayer(new Location(x,y), goal))
						y++;
					
					break;
				case LEFT:
					x--;
					if(checkLeft(x,y) && !checkPlayer(new Location(x,y), goal))
						x--;
					
					break;
				case RIGHT:
					x++;
					if(checkRight(x,y) && !checkPlayer(new Location(x,y), goal))
						x++;
					
					break;
				case UP:
					y--;
					if(checkUp(x,y) && !checkPlayer(new Location(x,y), goal))
						y--;
					
					break;
			}
			g.fillRect(Map.TILE_SIZE * x + 1, Map.TILE_SIZE * y, Map.TILE_SIZE, Map.TILE_SIZE);
		}
		
		
	}
	
	
	public boolean checkUp(int x, int y) {
		if(y-1 >= 0 ) {
			if(map[y-1][x] == 1) {
				return true;
			}
		}
		return false;
	}
	
	public boolean checkDown(int x, int y) {
		if(y < map.length-1 ) {
			if(map[y+1][x] == 1) {
				return true;
			}
		}
		return false;
	}
	
	public boolean checkLeft(int x, int y) {
		if(x-1 >= 0 ) {
			if(map[location.getY()][x-1] == 1) {
				return true;
			}
		}
		return false;
	}
	
	public boolean checkRight(int x, int y) {
		if(x < map[0].length-1 ) {
			if(map[y][x+1] == 1) {
				return true;
			}
		}
		return false;
	}
}
