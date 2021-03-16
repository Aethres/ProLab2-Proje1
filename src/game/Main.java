package game;

import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;

import gamestates.*;

public class Main {
	
	

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Game");
		frame.setSize(800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new MenuState(frame));
		frame.setVisible(true);
		
		System.out.println(new File("").getAbsolutePath());
		
	}
			
			

}
