package org.practice.project8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PracticeKeyCodeEx extends JFrame {
	private JPanel contentPane = new JPanel();
	private JLabel jl = new JLabel("Hello");
	
	PracticeKeyCodeEx() {
		setTitle("Flying Text Example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.addKeyListener(new MyKeyListener());
		jl.setLocation(30, 30);
		jl.setSize(30, 10);
		contentPane.add(jl);
		
		setSize(300,  300);
		setVisible(true);
		contentPane.requestFocus();
	}
	
	private class MyKeyListener extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				jl.setLocation(jl.getX(), jl.getY() - 10);
			}
			else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				jl.setLocation(jl.getX(), jl.getY() + 10);
			}
			else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				jl.setLocation(jl.getX() - 10, jl.getY());
			}
			else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				jl.setLocation(jl.getX() + 10, jl.getY());
			}
		}
	}
	public static void main(String[] args) {
		new PracticeKeyCodeEx();
	}

}
