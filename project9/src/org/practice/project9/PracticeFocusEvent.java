package org.practice.project9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PracticeFocusEvent extends JFrame {
	Container c;
	private JTextField tf = new JTextField("java love", 20);
	PracticeFocusEvent(){
		setTitle("Practice FocusEvent Example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(tf);
		tf.addFocusListener(new MyFocusListener());
		setSize(300, 300);
		setVisible(true);
	}
	private class MyFocusListener implements FocusListener{
		public void focusGained(FocusEvent e) {
			tf.setText(tf.getText().toLowerCase());
		}

		public void focusLost(FocusEvent e) {
			tf.setText(tf.getText().toUpperCase());
		}
		
	}
	public static void main(String[] args) {
		new PracticeFocusEvent();

	}

}
