package org.practice.project8;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseListenerEx2 extends JFrame {
	private JPanel contentPane = new JPanel();
	private JLabel jl = new JLabel("no mouse event");
	MouseListenerEx2() {
		setTitle("MouseListener Practice Example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(contentPane);
		
		contentPane.addMouseListener(new MyMouseListener());
		contentPane.addMouseMotionListener(new MyMouseListener());
		
		contentPane.add(jl);
		setSize(400, 300);
		setVisible(true);
	}
	
	
	private class MyMouseListener extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			jl.setText("MousePressed (" + e.getX() + ", " + e.getY() + ")");
		}
		public void mouseReleased(MouseEvent e) {
			jl.setText("MouseReleased (" + e.getX() + ", " + e.getY() + ")");
		}
		public void mouseEntered(MouseEvent e) {
			JPanel p = (JPanel)e.getSource();
			p.setBackground(Color.CYAN);
		}
		public void mouseExited(MouseEvent e) {
			JPanel p = (JPanel)e.getSource();
			p.setBackground(Color.YELLOW);
		}
		public void mouseDragged(MouseEvent e) {
			jl.setText("MouseDragged (" + e.getX() + ", " + e.getY() + ")");
		}
		public void mouseMoved(MouseEvent e) {
			jl.setText("MouseMoved (" + e.getX() + ", " + e.getY() + ")");
		}
	}

	public static void main(String[] args) {
		new MouseListenerEx2();
		
	}

}
