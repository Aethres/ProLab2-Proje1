package characters;

import java.util.ArrayList;

import characters.Enemy.Node;
import characters.Enemy.Moves;
import game.Location;

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
}
