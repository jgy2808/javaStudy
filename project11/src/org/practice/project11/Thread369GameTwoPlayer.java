package org.practice.project11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class GameLabelPlayer1 extends JLabel {
}

class GameLabelPlayer2 extends JLabel {
}

class LabelHandler {
	int count = 1;
	char keyCode;
	
	GameLabelPlayer1 p1;
	GameLabelPlayer2 p2;
	LabelHandler(GameLabelPlayer1 p1, GameLabelPlayer2 p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	boolean flag = false;
	void play() {
		if (flag) {
			if (count % 2 == 0)
				p1.setText(Integer.toString(count));
			else
				p2.setText(Integer.toString(count));
		}
	}
	
	boolean isFinished() {
		if (Distinction() > 0) {
			if (count % 2 == 0) {
				if (Distinction() == 1 && keyCode != 'a') {
					p1.setText("Fail^");
				} else if (Distinction() == 2 && keyCode != 's') {
					p1.setText("Fail^^");
				}
				System.out.println("1p fail");
				return true;
			} else {
				if (Distinction() == 1 && keyCode != 'k') {
					p2.setText("Fail^");
				} else if (Distinction() == 2 && keyCode != 'l') {
					p2.setText("Fail^^");
				}
				System.out.println("2p fail");
				return true;
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
	boolean flagOfCnt = false;
	LabelHandler lh;
	JButton btn;
	
	public GameThreadTwoPlayer(GameLabelPlayer1 p1, GameLabelPlayer2 p2, JButton btn) {
		lh = new LabelHandler(p1, p2);
		this.btn = btn;
	}
	
	LabelHandler getlabelhandler() {
		return lh;
	}
	
	public void run() {
		while(true) {
//			setBtnEnabled();
//			if (count % 2 == 0)
//				glp1.start(count);
//			else
//				glp2.start(count);
//			try {
//				sleep(700);
//			} catch (InterruptedException e) { return; }
//			isFinished();
//			if (flagOfStart) count += 1;
//			---------------------------------------------------------------
//			if (flagOfBtn) {
//				if (count % 2 == 0)
//					glp1.setText(Integer.toString(count));
//				else 
//					glp2.setText(Integer.toString(count));
//				try {
//					sleep(700);
//				} catch (InterruptedException e) { e.printStackTrace(); return; }
//				isFinished();
//				count += 1;
//			}
			lh.play();
			try {
				sleep(700);
			} catch (InterruptedException e) { e.printStackTrace(); return; }
			if (lh.isFinished()) {
				init();
			}
			if (flagOfCnt) lh.count += 1;
		}
	}
	
	void sethandlerflag() {
		lh.flag = true;
	}
	
	void init() {
		lh.flag = false;
		flagOfCnt = false;
		lh.count = 1;
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
		
		GameLabelPlayer1 p1 = new GameLabelPlayer1();
		p1.setSize(80, 40);
		p1.setLocation(60, 100);
		p1.setBackground(Color.YELLOW);
		p1.setFont(new Font("Gothic", Font.ITALIC, 20));
		p1.setOpaque(true);
		p1.setHorizontalAlignment(JLabel.CENTER);
		c.add(p1);
		
		GameLabelPlayer2 p2 = new GameLabelPlayer2();
		p2.setSize(80, 40);
		p2.setLocation(160, 100);
		p2.setBackground(Color.YELLOW);
		p2.setFont(new Font("Gothic", Font.ITALIC, 20));
		p2.setOpaque(true);
		p2.setHorizontalAlignment(JLabel.CENTER);
		c.add(p2);
		
		JButton btn = new JButton("start");
		btn.setSize(80, 20);
		btn.setLocation(110, 200);
		
		GameThreadTwoPlayer gth = new GameThreadTwoPlayer(p1, p2, btn);
		
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn.setEnabled(false);
				p1.setText("");
				p2.setText("");
				gth.flagOfCnt = true;
				gth.sethandlerflag();
			}
		});
		c.add(btn);
		
		c.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				System.out.println(e.getKeyChar());
				gth.getlabelhandler().setKeyCode(e.getKeyChar());
			}
		});
		
		setSize(300, 300);
		setVisible(true);
		setLocation(400, 200);
		c.requestFocus();
		
		gth.start();
		
	}
	public static void main(String[] args) {
		new Thread369GameTwoPlayer();
	}

}
