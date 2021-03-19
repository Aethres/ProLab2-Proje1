package game;

import java.util.ArrayList;

public abstract class Enemy extends Character{
	
	String enemyName, enemyType;
	
	enum moves{
		LEFT,
		RIGHT,
		UP,
		DOWN
	}
	
	class Node{
		int distance = -1;
		boolean isVisited = false;
		ArrayList<moves> moveList = new ArrayList<>(0);
		Location location;
	}
	
	public void shortestPath(int[][] map, Location goal) {
		this.location = new Location(3,3);
		Node[][] nodes = new Node[map.length][map[0].length];
		for (int i = 0; i < nodes.length; i++) {
			for (int j = 0; j < nodes[0].length; j++) {
				nodes[i][j] = new Node();
				nodes[i][j].location = new Location(j, i);
				//System.out.println("i: " + i + " j: " + j);
				//System.out.println("isVisited: " + nodes[i][j].isVisited);
			}
		}
		Node currentNode = nodes[3][3];
		currentNode.distance = 0;
		
		System.out.println(currentNode.distance);
		
		//nodes[location.getY()][location.getX()].distance = 0;
		
		//int h = 0;
		while(true) {
			
			ArrayList<Node> nearNodes = getNearNodes(map, currentNode, nodes);
			/*for (int i = 0; i < nearNodes.size(); i++) {
				System.out.println("y: " + nearNodes.get(i).location.getY() + " x: " + nearNodes.get(i).location.getX());
				//System.out.println("isVisited: " + nodes[i][j].isVisited);
			}*/
			for (int i = 0; i < nearNodes.size(); i++) {
				if(currentNode.distance < nearNodes.get(i).distance) {
					continue;
				}
				nearNodes.get(i).distance = currentNode.distance + 1;
				nearNodes.get(i).moveList.addAll(currentNode.moveList);
				nearNodes.get(i).moveList.add(releativePosition(currentNode, nearNodes.get(i)));
				
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
		
		System.out.println(nodes[goal.getY()][goal.getX()].moveList.toString());
		System.out.println(nodes[goal.getY()][goal.getX()].distance);
		
	}
	
	public moves releativePosition(Node node1, Node node2) {
		if(node1.location.getY() < node2.location.getY())
			return moves.DOWN;
		else if(node1.location.getY() > node2.location.getY())
			return moves.UP;
		else if(node1.location.getX() < node2.location.getX())
			return moves.RIGHT;
		else if(node1.location.getX() > node2.location.getX())
			return moves.LEFT;
		return moves.DOWN;
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
	
	public ArrayList<Node> getNearNodes(int[][] map, Node node, Node[][] nodes) {
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
