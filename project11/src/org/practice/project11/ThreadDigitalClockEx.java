package org.practice.project11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

class ClockThread extends Thread{
	JLabel clock;
	ClockThread(JLabel clock){
		this.clock = clock;
		this.clock.setFont(new Font("Gothic", Font.ITALIC, 80));
	}
	public void run() {
		while(true) {
			Calendar c = Calendar.getInstance();
			int hour = c.get(Calendar.HOUR_OF_DAY);
			int min = c.get(Calendar.MINUTE);
			int sec = c.get(Calendar.SECOND);
			String label = Integer.toString(hour) + ":" + Integer.toString(min) + ":" + Integer.toString(sec);
			clock.setText(label);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("ClockThread run exception");
				return;
			}
		}
	}
}

public class ThreadDigitalClockEx extends JFrame {
	
	public ThreadDigitalClockEx() {
		setTitle("Digital Clock");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel clockLabel = new JLabel();
		ClockThread clock = new ClockThread(clockLabel);
		c.add(clockLabel);
		
		setSize(400, 300);
		setVisible(true);
		clock.start();	
		
	}

	public static void main(String[] args) {
		new ThreadDigitalClockEx();
	}

}
