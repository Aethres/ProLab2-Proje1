package game;

import javax.swing.JFrame;

import gamestates.*;

public class Main {


	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Game");
		frame.setSize(800, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new MenuState(frame));
		frame.setVisible(true);
		
		
	}
			
			

}
