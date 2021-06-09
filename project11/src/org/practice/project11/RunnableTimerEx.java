package org.practice.project11;

import javax.swing.*;
import java.awt.*;

class TimerRunnable implements Runnable{
	JLabel timer;
	
	public TimerRunnable(JLabel timer) {
		this.timer = timer;
	}
	
	public void run() {
		int n = 0;
		while (true) {
			timer.setText(Integer.toString(n));
			n++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}

public class RunnableTimerEx extends JFrame {
	public RunnableTimerEx() {
		setTitle("Runnable Timer Ex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel timer = new JLabel();
		timer.setFont(new Font("Gothic", Font.ITALIC, 80));
		
		TimerRunnable run = new TimerRunnable(timer);
		Thread th = new Thread(run);
		c.add(timer);
		
		setSize(300, 150);
		setVisible(true);
		th.start();
	}
	public static void main(String[] args) {
		new RunnableTimerEx();

	}

}
