package org.practice.project11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MonsterLabel extends JLabel {
	int x = this.getX(), y = this.getY();
	JLabel avatar;
	MonsterLabel(JLabel avatar){
		this.avatar = avatar;
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setLocation(x, y);
		
	}
	synchronized void move() {
		if (avatar.getX() < x) {
			x -= 5;
		}
		else if (avatar.getX() > x) {
			x += 5;
		}
		if (avatar.getY() < y) {
			y -= 5;
		}
		else if (avatar.getY() > y) {
			y += 5;
		}
		repaint();
	}
}

class MonsterThread extends Thread {
	MonsterLabel monster;
	public MonsterThread(MonsterLabel monster) {
		this.monster = monster;
	}
	
	public void run() {
		while(true) {
			try {
				sleep(200);
				monster.move();
			} catch (InterruptedException e) { System.out.println("MonsterThread run exception"); return; }
		}
	}
	
}

public class MonsterAvoidGame extends JFrame {
	JLabel avatar = new JLabel("@");
	MonsterLabel monster = new MonsterLabel(avatar);

	MonsterThread th = new MonsterThread(monster);
	public MonsterAvoidGame() {
		setTitle("Warning Avatar Avoid Monster");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container gamePanel = getContentPane();
		gamePanel.setLayout(null);
		
		gamePanel.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == 'q') th.interrupt();
				else if (e.getKeyCode() == KeyEvent.VK_UP) avatar.setLocation(avatar.getX(), avatar.getY() - 10);
				else if (e.getKeyCode() == KeyEvent.VK_DOWN) avatar.setLocation(avatar.getX(), avatar.getY() + 10);
				else if (e.getKeyCode() == KeyEvent.VK_LEFT) avatar.setLocation(avatar.getX() - 10, avatar.getY());
				else if (e.getKeyCode() == KeyEvent.VK_RIGHT) avatar.setLocation(avatar.getX() + 10, avatar.getY());
			}
		});
		
		avatar.setSize(15, 15);
		avatar.setLocation(15, 50);
		gamePanel.add(avatar);
		
		monster.setText("M");
		monster.setSize(15, 15);
		monster.setLocation(50, 50);
		gamePanel.add(monster);
		
		setSize(500, 500);
		setVisible(true);
		gamePanel.requestFocus();
		
		th.start();
	}

	public static void main(String[] args) {
		new MonsterAvoidGame();

	}

}
