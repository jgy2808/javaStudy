package org.practice.project7;

import javax.swing.*;
import java.awt.*;

public class PracticeJLabelComponent extends JFrame{
	PracticeJLabelComponent(){
		setTitle("JLabel Component Example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null);
		JLabel[] jl = new JLabel[20];
		for (int i = 0; i < 20; i++) {
			int x = (int)(Math.random()*200) + 50;
			int y = (int)(Math.random()*200) + 50;
			jl[i] = new JLabel();
			jl[i].setLocation(x, y);
			jl[i].setSize(10, 10);
			jl[i].setOpaque(true);
			jl[i].setBackground(Color.BLUE);
			c.add(jl[i]);
		}
		setSize(300, 300);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new PracticeJLabelComponent();

	}

}
