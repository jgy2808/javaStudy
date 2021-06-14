package org.practice.project11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ThreadFrame extends Thread{
	JFrame f;
	ThreadFrame(JFrame f){
		this.f = f;
	}
	
	public void run() {
		while(true) {
			f.setLocation(f.getX(), f.getY() - 3);
			try { sleep(10); } catch (InterruptedException e) {	return;	}
			f.setLocation(f.getX(), f.getY() + 6);
			try { sleep(10); } catch (InterruptedException e) {	return;	}
			f.setLocation(f.getX(), f.getY() - 3);
			try { sleep(10); } catch (InterruptedException e) {	return;	}
			f.setLocation(f.getX() - 3, f.getY());
			try { sleep(10); } catch (InterruptedException e) {	return;	}
			f.setLocation(f.getX() + 6, f.getY());
			try { sleep(10); } catch (InterruptedException e) {	return;	}
			f.setLocation(f.getX() - 3, f.getY());
			try { sleep(10); } catch (InterruptedException e) {	return;	}
		}
	}
}

public class ThreadVibratingFrameEx extends JFrame {
	
	public ThreadVibratingFrameEx() {
		setTitle("Vibrating Frame Example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		ThreadFrame th = new ThreadFrame(this);
		
		setLocation(300, 300);
		setSize(300, 300);
		setVisible(true);
		th.start();
	}


	public static void main(String[] args) {
		new ThreadVibratingFrameEx();

	}

}
