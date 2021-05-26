package org.practice.project8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PracticeMousePressed extends JFrame {
	private JPanel contentPane = new JPanel();
	private JLabel jl;
	PracticeMousePressed() {
		setTitle("Practice MousePressed Example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.addMouseListener(new MyMouseListener());
		
		jl = new JLabel("Hello");
		jl.setSize(50, 20);
		jl.setLocation(30, 30);
		
		contentPane.add(jl);
		setSize(300, 300);
		setVisible(true);
	}
	
	class MyMouseListener implements MouseListener {
		public void mouseClicked(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			jl.setLocation(x, y);}
		public void mouseReleased(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}

		public void mousePressed(MouseEvent e) {
		}
	}
	
	public static void main(String[] args) {	
		new PracticeMousePressed();
	}

}
