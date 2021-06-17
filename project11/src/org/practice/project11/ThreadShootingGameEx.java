package org.practice.project11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class TargetPanel extends JPanel {
	Image img;
	TargetPanel(Image img){
		this.img = img;
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	}
}

class ShooterPanel extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
	}
}

class BulletPanel extends JPanel {
	int x, y;

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.fillRect(0, 0, 6, 6);
	}
}

class TargetThread extends Thread {
	TargetPanel target;
	BulletPanel bp;
	public TargetThread(TargetPanel target, BulletPanel bp) {
		this.target = target;
		this.bp = bp;
	}
	
	boolean isMeet() {
		if (bp.getX() >= target.getX() && bp.getX() <= target.getX() + target.getWidth() &&
				bp.getY() <= target.getY() + target.getHeight()) {
			return true;
		}
		return false;
	}
	
	public void run() {
		while (true) {
			target.setLocation(target.getX() - 5, target.getY());
			if (target.getX() == -50) {
				target.setLocation(350, 10);
			}
			if (isMeet()) {
				bp.setLocation(null);
				
				try {
					sleep(1500);
				} catch (InterruptedException e) {
					return;
				}
				target.setLocation(350, 10);
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

class ShootThread extends Thread {
	
	public void run() {
		
	}
}


public class ThreadShootingGameEx extends JFrame {
	
	ThreadShootingGameEx() {
		setTitle("Thread Shooting Game Ex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		
		ImageIcon icon = new ImageIcon("images/bg1.png");
		Image img = icon.getImage();
		TargetPanel target = new TargetPanel(img);
		target.setSize(50, 50);
		target.setLocation(350, 10);
		
		BulletPanel bp = new BulletPanel();
		bp.setSize(6, 6);
		bp.setLocation(400/2 - 3, 400-100 - 6);
		
		TargetThread th = new TargetThread(target, bp);
		
		c.add(target);
		c.add(bp);
		
		ShooterPanel shooter = new ShooterPanel();
		shooter.setBackground(Color.WHITE);
		shooter.setSize(50, 50);
		shooter.setLocation(400/2 - shooter.getWidth()/2, 400 - shooter.getHeight() - 50);
		c.add(shooter);
		
		c.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					
				}
			}
		});
		
		setLocation(200, 200);
		setSize(400, 400);
		setVisible(true);
		c.requestFocus();
		
		th.start();
	}

	public static void main(String[] args) {
		new ThreadShootingGameEx();
	}
}