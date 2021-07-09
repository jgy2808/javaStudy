package org.practice.project11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class LabelHandler {
	int count = 0;
	char keyCode = 0;
	boolean flag = false;
	boolean flagOfCnt = false;
	
	JLabel p1;
	JLabel p2;
	
	LabelHandler(JLabel p1, JLabel p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	void play() {
		if (flag) {
			if (count % 2 == 0)
				p1.setText(Integer.toString(count));
			else
				p2.setText(Integer.toString(count));
		}
	}
	
	boolean isFinished() {
		if (Distinction() == 0) {
			if (keyCode != 0) { return true; }
		} else if (Distinction() == 1) {
			if (count % 2 == 0) {
				if (keyCode != 'a') return true;
			} else {
				if (keyCode != 'k') return true;
			}
		} else if (Distinction() == 2) {
			if (count % 2 == 0) {
				if (keyCode != 's') return true;
			} else {
				if (keyCode != 'l') return true;
			}
		}
		return false;
	}

	int Distinction() {
		int one = ((count%10) > 0 && (count%10)%3 == 0) ? 1 : 0;
		int ten = (count > 9 && (count/10)%3 == 0) ? 1 : 0;
		return one+ten;
	}
	

	void setKeyCode(char keyCode) {
		this.keyCode = keyCode;
	}
}

class GameThreadTwoPlayer extends Thread {
	LabelHandler lh;
	JButton btn;
	
	public GameThreadTwoPlayer(LabelHandler lh, JButton btn) {
		this.lh = lh;
		this.btn = btn;
	}
	
	public void run() {
		while(true) {
			lh.play();
			try {
				sleep(700);
			} catch (InterruptedException e) { e.printStackTrace(); return; }

			if (lh.isFinished()) {
				if (lh.count % 2 == 0) lh.p1.setText("Fail" + ((lh.Distinction() > 1) ? "^^":"^" ));
				else lh.p2.setText("Fail" + ((lh.Distinction() > 1) ? "^^":"^" ));
				init();
			}
			if (lh.flagOfCnt) {
				lh.count += 1;
			}
			lh.keyCode = 0;
		}
	}
	
	void init() {
		lh.flag = false;
		lh.flagOfCnt = false;
		lh.count = 0;
		btn.setEnabled(true);
	}
}

public class Thread369GameTwoPlayer extends JFrame {
	
	public Thread369GameTwoPlayer() {
		setTitle("Thread 369 Game Two Users");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);

		JLabel l1 = new JLabel("1P : A, S");
		l1.setSize(80, 40);
		l1.setLocation(60, 60);
		l1.setFont(new Font("Gothic", Font.ITALIC, 15));
		l1.setHorizontalAlignment(JLabel.CENTER);
		c.add(l1);
		
		JLabel l2 = new JLabel("2P : K, L");
		l2.setSize(80, 40);
		l2.setLocation(160, 60);
		l2.setFont(new Font("Gothic", Font.ITALIC, 15));
		l2.setHorizontalAlignment(JLabel.CENTER);
		c.add(l2);
		
		JLabel p1 = new JLabel();
		p1.setSize(80, 40);
		p1.setLocation(60, 100);
		p1.setBackground(Color.YELLOW);
		p1.setFont(new Font("Gothic", Font.ITALIC, 20));
		p1.setOpaque(true);
		p1.setHorizontalAlignment(JLabel.CENTER);
		c.add(p1);
		
		JLabel p2 = new JLabel();
		p2.setSize(80, 40);
		p2.setLocation(160, 100);
		p2.setBackground(Color.YELLOW);
		p2.setFont(new Font("Gothic", Font.ITALIC, 20));
		p2.setOpaque(true);
		p2.setHorizontalAlignment(JLabel.CENTER);
		c.add(p2);
		
		LabelHandler lh = new LabelHandler(p1, p2);
		
		JButton btn = new JButton("start");
		btn.setSize(80, 20);
		btn.setLocation(110, 200);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn.setEnabled(false);
				p1.setText("");
				p2.setText("");
				lh.flagOfCnt = true;
				lh.flag = true;
			}
		});
		c.add(btn);
		
		GameThreadTwoPlayer gth = new GameThreadTwoPlayer(lh, btn);
		
		c.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				System.out.println(e.getKeyChar());
				lh.setKeyCode(e.getKeyChar());
			}
		});
		
		setSize(300, 300);
		setVisible(true);
		setLocation(400, 200);
		c.setFocusable(true);
		
		gth.start();
	}
	
	public static void main(String[] args) {
		new Thread369GameTwoPlayer();
	}
}