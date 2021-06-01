package org.practice.project9;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;

public class PracticeSlider extends JFrame {
	Container c;
	private JSlider js = new JSlider(JSlider.HORIZONTAL);
	private JLabel la = new JLabel("I Love U");
	PracticeSlider() {
		setTitle("JSlider Practice Example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c = getContentPane();
		c.setLayout(new BorderLayout());
		
		js.setMinimum(1);
		js.setMaximum(100);
		js.setPaintLabels(true);
		js.setPaintTicks(true);
		js.setPaintTrack(true);
		js.setMinorTickSpacing(5);
		js.setMajorTickSpacing(20);
		js.addChangeListener(new MyChangeListener());
		c.add(js, BorderLayout.NORTH);
		
		la.setBackground(Color.YELLOW);
		la.setFont(new Font("Aial", Font.PLAIN, js.getValue()));
		c.add(la, BorderLayout.CENTER);
		
		setSize(400, 400);
		setVisible(true);
		
	}
	private class MyChangeListener implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
			la.setFont(new Font("Aial", Font.PLAIN, js.getValue()));
		}
	}

	public static void main(String[] args) {
		new PracticeSlider();

	}

}
