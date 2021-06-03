package org.practice.project10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GraphicClippingEx extends JFrame {
	Container c;
	public GraphicClippingEx() {
		setTitle("Graphic Clipping Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c = getContentPane();
		
		ImagePanel ip = new ImagePanel();
		c.add(ip, BorderLayout.CENTER);

		ip.setFocusable(true);
		setSize(400, 400);
		setVisible(true);
		
	}
	
	
	class ImagePanel extends JPanel {
		ImageIcon icon = new ImageIcon("images/bg1.png");
		Image img = icon.getImage();
		int clipX = 50;
		int clipY = 50;
		
		public ImagePanel(){
			addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_LEFT) {
						clipX -= 10;
						System.out.println("LEFT");
					}
					else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
						clipX += 10;
						System.out.println("RIGHT");
					}
					else if (e.getKeyCode() == KeyEvent.VK_UP) {
						clipY -= 10;
						System.out.println("UP");
					}
					else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
						clipY += 10;
						System.out.println("DOWN");
					}
					repaint();
				}
			});
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setClip(clipX, clipY, 50, 50);
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		}
	}

	public static void main(String[] args) {
		new GraphicClippingEx();

	}

}
