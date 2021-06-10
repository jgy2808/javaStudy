package org.practice.project11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

class RandomThread extends Thread {
	Container contentPane;
	boolean flag = false;
	
	public RandomThread(Container contentPane) {
		this.contentPane = contentPane;
	}
	
	public void finish() {
		flag = true;
	}
	
	public void run() {
		int x, y;
		while(true) {
			x = (int)(Math.random()*contentPane.getWidth());
			y = (int)(Math.random()*contentPane.getHeight());
			JLabel randlabel = new JLabel("java");
			randlabel.setSize(80, 30);
			randlabel.setLocation(x, y);
			contentPane.add(randlabel);
			contentPane.repaint();
			try {
				Thread.sleep(300);
				if (flag == true) {
					contentPane.removeAll();
					randlabel = new JLabel("finish");
					randlabel.setSize(80, 30);
					randlabel.setLocation(100, 100);
					randlabel.setForeground(Color.RED);
					contentPane.add(randlabel);
					contentPane.repaint();
					return;
				}
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}

public class ThreadFinishFlagEx extends JFrame{
	RandomThread th;
	public ThreadFinishFlagEx() {
		setTitle("Thread Finish use Flag");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		
		c.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				th.finish();
			}
		});
		
		setSize(300, 200);
		setVisible(true);
		
		th = new RandomThread(c);
		th.start();
		
	}

	public static void main(String[] args) {
		new ThreadFinishFlagEx();

	}

}
