package org.practice.project10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PracticeDragonImage extends JFrame {
	Container c;
	
	public PracticeDragonImage() {
		setTitle("Drag on the Image Background");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c = getContentPane();
		MyPanel p = new MyPanel();
		c.add(p);
		setSize(400, 400);
		setVisible(true);
	}
	
	private class MyPanel extends JPanel {
		ImageIcon icon = new ImageIcon("images/bg1.png");
		Image img = icon.getImage();
		
		public MyPanel() {
			
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		}
	}

	public static void main(String[] args) {
		new PracticeDragonImage();

	}

}
