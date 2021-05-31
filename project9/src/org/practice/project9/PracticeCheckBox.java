package org.practice.project9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PracticeCheckBox extends JFrame {
	private Container c;
	private JButton jb = new JButton("Button");
	private JCheckBox cb1 = new JCheckBox("버튼 비활성화");
	private JCheckBox cb2 = new JCheckBox("버튼 사라짐");
	
	PracticeCheckBox(){
		setTitle("Practice Checkbox Example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c = getContentPane();
		c.setLayout(new FlowLayout());
		cb1.addItemListener(new MyItemListener());
		cb2.addItemListener(new MyItemListener());
		cb1.setBackground(Color.YELLOW);
		cb2.setBackground(Color.YELLOW);
		
		c.add(cb1);
		c.add(cb2);
		c.add(jb);
		
		setSize(250, 150);
		setVisible(true);
	}
	
	private class MyItemListener implements ItemListener{
		public void itemStateChanged(ItemEvent e) {
			if (e.getItem() == cb1) {
				if (e.getStateChange() == ItemEvent.SELECTED)
					jb.setEnabled(false);
				else
					jb.setEnabled(true);
			}
			else {
				if (e.getStateChange() == ItemEvent.SELECTED)
					jb.setVisible(false);
				else 
					jb.setVisible(true);
			}
		}
	}
	
	public static void main(String[] args) {	
		new PracticeCheckBox();
	}

}
