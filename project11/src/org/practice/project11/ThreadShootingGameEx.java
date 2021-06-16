package org.practice.project11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ShooterPanel extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
	}
}

class ObjMoveThread extends Thread {
	JLabel label;
	public ObjMoveThread(JLabel label) {
		this.label = label;
	}
	
	public void run() {
		while (true) {
			label.setLocation(label.getX() - 5, label.getY());
			if (label.getX() == -50) {
				label.setLocation(350, 10);
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
		Image img = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		icon.setImage(img);
		JLabel iconLabel = new JLabel();
		iconLabel.setIcon(icon);
		iconLabel.setSize(50, 50);
		iconLabel.setLocation(350, 10);
		ObjMoveThread th = new ObjMoveThread(iconLabel);
		
		c.add(iconLabel);
		
		ShooterPanel shooter = new ShooterPanel();
		shooter.setSize(50, 50);
		shooter.setLocation(175, 300);
		c.add(shooter);
		
		setLocation(200, 200);
		setSize(400, 400);
		setVisible(true);
		
		th.start();
	}

	public static void main(String[] args) {
		new ThreadShootingGameEx();
	}
}