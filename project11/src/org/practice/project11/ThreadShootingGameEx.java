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
	boolean isMoving = false;
	public void Shoot() {
		setLocation(this.getX(), this.getY() - 5);
	}
	
	public void Moving() {
		isMoving = true;
	}
	public void NotMoving() {
		isMoving = false;
	}
	
	boolean getIsMoving() {
		return isMoving;
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
		if (bp.getX() >= target.getX() && bp.getX() <= target.getX() + target.getWidth() &&
				bp.getY() <= target.getY() + target.getHeight() + 6) {
			return true;
		}
		return false;
	}
	
	public void run() {
		while (true) {
			target.setLocation(target.getX() - 5, target.getY());
			if (target.getX() == -50 || isMeet()) {
				target.Comeback();
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

class BulletThread extends Thread {
	BulletPanel bp;
	TargetPanel target;
	BulletThread(BulletPanel bp, TargetPanel target) {
		this.bp = bp;
		this.target = target;
	}
	
	boolean isMeet() {
		if ((bp.getX() >= target.getX() && bp.getX() <= target.getX() + target.getWidth() &&
				bp.getY() <= target.getY() + target.getHeight()) || bp.getY() < 0) {
			return true;
		}
		return false;
	}
	
	public void run() {
		while(true) {
			System.out.println(bp.getIsMoving()); // 이 출력문 지우면 발사 안되고 안지우면 발사 됩니다
			if (bp.getIsMoving()) {
				bp.Shoot();
				try {
					sleep(50);
				} catch (InterruptedException e) {
					System.out.println("Bullet Thread Error");
					return;
				}
			}
			if (isMeet()) {
				bp.Comeback();
				bp.NotMoving();
			}
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
		bp.setSize(6, 6);
		bp.setLocation(BULLET_PANEL_X, BULLET_PANEL_Y);
		
		TargetThread th = new TargetThread(target, bp);
		
		c.add(target);
		c.add(bp);
		
		ShooterPanel shooter = new ShooterPanel();
		shooter.setBackground(Color.WHITE);
		shooter.setSize(50, 50);
		shooter.setLocation(400/2 - shooter.getWidth()/2, 400 - shooter.getHeight() - 50);
		c.add(shooter);

		BulletThread bth = new BulletThread(bp, target);
		
		c.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					bp.Moving();
				}
			}
		});
		
		setLocation(200, 200);
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