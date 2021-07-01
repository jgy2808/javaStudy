package org.practice.project11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class GameLabelPlayer1 extends JLabel {
	void start(int count) {
		setText(Integer.toString(count));
	}
}

class GameLabelPlayer2 extends JLabel {
	void start(int count) {
		setText(Integer.toString(count));
	}
}

class GameThreadTwoPlayer extends Thread {
	boolean flagOfStart = false;
	int count = 1;
	GameLabelPlayer1 glp1;
	GameLabelPlayer2 glp2;
	JButton btn;
	
	public GameThreadTwoPlayer(GameLabelPlayer1 glp1, GameLabelPlayer2 glp2, JButton btn) {
		this.glp1 = glp1;
		this.glp2 = glp2;
		this.btn = btn;
	}
	
	public void run() {
		while(true) {
			if (flagOfStart) {
				btn.setEnabled(false);
				if (count % 2 == 0)
					glp1.start(count);
				else 
					glp2.start(count);
				try {
					sleep(700);
				} catch (InterruptedException e) { return; }
				count += 1;
			}
			else {
				btn.setEnabled(true);
			}
		}
	}
}

public class Thread369GameTwoPlayer extends JFrame {
	
	public Thread369GameTwoPlayer() {
		setTitle("Thread 369 Game Two Users");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);

		JLabel p1 = new JLabel("1P : A, S");
		p1.setSize(80, 40);
		p1.setLocation(60, 60);
		p1.setFont(new Font("Gothic", Font.ITALIC, 15));
		p1.setHorizontalAlignment(JLabel.CENTER);
		c.add(p1);
		
		JLabel p2 = new JLabel("2P : K, L");
		p2.setSize(80, 40);
		p2.setLocation(160, 60);
		p2.setFont(new Font("Gothic", Font.ITALIC, 15));
		p2.setHorizontalAlignment(JLabel.CENTER);
		c.add(p2);
		
		GameLabelPlayer1 glp1 = new GameLabelPlayer1();
		glp1.setSize(80, 40);
		glp1.setLocation(60, 100);
		glp1.setBackground(Color.YELLOW);
		glp1.setFont(new Font("Gothic", Font.ITALIC, 20));
		glp1.setOpaque(true);
		glp1.setHorizontalAlignment(JLabel.CENTER);
		c.add(glp1);
		
		GameLabelPlayer2 glp2 = new GameLabelPlayer2();
		glp2.setSize(80, 40);
		glp2.setLocation(160, 100);
		glp2.setBackground(Color.YELLOW);
		glp2.setFont(new Font("Gothic", Font.ITALIC, 20));
		glp2.setOpaque(true);
		glp2.setHorizontalAlignment(JLabel.CENTER);
		c.add(glp2);
		
		JButton btn = new JButton("start");
		btn.setSize(80, 20);
		btn.setLocation(110, 200);
		
		GameThreadTwoPlayer gth = new GameThreadTwoPlayer(glp1, glp2, btn);
		
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gth.flagOfStart = true;
			}
		});
		c.add(btn);
		
		c.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				
			}
		});
		
		setSize(300, 300);
		setVisible(true);
		setLocation(400, 200);
		c.requestFocus();
		
		
	}
	public static void main(String[] args) {
		new Thread369GameTwoPlayer();
	}

}
