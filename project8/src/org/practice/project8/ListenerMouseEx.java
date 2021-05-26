package org.practice.project8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyMouseListener implements MouseListener {

	public void mouseClicked(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {
		JButton jb = (JButton)e.getSource();
		jb.setBackground(Color.RED);
	}

	public void mouseExited(MouseEvent e) {
		JButton jb = (JButton)e.getSource();
		jb.setBackground(Color.YELLOW);
	}
}

public class ListenerMouseEx extends JFrame {
	ListenerMouseEx(){
		setTitle("ListenerMouse Practice Example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		JButton jb = new JButton("Mouse Listener Test");
		jb.setBackground(Color.YELLOW);
		MyMouseListener lm = new MyMouseListener();
		jb.addMouseListener(lm);
		
		add(jb);
		setSize(300, 300);
		setVisible(true);
	}
	public static void main(String[] args) {
		new ListenerMouseEx();

	}

}
