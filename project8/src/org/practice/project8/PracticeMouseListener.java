package org.practice.project8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PracticeMouseListener extends JFrame {
	private JPanel p = new JPanel();
	private JLabel la = new JLabel();
	PracticeMouseListener(){
		setTitle("Practice MouseListener");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(p);
		la.addMouseListener(new MyMouseListener());
		la.setText("»ç¶ûÇØ");
		la.setSize(50, 50);
		la.setFont(new Font("¹ÙÅÁ", Font.BOLD, 20));
		p.add(la);
		setSize(300, 300);
		setVisible(true);
	}
	
	private class MyMouseListener extends MouseAdapter{
		public void mouseEntered(MouseEvent e) {
			la.setText("Love Java");
		}
		public void mouseExited(MouseEvent e) {
			la.setText("»ç¶ûÇØ");
		}
	}
	public static void main(String[] args) {
		new PracticeMouseListener();
	}

}
