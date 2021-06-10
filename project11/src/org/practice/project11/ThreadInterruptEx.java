package org.practice.project11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class TimerRunnable2 implements Runnable{
	JLabel timer;
	TimerRunnable2(JLabel timer){
		this.timer = timer;
	}
	public void run() {
		int n = 0;
		while(true) {
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

public class ThreadInterruptEx extends JFrame{
	Thread th;
	JButton b;
	
	public ThreadInterruptEx() {
		setTitle("Thread Interrupt Practice");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel l = new JLabel();
		l.setFont(new Font("Gothic", Font.ITALIC, 80));
		
		TimerRunnable2 timer = new TimerRunnable2(l);
		th = new Thread(timer);
		c.add(l);
		
		b = new JButton("kill thread");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				th.interrupt();
				b.setEnabled(false);
			}
		});
		c.add(b);
		
		
		setSize(300, 200);
		setVisible(true);
		
		th.start();
	}

	public static void main(String[] args) {
		new ThreadInterruptEx();
	}

}
