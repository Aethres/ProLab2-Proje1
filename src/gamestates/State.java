package gamestates;

import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class State extends JPanel{

	JFrame frame;
	
	public State(JFrame frame) {
		this.frame = frame;
	}
	
}
