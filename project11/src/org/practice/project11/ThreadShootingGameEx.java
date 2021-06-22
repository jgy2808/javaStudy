package org.practice.project11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class TargetPanel extends JPanel {
	Image img;
	TargetPanel(Image img){
		this.img = img;
	}
	
	public void Comeback() {
		setLocation(350, 10);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	}
}

class BulletPanel extends JPanel {
	int x, y;
	boolean isShot = false;
	synchronized public void Shoot() {
		if (!isShot) {
			try {
				wait();
			} catch (InterruptedException e) { return; }
		}
		setLocation(this.getX(), this.getY() - 5);
		if (this.getY() < 0) {
			isShot = false;
			notify();
		}
	}
	
	synchronized public void setisShot() {
//		if (isShot) {
//			try {
//				wait();
//			} catch (InterruptedException e) { return; }
//		}
		isShot = true;
		notify();
	}
	
	public void Comeback() {
		setLocation(400/2 - 3, 400-100 - 6);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.fillRect(0, 0, 6, 6);
	}
}

class ShooterPanel extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
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
		if (target.getX() <= bp.getX() && bp.getX() <= target.getX() + target.getWidth() &&
				bp.getY() <= target.getY() + target.getHeight()) {
			System.out.println("Target Thread IsMeet bp x : " + bp.getX() + ", bp y : " + bp.getY() + ", target x : " + target.getX() + ", target y : " + target.getY());
			return true;
		}
		return false;
	}
	
	public void run() {
		while (true) {
//			System.out.println("run");
			target.setLocation(target.getX() - 5, target.getY());
//			bp.Shoot();
			try {
				sleep(200);
			} catch (InterruptedException e) {
				System.out.println("ObjMoveThread try");
				return;
			}
			if (this.isMeet() || target.getX() == -50) {
				target.Comeback();
			}
			if (this.isMeet() || bp.getY() < 0) {
				bp.isShot = false;
				bp.Comeback();
			}
		}
	}
}

class BulletThread extends Thread {
	BulletPanel bp;
	TargetPanel target;
	BulletThread(BulletPanel bp, TargetPanel target) {
		this.bp = bp;
		this.target = target;
	}
	
//	boolean isMeet() {
//		if ((target.getX() <= bp.getX() && bp.getX() <= target.getX() + target.getWidth() &&
//				bp.getY() <= target.getY() + target.getHeight()) || bp.getY() < 0) {
//			System.out.println("Bullet Thread IsMeet bp x : " + bp.getX() + ", bp y : " + bp.getY() + ", target x : " + target.getX() + ", target y : " + target.getY());
//			return true;
//		}
//		return false;
//	}
	
	public void run() {
		while(true) {
			bp.Shoot();
			try {
				sleep(100);
			} catch (InterruptedException e) { return; }
		}
	}
}


public class ThreadShootingGameEx extends JFrame {
	final int BULLET_PANEL_X = 400/2 - 3;
	final int BULLET_PANEL_Y = 400-100 - 6;
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
		bp.setBackground(Color.BLUE);
		bp.setSize(6, 6);
		bp.setLocation(BULLET_PANEL_X, BULLET_PANEL_Y);
		
		ShooterPanel shooter = new ShooterPanel();
		shooter.setBackground(Color.BLUE);
		shooter.setSize(50, 50);
		shooter.setLocation(400/2 - shooter.getWidth()/2, 400 - shooter.getHeight() - 50);
		
		c.add(target);
		c.add(bp);
		c.add(shooter);
		

		TargetThread th = new TargetThread(target, bp);
		BulletThread bth = new BulletThread(bp, target);
		
		c.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					System.out.println("pressed Enter");
					bp.setisShot();
				}
			}
		});
		
		setLocation(400, 200);
		setSize(400, 400);
		setVisible(true);
		c.requestFocus();
		
		th.start();
		bth.start();
	}

	public static void main(String[] args) {
		new ThreadShootingGameEx();
	}
}