package gamestates;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import game.GetData;

public class MenuState extends State implements ActionListener{

	JButton button1, button2;
	GetData data;
	BufferedImage player1, player2;
	final int SCALE = 5;
	
	public MenuState(JFrame frame) {
		super(frame);
		data = new GetData();
        playerSelection();
        
        frame.pack();
		setSize(800, 700);
		frame.setSize(880, 700);
	}
	
	private void playerSelection() {
		player1 = data.getPlayer1();
		player2 = data.getPlayer2();
		Image image = player1.getScaledInstance(player1.getWidth() * SCALE, player1.getHeight() * SCALE, BufferedImage.SCALE_REPLICATE);
		
		button1 = new JButton(new ImageIcon(image));
		image = player2.getScaledInstance(player2.getWidth() * SCALE, player2.getHeight() * SCALE, BufferedImage.SCALE_REPLICATE);
		button2 = new JButton(new ImageIcon(image));
		
		button1.setFocusPainted(false);
		button2.setFocusPainted(false);
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		this.add(button1); 
		this.add(button2); 
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frame.remove(this);
		if (e.getSource() == button1) {
			frame.add(new PlayState(frame, "player1"));
		} 
		else if(e.getSource() == button2){
			frame.add(new PlayState(frame, "player2"));
		}
		
		
	}
}
