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
			System.out.println("Target Thread IsMeet bp x : " + bp.getX() + ", bp y : " + bp.getY() + ", target x : " + getX() + ", target y : " + getY());
			return true;
		}
		return false;
	}
	
	public void MoveTarget() {
		int x = getX() - 5;
		if (isCollision() || x < -50) {
			x = 350;
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
	TargetPanel2 tp;
	BulletPanel2(TargetPanel2 tp){
		this.tp = tp;
	}
	
	public void ShotBullet() {
		int y = 50;
		if (shot) {
			y = getY() - 5;
		}
		if (tp.isCollision() || y < 0) {
			shot = false;
			y = 294;
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
				sleep(500);
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
				sleep(500);
			} catch (InterruptedException e) { return; }
		}
	}
}

public class ThreadShootingGame2 extends JFrame {
	
	ThreadShootingGame2(){
		setTitle("Thread Shooting Game Retry(2)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		
		
		
		setSize(400, 400);
		setLocation(200, 400);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new ThreadShootingGame2();

	}

}
