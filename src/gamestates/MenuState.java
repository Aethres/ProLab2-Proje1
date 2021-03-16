package gamestates;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MenuState extends State implements ActionListener{

	JButton button;
	
	public MenuState(JFrame frame) {
		super(frame);
		JLabel label = new JLabel("JFrame By Example");  
        button = new JButton();  
        button.setText("Button");
        this.add(label); 
        this.add(button); 
        button.addActionListener(this);
        System.out.println("a1");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("selam");
		frame.remove(this);
		frame.add(new PlayState(frame));
		
		
	}
}
