package org.practice.project11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ObjMoveThread extends Thread {
	JLabel label;
	public ObjMoveThread(JLabel label) {
		this.label = label;
	}
	
	public void run() {
		while (true) {
			label.setLocation(label.getX() - 5, label.getY());
			if (label.getX() == -50) {
				label.setLocation(350, 0);
			}
			try {
				sleep(200);
			} catch (InterruptedException e) {
				System.out.println("ObjMoveThread try");
				return;
			}
		}
	}
}

public class ThreadShootingGameEx extends JFrame {
	
	ThreadShootingGameEx() {
		setTitle("Thread Shooting Game Ex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		
		ImageIcon icon = new ImageIcon("images/bg1.png");
		JLabel iconLabel = new JLabel();
		iconLabel.setIcon(icon);
		iconLabel.setSize(50, 50);
		iconLabel.setLocation(350, 0);
		ObjMoveThread th = new ObjMoveThread(iconLabel);
		
		c.add(iconLabel);
		
		setLocation(200, 200);
		setSize(400, 400);
		setVisible(true);
		
		th.start();
	}

	public static void main(String[] args) {
		new ThreadShootingGameEx();
	}
}