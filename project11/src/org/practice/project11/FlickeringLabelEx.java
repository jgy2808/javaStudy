package org.practice.project11;

import javax.swing.*;
import java.awt.*;

class FlickeringLabel extends JLabel implements Runnable{
	public FlickeringLabel(String text) {
		super(text);
		setOpaque(true);
		Thread th = new Thread(this);
		
		th.start();
	}
	public void run() {
		int n = 0;
		while(true) {
			if (n == 0) {
				setBackground(Color.YELLOW);
				n = 1;
			}
			else {
				setBackground(Color.GREEN);
				n = 0;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}

public class FlickeringLabelEx extends JFrame{
	FlickeringLabelEx(){
		setTitle("Flickering Label Ex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		FlickeringLabel fl1 = new FlickeringLabel("±ô¹Ú");
		JLabel la = new JLabel("¾È±ô¹Ú");
		FlickeringLabel fl2 = new FlickeringLabel("¿©±âµµ ±ô¹Ú");
		
		c.add(fl1);
		c.add(la);
		c.add(fl2);
		setSize(300, 200);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new FlickeringLabelEx();

	}

}
