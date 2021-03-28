package gamestates;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameEndState extends State implements ActionListener{
	
	JButton button;
	JLabel label;

	public GameEndState(JFrame frame, int score) {
		super(frame);
		frame.repaint();
		
		
		if(score > 0)
			label = new JLabel("Oyun bitti kazandiniz. Skorunuz: " + score);
		else
			label = new JLabel("Oyun bitti kaybettiniz. Skorunuz: " + score);
		add(label);
		
		button = new JButton("Bitir");
		add(button);
		button.addActionListener(this);
		

		frame.pack();
		setSize(800, 700);
		frame.setSize(880, 700);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frame.remove(this);
		frame.add(new MenuState(frame));
		
	}

}
