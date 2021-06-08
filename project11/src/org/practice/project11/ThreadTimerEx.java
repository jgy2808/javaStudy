package org.practice.project11;
import javax.swing.*;
import java.awt.*;

class TimerThread extends Thread {
	JLabel timerLabel;
	
	public TimerThread(JLabel timerLabel) {
		this.timerLabel = timerLabel;
	}
	
	public void run() {
		int n = 0;
		while(true) {
			timerLabel.setText(Integer.toString(n));
			n++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}

public class ThreadTimerEx extends JFrame {
	
	public ThreadTimerEx() {
		setTitle("Practice Thread TimerEx");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel l = new JLabel();
		l.setFont(new Font("Gothic", Font.ITALIC, 80));
		TimerThread th = new TimerThread(l);
		c.add(l);
		setSize(300, 150);
		setVisible(true);
		th.start();
	}
	
	public static void main(String[] args) {
		new ThreadTimerEx();
	}

}
