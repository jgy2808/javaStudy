package org.practice.project10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GraphicClippingEx extends JFrame {
	Container c;
	ImagePanel ip = new ImagePanel();
	public GraphicClippingEx() {
		setTitle("Graphic Clipping Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(ip);
		ip.addKeyListener(new MyKeyListener());
		ip.requestFocus();
		
		setSize(400, 400);
		setVisible(true);
		
	}
	
	private class MyKeyListener extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				ip.setX(ip.getX() - 10);
			}
			else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				ip.setX(ip.getX() + 10);
			}
			else if (e.getKeyCode() == KeyEvent.VK_UP) {
				ip.setY(ip.getY() - 10);
			}
			else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				ip.setY(ip.getY() + 10);
			}
			ip.repaint();
		}
	}
	
	class ImagePanel extends JPanel {
		ImageIcon icon = new ImageIcon("images/bg1.png");
		Image img = icon.getImage();
		int clipX = 50;
		int clipY = 50;
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setClip(clipX, clipY, 50, 50);
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		}
		public void setX(int x) {
			clipX = x;
		}
		public int getX() {
			return clipX;
		}
		public void setY(int y) {
			clipY = y;
		}
		public int getY() {
			return clipY;
		}
	}

	public static void main(String[] args) {
		new GraphicClippingEx();

	}

}
