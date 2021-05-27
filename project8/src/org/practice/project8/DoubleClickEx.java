package org.practice.project8;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DoubleClickEx extends JFrame{
	JPanel contentPane = new JPanel();
	DoubleClickEx(){
		setTitle("Double Click Practice Example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(contentPane);
		contentPane.addMouseListener(new MyMouseListener());
		
		setSize(400, 400);
		setVisible(true);
	}
	
	private class MyMouseListener extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() == 2) {
				int r = (int)(Math.random() * 256);
				int g = (int)(Math.random() * 256);
				int b = (int)(Math.random() * 256);
				Color c = new Color(r, g, b);
				contentPane.setBackground(c);
			}
		}
	}
	public static void main(String[] args) {
		new DoubleClickEx();

	}

}
