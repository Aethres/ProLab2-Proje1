package characters;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import game.Location;

public abstract class Player extends Character{

	protected enum MoveStates{
		RIGHT,
		LEFT,
		UP,
		DOWN,
		IDLE
	}
	
	private int score;
	
	
	Action upAction, downAction, leftAction, rightAction;
	JPanel panel;
	
	MoveStates moveState;
	
	public Player(int playerID, String playerName, String playerType, int score, Location location, JPanel panel) {
		super(playerID, playerName, playerType, location);
		this.score = score;
		this.panel = panel;
		moveState = MoveStates.IDLE;
		
		setKeyBindings();
	}
	
	public void setKeyBindings() {
		upAction = new upAction();
		downAction = new downAction();
		leftAction = new leftAction();
		rightAction = new rightAction();
		
		InputMap inputMap = panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		
		inputMap.put(KeyStroke.getKeyStroke("UP"), "upAction");
		panel.getActionMap().put("upAction", upAction);

		inputMap.put(KeyStroke.getKeyStroke("DOWN"), "downAction");
		panel.getActionMap().put("downAction", downAction);
		
		inputMap.put(KeyStroke.getKeyStroke("LEFT"), "leftAction");
		panel.getActionMap().put("leftAction", leftAction);
		
		inputMap.put(KeyStroke.getKeyStroke("RIGHT"), "rightAction");
		panel.getActionMap().put("rightAction", rightAction);
		
	}
	
	
	
	public boolean run() {
		boolean isMoved = false;
		move();
		if(moveState != MoveStates.IDLE)
			isMoved = true;
		
		moveState = MoveStates.IDLE;
		
		return isMoved;
	}
	
	protected void move() {
		switch (moveState) {
			case IDLE:
				
				break;
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
	
	public void goUp() {
		if(location.getY()-1 >= 0 ) {
			if(map[location.getY()-1][location.getX()] == 1)
				location.setY(location.getY()-1);
		}
	}
	
	public void goDown() {
		if(location.getY() < map.length-1 ) {
			if(map[location.getY()+1][location.getX()] == 1)
				location.setY(location.getY()+1);
		}
	}
	
	public void goLeft() {
		if(location.getX()-1 >= 0 ) {
			if(map[location.getY()][location.getX()-1] == 1)
				location.setX(location.getX()-1);
		}
	}
	
	public void goRight() {
		if(location.getX() < map[0].length-1 ) {
			if(map[location.getY()][location.getX()+1] == 1)
				location.setX(location.getX()+1);
		}
	}
	
	public class upAction extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			moveState = MoveStates.UP;
			
		}
		
	}
	
	public class leftAction extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			moveState = MoveStates.LEFT;
			
		}
		
	}
	
	public class downAction extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			moveState = MoveStates.DOWN;
			
		}
		
	}
	
	public class rightAction extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			moveState = MoveStates.RIGHT;
			System.out.println();
			
			
		}
		
	}
	
	
	
	
}
