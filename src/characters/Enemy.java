package characters;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import game.Location;
import game.Map;

public abstract class Enemy extends Character{
	
	String enemyName, enemyType;
	
	enum Moves{
		LEFT,
		RIGHT,
		UP,
		DOWN
	}
	
	class Node{
		int distance = -1;
		boolean isVisited = false;
		ArrayList<Moves> moveList = new ArrayList<>(0);
		Location location;
	}
	
	public Enemy(int enemyID, String enemyName, String enemyType, Location location) {
		super(enemyID, enemyName, enemyType, location);
		// TODO Auto-generated constructor stub
	}
	
	public void run(Location goal) {
		ArrayList<Moves> path = shortestPath(goal);
		move(path.get(0));
		
		
	}
	
	protected void move(Moves move) {
		switch (move) {
		case LEFT:
			goLeft();
			
			break;
		case RIGHT:
			goRight();
			
			break;
		case UP:
			goUp();
			
			break;
		case DOWN:
			goDown();
			
			break;
	}
		
	}
	
	public void drawPath(Graphics g, Location goal) {
		ArrayList<Moves> path = shortestPath(goal);
		
		
		int x = 0, y = 0, a = 0;
		int alpha = 255 / (path.size() + 1);
		
		g.setColor(new Color(255, 0, 0, alpha * (++a) ));
		
		g.fillRect(Map.TILE_SIZE * (x + location.getX()) + 1, Map.TILE_SIZE * (y + location.getY()), Map.TILE_SIZE, Map.TILE_SIZE);
		
		for (int i = 0; i < path.size(); i++) {
			g.setColor(new Color(255, 0, 0, alpha * (++a) ));
			switch (path.get(i)) {
				case DOWN:
					y++;
					
					break;
				case LEFT:
					x--;
					
					break;
				case RIGHT:
					x++;
					
					break;
				case UP:
					y--;
					
					break;
			}
			g.fillRect(Map.TILE_SIZE * (x + location.getX()) + 1, Map.TILE_SIZE * (y + location.getY()), Map.TILE_SIZE, Map.TILE_SIZE);
		}
		
		
	}
	
	public boolean checkPlayer(Location current, Location goal) {
		if(current.getX() == goal.getX() && current.getY() == goal.getY())
			return true;
		
		return false;
		
	}
	
	
	public void goUp() {
		if(location.getY()-1 >= 0 ) {
			if(map[location.getY()-1][location.getX()] == 1) {
				location.setY(location.getY()-1);
			}
		}
	}
	
	public void goDown() {
		if(location.getY() < map.length-1 ) {
			if(map[location.getY()+1][location.getX()] == 1) {
				location.setY(location.getY()+1);
			}
		}
	}
	
	public void goLeft() {
		if(location.getX()-1 >= 0 ) {
			if(map[location.getY()][location.getX()-1] == 1) {
				location.setX(location.getX()-1);
			}
		}
	}
	
	public void goRight() {
		if(location.getX() < map[0].length-1 ) {
			if(map[location.getY()][location.getX()+1] == 1) {
				location.setX(location.getX()+1);
			}
		}
	}
	
	public ArrayList<Moves> shortestPath(Location goal) {
		Node[][] nodes = new Node[map.length][map[0].length];
		for (int i = 0; i < nodes.length; i++) {
			for (int j = 0; j < nodes[0].length; j++) {
				nodes[i][j] = new Node();
				nodes[i][j].location = new Location(j, i);
				//System.out.println("i: " + i + " j: " + j);
				//System.out.println("isVisited: " + nodes[i][j].isVisited);
			}
		}
		Node currentNode = nodes[location.getY()][location.getX()];
		currentNode.distance = 0;
		
		//System.out.println(currentNode.distance);
		
		//nodes[location.getY()][location.getX()].distance = 0;
		
		//int h = 0;
		while(true) {
			
			ArrayList<Node> nearNodes = getNearNodes(map, currentNode, nodes, goal);
			/*for (int i = 0; i < nearNodes.size(); i++) {
				System.out.println("y: " + nearNodes.get(i).location.getY() + " x: " + nearNodes.get(i).location.getX());
				//System.out.println("isVisited: " + nodes[i][j].isVisited);
			}*/
			for (int i = 0; i < nearNodes.size(); i++) {
				if(currentNode.distance < nearNodes.get(i).distance || nearNodes.get(i).distance == -1) {
					nearNodes.get(i).distance = currentNode.distance + 1;
					nearNodes.get(i).moveList.clear();
					nearNodes.get(i).moveList.addAll(currentNode.moveList);
					nearNodes.get(i).moveList.add(releativePosition(currentNode, nearNodes.get(i)));
				}
				
				
				//System.out.println(h++ +": " + nearNodes.get(i).moveList.toString());
				//System.out.println(h +": " + nearNodes.get(i).distance);
			}
			currentNode.isVisited = true;
			int tmp = -1;
			boolean changeHappened = false;
			
			for (int i = 0; i < nodes.length; i++) {
				for (int j = 0; j < nodes[0].length; j++) {
					if(!nodes[i][j].isVisited && nodes[i][j].distance != -1 && (nodes[i][j].distance < tmp || tmp == -1)) {
						currentNode = nodes[i][j];
						tmp = currentNode.distance;
						changeHappened = true;
						
					}
				}
			}
			if (changeHappened == false) {
				break;
			}
		}
		
		//System.out.println(nodes[goal.getY()][goal.getX()].moveList.toString());
		//System.out.println(nodes[goal.getY()][goal.getX()].distance);
		return nodes[goal.getY()][goal.getX()].moveList;
		
	}
	
	public Moves releativePosition(Node node1, Node node2) {
		if(node1.location.getY() < node2.location.getY())
			return Moves.DOWN;
		else if(node1.location.getY() > node2.location.getY())
			return Moves.UP;
		else if(node1.location.getX() < node2.location.getX())
			return Moves.RIGHT;
		else if(node1.location.getX() > node2.location.getX())
			return Moves.LEFT;
		return Moves.DOWN;
	}
	
	/*
	public boolean canGoLeft(int[][] map, Location goal, Node[][] nodes) {
		int x = location.getX();
		int y = location.getY();
		if(x-1 >= 0 ) {
			if(!nodes[y][x-1].isVisited && map[y][x-1] == 1)
				return true;
		}
		return false;
	}
	public boolean canGoRight(int[][] map, Location goal, Node[][] nodes) {
		int x = location.getX();
		int y = location.getY();
		if(x <= map[0].length-1 ) {
			if(!nodes[y][x+1].isVisited && map[y][x+1] == 1)
				return true;
		}
		return false;
		}
	public boolean canGoUp(int[][] map, Location goal, Node[][] nodes) {
		int x = location.getX();
		int y = location.getY();
		if(y-1 >= 0 ) {
			if(!nodes[y-1][x].isVisited && map[y-1][x] == 1)
				return true;
		}
		return false;
	}
	public boolean canGoDown(int[][] map, Location goal, Node[][] nodes) {
		int x = location.getX();
		int y = location.getY();
		if(y <= map.length-1 ) {
			if(!nodes[y+1][x].isVisited && map[y+1][x] == 1)
				return true;
		}
		return false;
	}
	*/
	
	public ArrayList<Node> getNearNodes(int[][] map, Node node, Node[][] nodes, Location goal) {
		ArrayList<Node> nearNodes = new ArrayList<>(0);
		int x = node.location.getX();
		int y = node.location.getY();
		//check up
		if(y-1 >= 0 ) {
			if(!nodes[y-1][x].isVisited && map[y-1][x] == 1)
				nearNodes.add(nodes[y-1][x]);
		}
		//check down
		if(y < map.length-1 ) {
			if(!nodes[y+1][x].isVisited && map[y+1][x] == 1)
				nearNodes.add(nodes[y+1][x]);
		}
		//check left
		if(x-1 >= 0 ) {
			if(!nodes[y][x-1].isVisited && map[y][x-1] == 1)
				nearNodes.add(nodes[y][x-1]);
		}
		//check right
		if(x < map[0].length-1 ) {
			if(!nodes[y][x+1].isVisited && map[y][x+1] == 1)
				nearNodes.add(nodes[y][x+1]);
		}
		
		return nearNodes;
	}

}
