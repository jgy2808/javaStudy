package org.practice.project11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class TargetPanel2 extends JPanel {
	Image img;
	BulletPanel2 bp;
	TargetPanel2(Image img, BulletPanel2 bp){
		this.img = img;
		this.bp = bp;
	}
	
	synchronized public boolean isCollision() {
		if (getX() <= bp.getX() && bp.getX() <= getX() + getWidth() &&
				bp.getY() <= getY() + getHeight()) {
			return true;
		}
		return false;
	}
	
	 public void MoveTarget() {
		int x = getX() - 5;
		if (isCollision() || x < -50) {
			x = 350;
		}
		if (isCollision() || bp.getY() < 0) {
			bp.shot = false;
			bp.setLocation(bp.getX(), 294);
		}
		setLocation(x, getY());
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
	}
}

class BulletPanel2 extends JPanel {
	boolean shot = false;
	
	 public void ShotBullet() {
		int y = getY();
		if (shot) {
			y = getY() - 5;
		}
		setLocation(getX(), y);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.fillRect(0, 0, getWidth(), getHeight());
	}
}

class TargetThread2 extends Thread {
	TargetPanel2 tp;
	TargetThread2(TargetPanel2 tp){
		this.tp = tp;
	}
	public void run() {
		while(true) {
			tp.MoveTarget();
			try {
				sleep(300);
			} catch (InterruptedException e) { return; }
		}
	}
}

class BulletThread2 extends Thread {
	BulletPanel2 bp;
	BulletThread2(BulletPanel2 bp){
		this.bp = bp;
	}
	public void run() {
		while(true) {
			bp.ShotBullet();
			try {
				sleep(100);
			} catch (InterruptedException e) { return; }
		}
	}
}

class ShooterPanel2 extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.fillRect(0, 0, 50, 50);
	}
}

public class ThreadShootingGame2 extends JFrame {
	
	ThreadShootingGame2(){
		setTitle("Thread Shooting Game Retry(2)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		
		BulletPanel2 bp = new BulletPanel2();
		bp.setSize(6, 6);
		bp.setLocation(197, 294);
		c.add(bp);
		BulletThread2 bt = new BulletThread2(bp);
		
		ImageIcon icon = new ImageIcon("images/bg1.png");
		Image img = icon.getImage();
		TargetPanel2 tp = new TargetPanel2(img, bp);
		tp.setSize(50, 50);
		tp.setLocation(350, 10);
		c.add(tp);
		TargetThread2 tt = new TargetThread2(tp);
		
		ShooterPanel2 sp = new ShooterPanel2();
		sp.setSize(50, 50);
		sp.setLocation(175, 300);
		c.add(sp);
		
		c.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					bp.shot = true;
				}
			}
		});
		
		setSize(400, 400);
		setLocation(200, 400);
		setVisible(true);
		c.requestFocus();
		
		bt.start();
		tt.start();
	}

	public static void main(String[] args) {
		new ThreadShootingGame2();
	}
}