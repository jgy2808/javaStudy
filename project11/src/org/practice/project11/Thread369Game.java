package org.practice.project11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class CountLabel extends JLabel {
	int count = 0;
	boolean flagOfCnt = false;
	int clickCnt = 0;
	
	int getCount() {
		return count;
	}
	
	void setFlag() {
		flagOfCnt = true;
	}
	
	void start() {
		if (flagOfCnt) {
			setText(Integer.toString(count));
		}
	}
	
	void isFinished() {
		if (Distinction(count) != clickCnt)
			init();
		clickCnt = 0;
	}
	
	void setclickCnt(int clickCnt) {
		this.clickCnt = clickCnt;
	}
	
	int Distinction(int value) {
		int one = ((value%10) > 0 && (value%10)%3 == 0) ? 1 : 0;
		int ten = (value > 9 && (value/10)%3 == 0) ? 1 : 0;
		return one+ten;
	}

	void init() {
		count = 0;
		flagOfCnt = false;
	}
}

class GameThread extends Thread {
	CountLabel cl;
	JButton btn;
	GameThread(CountLabel cl, JButton btn){
		this.cl = cl;
		this.btn = btn;
	}
	
	public void run() {
		while(true) {
			setbtnEnabled();
			cl.start();
			try {
				sleep(500);
			} catch (InterruptedException e) { return; }
			cl.isFinished();
			if (cl.flagOfCnt) cl.count += 1;
		}
	}
	
	void setbtnEnabled() {
		if (cl.flagOfCnt)
			btn.setEnabled(false);
		else
			btn.setEnabled(true);
	}
}

public class Thread369Game extends JFrame { 
	
	Thread369Game(){
		setTitle("Thread 369 Click Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		
		CountLabel cl = new CountLabel();
		cl.setSize(80, 40);
		cl.setLocation(110, 100);
		cl.setBackground(Color.YELLOW);
		cl.setFont(new Font("Gothic", Font.ITALIC, 20));
		cl.setOpaque(true);
		cl.setHorizontalAlignment(JLabel.CENTER);
		cl.setText(Integer.toString(cl.getCount()));
		c.add(cl);
		
		JButton btn = new JButton("Start");
		btn.setSize(80, 20);
		btn.setLocation(110, 200);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.setFlag();
			}
		});
		c.add(btn);
		
		GameThread gt = new GameThread(cl, btn);
		
		c.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				System.out.println(e.getClickCount());
				if (cl.flagOfCnt) {
					cl.setclickCnt(e.getClickCount());
				}
			}
		});
		
		setSize(300, 300);
		setVisible(true);
		setLocation(300, 300);
		
		gt.start();
	}
	
	public static void main(String[] args) {
		new Thread369Game();

	}
}
