package org.practice.project8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PracticeMouseWheel extends JFrame{
	private JPanel p = new JPanel();
	private JLabel l = new JLabel();
	PracticeMouseWheel(){
		setTitle("Practice Mouse Wheel Event");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(p);
		
		l.addMouseWheelListener(new MyMouseWheelListener());
		l.setText("Java Love");
		l.setSize(100, 40);
		l.setFont(new Font("Arial", Font.PLAIN, 10));
		p.add(l);
		
		setSize(500,  400);
		setVisible(true);
		
	}
	
	private class MyMouseWheelListener implements MouseWheelListener{
		public void mouseWheelMoved(MouseWheelEvent e) {
			int n = e.getWheelRotation();
			int size = l.getFont().getSize();
			if (n < 0) { //UP WHEEL
				l.setFont(new Font(l.getFont().getFamily(), l.getFont().getStyle(), size + 5));
			}
			else  { //DOWN WHEEL
				if (size - 5 >= 5 )
					l.setFont(new Font(l.getFont().getFamily(), l.getFont().getStyle(), size - 5));
				else {
					l.setFont(new Font(l.getFont().getFamily(), l.getFont().getStyle(), 5));
				}
			}
		}
	}
	public static void main(String[] args) {
		new PracticeMouseWheel();

	}

}
