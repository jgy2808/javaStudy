package org.practice.project8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PracticeKeyListener extends JFrame {
	private JPanel jp = new JPanel();
	private JLabel la = new JLabel("Love Java");
	PracticeKeyListener(){
		setTitle("Practice KeyListener");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(jp);
		jp.addKeyListener(new MyKeyListener());
		
		la.setSize(50, 30);
		jp.add(la);
		
		setSize(300, 200);
		setVisible(true);
		jp.requestFocus();
	}
	
	private class MyKeyListener extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				String t = la.getText().substring(0, 1);
				la.setText(la.getText().substring(1) + t);
			}
		}
	}
	
	public static void main(String[] args) {
		new PracticeKeyListener();
	}

}
