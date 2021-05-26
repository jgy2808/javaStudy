package org.practice.project7;

import javax.swing.*;
import java.awt.*;

class NorthPanel extends JPanel {
	NorthPanel(){
		setBackground(Color.LIGHT_GRAY);
	}
}

class CenterPanel extends JPanel {
	CenterPanel(){
	}
}

public class ContentPaneEx extends JFrame{
	ContentPaneEx(){
		setTitle("Open Challenge 9");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		NorthPanel np = new NorthPanel();
		np.setLayout(new FlowLayout(FlowLayout.CENTER));
		np.add(new JButton("Open"));
		np.add(new JButton("Read"));
		np.add(new JButton("Close"));

		CenterPanel cp = new CenterPanel();
		cp.setLayout(null);
		JLabel jl1 = new JLabel("Java");
		JLabel jl2 = new JLabel("Hello");
		JLabel jl3 = new JLabel("Love");
		jl1.setSize(30, 10);
		jl1.setOpaque(true);
		jl1.setBackground(Color.white);
		jl1.setLocation(30, 30);
		jl2.setSize(40, 10);
		jl2.setOpaque(true);
		jl2.setBackground(Color.white);
		jl2.setLocation(60, 60);
		jl3.setSize(30, 10);
		jl3.setOpaque(true);
		jl3.setBackground(Color.white);
		jl3.setLocation(90, 90);
		cp.add(jl1);
		cp.add(jl2);
		cp.add(jl3);
		
		c.add(np, BorderLayout.NORTH);
		c.add(cp, BorderLayout.CENTER);
		
		setSize(300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ContentPaneEx();
		
	}

}
