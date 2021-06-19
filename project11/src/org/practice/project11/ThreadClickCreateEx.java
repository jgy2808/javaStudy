package org.practice.project11;

import javax.swing.*;


import java.awt.*;
import java.awt.event.*;

class BubblePanel extends JPanel {
	Image img;
	BubblePanel(Image img){
		this.img = img;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	}
}

class BubbleThread extends Thread {
	BubblePanel bpanel;
	BubbleThread(BubblePanel bpanel){
		this.bpanel = bpanel;
	}
	public void run() {
		while(true) {
			bpanel.setLocation(bpanel.getX(), bpanel.getY() - 5);
			try {
				sleep(500);
				if (bpanel.getY() + bpanel.getHeight() < 0) interrupt();
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}

public class ThreadClickCreateEx extends JFrame {
	int threadCount = 0;
	int panelCount = 0;
	public ThreadClickCreateEx() {
		setTitle("Thread Click Create Example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		
		ImageIcon icon = new ImageIcon("images/bg1.png");
		Image img = icon.getImage();
		BubblePanel[] bpanel = new BubblePanel[10];
		
		BubbleThread[] bthread = new BubbleThread[10];
		
		c.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				bpanel[panelCount].setSize(50, 50);
				bpanel[panelCount].setLocation(e.getX(), e.getY());
				c.add(bpanel[panelCount]);
				bthread[threadCount] = new BubbleThread(bpanel[panelCount]);
				bthread[threadCount].start();
				panelCount++;
				threadCount++;
			}
		});
		
		
		setSize(400, 400);
		setVisible(true);
	}
	public static void main(String[] args) {
		new ThreadClickCreateEx();
	}

}
