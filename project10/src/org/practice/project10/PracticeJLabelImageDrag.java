package org.practice.project10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PracticeJLabelImageDrag extends JFrame {
	Container c;
	
	public PracticeJLabelImageDrag() {
		setTitle("JLabel Image Drag Ex");
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
		int gX = 50;
		int gY = 50;
		public MyPanel(){
			addMouseMotionListener(new MouseAdapter() {
				public void mouseDragged(MouseEvent e) {
					gX = e.getX();
					gY = e.getY();
					repaint();
				}
			});
			
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, gX, gY, 50, 50, this);
		}
	}
	public static void main(String[] args) {
		new PracticeJLabelImageDrag();

	}

}
