package org.practice.project10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ImageFourDivide extends JFrame {
	Container c;
	
	public ImageFourDivide() {
		setTitle("Image Divide Four Parts");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c = getContentPane();
		
		MyPanel p = new MyPanel();
		c.add(p);
		
		setSize(500, 500);
		setVisible(true);
	}
	
	private class MyPanel extends JPanel{
		ImageIcon icon = new ImageIcon("images/bg1.png");
		Image img = icon.getImage();
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0, 0, getWidth()/2 - 5, getHeight()/2 - 5, 0, 0, img.getWidth(this)/2, img.getHeight(this)/2, this);
			g.drawImage(img, getWidth()/2 + 5, 0, getWidth(), getHeight()/2 - 5, img.getWidth(this)/2, 0, img.getWidth(this), img.getHeight(this)/2, this);
			g.drawImage(img, 0, getHeight()/2 + 5, getWidth()/2 - 5, getHeight(), 0, img.getHeight(this)/2, img.getWidth(this)/2, img.getHeight(this), this);
			g.drawImage(img, getWidth()/2 + 5, getHeight()/2 + 5, getWidth(), getHeight(), img.getWidth(this)/2, img.getHeight(this)/2, img.getWidth(this), img.getHeight(this), this);
		}
	}
	
	public static void main(String[] args) {
		new ImageFourDivide();
	}

}
