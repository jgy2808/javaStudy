package org.practice.project10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PracticeJLabelImageDrag extends JFrame {
	Container c;
	ImageIcon img = new ImageIcon("images/bg1.png");
	JLabel l = new JLabel(img);
	int lX = 50;
	int lY = 50;
	
	public PracticeJLabelImageDrag() {
		setTitle("JLabel Image Drag Ex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c = getContentPane();
		c.setLayout(null);
		
		
		l.setSize(img.getIconWidth(), img.getIconHeight());
		l.addMouseMotionListener(new MyListener());
		c.add(l);
		
		setSize(500, 500);
		setVisible(true);
	}
	
	private class MyListener extends MouseAdapter{
		public void mouseDragged(MouseEvent e) {
			lX = e.getX();
			lY = e.getY();
			l.setLocation(lX, lY);
		}
	}
	
	public static void main(String[] args) {
		new PracticeJLabelImageDrag();

	}

}
