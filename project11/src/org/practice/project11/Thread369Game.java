package org.practice.project11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class CountLabel extends JLabel {
	int count = 1;
	CountLabel(){
	}
	
}

public class Thread369Game extends JFrame { 
	
	Thread369Game(){
		setTitle("Thread 369 Click Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		
		CountLabel cl = new CountLabel();
		cl.setSize(80, 40);
		cl.setLocation(110, 100);
		cl.setBackground(Color.YELLOW);
		cl.setFont(new Font("Gothic", Font.ITALIC, 20));
		cl.setOpaque(true);
		cl.setHorizontalAlignment(JLabel.CENTER);
		c.add(cl);
		
		JButton btn = new JButton("Start");
		btn.setSize(80, 20);
		btn.setLocation(110, 200);
		c.add(btn);
		
		setSize(300, 300);
		setVisible(true);
		setLocation(300, 300);		
	}
	
	public static void main(String[] args) {
		new Thread369Game();

	}

}
