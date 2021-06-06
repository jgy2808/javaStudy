package org.practice.project10;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PieChartPercentage extends JFrame {
	Container c;
	
	JTextField appleTF = new JTextField("0", 5);
	JTextField cherryTF = new JTextField("0", 5);
	JTextField strawberryTF = new JTextField("0", 5);
	JTextField pruneTF = new JTextField("0", 5);
	
	JLabel applePer = new JLabel("apple");
	JLabel cherryPer = new JLabel("cherry");
	JLabel strawberryPer = new JLabel("strawberry");
	JLabel prunePer = new JLabel("prune");
	
	
	public PieChartPercentage() {
		setTitle("PieChart Percentage");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c = getContentPane();
		
		JPanel northP = new JPanel();
		northP.setLayout(new FlowLayout());
		northP.setBackground(Color.GRAY);
		JLabel appleL = new JLabel("apple");
		JLabel cherryL = new JLabel("cherry");
		JLabel strawberryL = new JLabel("strawberry");
		JLabel pruneL = new JLabel("prune");
		appleTF.addKeyListener(new EnterListener());
		cherryTF.addKeyListener(new EnterListener());
		strawberryTF.addKeyListener(new EnterListener());
		pruneTF.addKeyListener(new EnterListener());
		northP.add(appleL);
		northP.add(appleTF);
		northP.add(cherryL);
		northP.add(cherryTF);
		northP.add(strawberryL);
		northP.add(strawberryTF);
		northP.add(pruneL);
		northP.add(pruneTF);
		
		JPanel centerP = new JPanel();
		centerP.setLayout(new FlowLayout());
		applePer.setForeground(Color.RED);
		cherryPer.setForeground(Color.MAGENTA);
		strawberryPer.setForeground(Color.PINK);
		prunePer.setForeground(Color.ORANGE);
		centerP.add(applePer);
		centerP.add(cherryPer);
		centerP.add(strawberryPer);
		centerP.add(prunePer);
		
		c.add(centerP, BorderLayout.CENTER);
		c.add(northP, BorderLayout.NORTH);
		setSize(500, 500);
		setVisible(true);
		
	}
	
	private class EnterListener extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				int sum = Integer.parseInt(appleTF.getText()) +
						Integer.parseInt(cherryTF.getText()) +
						Integer.parseInt(strawberryTF.getText()) +
						Integer.parseInt(pruneTF.getText());
				
				applePer.setText("apple " + Integer.parseInt(appleTF.getText())/sum*100 +"%");
				cherryPer.setText("cherry " + Integer.parseInt(cherryTF.getText())/sum*100 +"%");
				strawberryPer.setText("strawberry " + Integer.parseInt(strawberryTF.getText())/sum*100 +"%");
				prunePer.setText("prune " + Integer.parseInt(pruneTF.getText())/sum*100 +"%");
				
			}
		}
	}
	
	private class MyPanel extends JPanel{
		
		public MyPanel() {
			
		}
		
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.GREEN);
			g.fillArc(100, 150, 150, 150, 0, 360);
		}
	}

	public static void main(String[] args) {
		new PieChartPercentage();
	}

}
