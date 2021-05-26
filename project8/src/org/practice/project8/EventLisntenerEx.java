package org.practice.project8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyActionListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		JButton jb = (JButton)e.getSource();
		if (jb.getText().equals("Action")) {
			jb.setText("¾×¼Ç");
		}
		else {
			jb.setText("Action");
		}
	}
}

public class EventLisntenerEx extends JFrame {
	EventLisntenerEx() {
		setTitle("Event Listener Sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		JButton jb = new JButton("Action");
		MyActionListener lis = new MyActionListener();
		jb.addActionListener(lis);
		
		add(jb);
		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new EventLisntenerEx();
	}

}
