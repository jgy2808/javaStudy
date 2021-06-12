package org.practice.project11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyLabel extends JLabel {
	int n = 0;
	Thread th;

	MyLabel(Thread th) {
		this.th = th;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setText(Integer.toString(n));
		setFont(new Font("Gothic", Font.ITALIC, 80));
	}

	synchronized public void pause() {
		if (th.isAlive()) {
			try {
				wait();
			} catch (InterruptedException e) {
				return;
			}
		}
		n = 0;
		repaint();
		notify();
	}

	synchronized public void start() {
		if (!th.isAlive()) {
			try {
				wait();
			} catch (InterruptedException e) {
				return;
			}
		}
		n++;
		repaint();
		notify();
	}
}

class TimerThread2 extends Thread {
	MyLabel my;

	TimerThread2(MyLabel my) {
		this.my = my;
	}

	public void run() {
		System.out.println("run");
		while (true) {
			try {
				sleep(100);
				my.start();
			} catch (InterruptedException e) {
				System.out.println("run exception !!");
				return;
			}
		}
	}
}

public class TimerControlEx extends JFrame {
	TimerControlEx() {
		setTitle("Timer Clicked Control Ex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		TimerThread2 timer = null;
		MyLabel timerlabel = new MyLabel(timer);
		timer = new TimerThread2(timerlabel);
		c.add(timerlabel);

		c.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				timerlabel.pause();
			}
		});

		setSize(300, 300);
		setVisible(true);

		timer.start();
	}

	public static void main(String[] args) {
		new TimerControlEx();
	}

}
