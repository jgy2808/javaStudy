package org.practice.project7;

import javax.swing.*;
import java.awt.*;

public class PracticeGridLayout extends JFrame {
	PracticeGridLayout(){
		setTitle("GridLayout Practice Example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new GridLayout());
		for (int i = 0; i < 10; i++) {
			c.add(new JButton(String.valueOf(i)));
		}
		setSize(1000, 100);
		setVisible(true);
	}
	public static void main(String[] args) {
		new PracticeGridLayout();
	}

}
