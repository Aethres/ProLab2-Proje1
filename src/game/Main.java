package game;

import java.io.File;

import javax.swing.JFrame;

import gamestates.*;

public class Main {


	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Game");
		frame.setSize(800, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new MenuState(frame));
		frame.setVisible(true);
		
		
		
		//Enemy a = new Enemy();
		//a.shortestPath(g.getMap(), new Location(4, 5));
		
		System.out.println(new File("").getAbsolutePath());
		
	}
			
			

}
