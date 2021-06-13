package org.practice.project11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyLabel2 extends JLabel{
	MyLabel2(){
		setText("0");
		setFont(new Font("Gothic", Font.ITALIC, 80));
	}
	
	synchronized public void pause() {
		System.out.println("MyLabel pause");
		try {
			wait();
			System.out.println("MyLabel2 pause try");
		} catch (InterruptedException e) {
			System.out.println("MyLabel2 pause catch");
		}
	}
}

class TimerThread2 extends Thread {
	MyLabel2 label;
	TimerThread2(MyLabel2 label) {
		this.label = label;
	}

	public void run() {
		System.out.println("run");
		int n = 0;
		while (true) {
			label.setText(Integer.toString(n));
			n++;
			try {
				sleep(100);
			} catch (InterruptedException e) {
				n = 0;
				System.out.println("run exception !!");
				label.pause();
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
		
		MyLabel2 timerlabel = new MyLabel2();
		TimerThread2 timer = new TimerThread2(timerlabel);
		c.add(timerlabel);

		c.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (!timer.isAlive()) 
					timer.start();
				else if (timer.isAlive())
					timer.interrupt();
			}
		});

		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new TimerControlEx();
	}
}
