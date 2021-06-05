package org.practice.project10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PracticeJLabelImageDrag extends JFrame {
	Container c;
	ImageIcon img = new ImageIcon("images/bg1.png");
	JLabel l = new JLabel(img);
	JLabel x = new JLabel("X = " + l.getX());
	JLabel y = new JLabel("Y = " + l.getY());
	
	public PracticeJLabelImageDrag() {
		setTitle("JLabel Image Drag Ex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c = getContentPane();
		c.setLayout(null);
		
		x.setSize(70, 50);
		x.setLocation(0, 0);
		c.add(x);
		y.setSize(70, 50);
		y.setLocation(100, 0);
		c.add(y);
		l.setSize(img.getIconWidth(), img.getIconHeight());
		c.add(l);

		c.addMouseMotionListener(new MyListener());
		setSize(500, 500);
		setVisible(true);
	}
	
	private class MyListener extends MouseAdapter{
		public void mouseDragged(MouseEvent e) {
			l.setLocation(e.getX(), e.getY());
			x.setText("X = " + l.getX());
			y.setText("Y = " + l.getY());
		}
	}
	
	public static void main(String[] args) {
		new PracticeJLabelImageDrag();

	}

}
