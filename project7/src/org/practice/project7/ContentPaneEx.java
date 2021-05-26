package org.practice.project7;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class NorthPanel extends JPanel {
	NorthPanel(){
		setBackground(Color.LIGHT_GRAY);
		NorthPanel n = new NorthPanel();
		n.setLayout(new FlowLayout(FlowLayout.LEFT));
		n.add(new JButton("Open"));
		n.add(new JButton("Read"));
		n.add(new JButton("Close"));
	}
	
	
}
class CenterPanel extends JPanel {
	CenterPanel(){
		CenterPanel c = new CenterPanel();
		c.setLayout(null);
		c.add(new JLabel("java"));
	}
}

public class ContentPaneEx extends JFrame{
	ContentPaneEx(){
		setTitle("Open Challenge 9");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		c.add(new NorthPanel(), BorderLayout.NORTH);
		c.add(new CenterPanel(), BorderLayout.CENTER);
	}
	public static void main(String[] args) {
		

	}

}
