package org.practice.project9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LabelClickGame extends JFrame {
	Container c;
	private JLabel[] la = new JLabel[10];
	LabelClickGame() {
		setTitle("10 Label Click!!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c = getContentPane();
		c.setLayout(null);
		for (int i = 0; i < la.length; i++) {
			la[i] = new JLabel(String.valueOf(i));
			la[i].setSize(15, 15);
			la[i].setLocation((int)(Math.random()*360), (int)(Math.random()*360));
			la[i].setForeground(Color.LIGHT_GRAY);
			la[i].addMouseListener(new MyMouseListener());
			c.add(la[i]);
		}
		setSize(400, 400);
		setVisible(true);
	}
	private class MyMouseListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			JLabel l = (JLabel)e.getSource();
			for(int i = 0; i < Integer.parseInt(l.getText()); i++) {
				if (la[i].isVisible() == true) {
					return;
				}
			}
			l.setVisible(false);
		}
	}
	public static void main(String[] args) {
		new LabelClickGame();
	}

}
