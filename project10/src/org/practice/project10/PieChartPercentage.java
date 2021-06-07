package org.practice.project10;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PieChartPercentage extends JFrame {
	Container c;
	
	JLabel appleL = new JLabel("apple");
	JLabel cherryL = new JLabel("cherry");
	JLabel strawberryL = new JLabel("strawberry");
	JLabel pruneL = new JLabel("prune");
	
	JTextField appleTF = new JTextField("0", 5);
	JTextField cherryTF = new JTextField("0", 5);
	JTextField strawberryTF = new JTextField("0", 5);
	JTextField pruneTF = new JTextField("0", 5);
	
	float sum;
	int appleVal;
	int cherryVal;
	int strawberryVal;
	int pruneVal;	
	
	JLabel applePer1 = new JLabel("apple ");
	JLabel cherryPer1 = new JLabel("cherry ");
	JLabel strawberryPer1 = new JLabel("strawberry ");
	JLabel prunePer1 = new JLabel("prune ");
	
	MyPanel chartP = new MyPanel();	
	
	public PieChartPercentage() {
		setTitle("PieChart Percentage");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c = getContentPane();
		
		JPanel northP = new JPanel();
		northP.setLayout(new FlowLayout());
		northP.setBackground(Color.GRAY);
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
		
		c.add(northP, BorderLayout.NORTH);

		c.add(chartP);
		setSize(500, 500);
		setVisible(true);
		
	}
	
	private class EnterListener extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				sum = Float.parseFloat(appleTF.getText()) +
						Float.parseFloat(cherryTF.getText()) +
						Float.parseFloat(strawberryTF.getText()) +
						Float.parseFloat(pruneTF.getText());
				appleVal = (int) Math.ceil(Integer.parseInt(appleTF.getText())*100/sum);
				cherryVal = Math.round(Integer.parseInt(cherryTF.getText())*100/sum);
				strawberryVal = Math.round(Integer.parseInt(strawberryTF.getText())*100/sum);
				pruneVal = Math.round(Integer.parseInt(pruneTF.getText())*100/sum);
				
				applePer1.setText("apple " + appleVal + "%");
				cherryPer1.setText("cherry " + cherryVal + "%");
				strawberryPer1.setText("strawberry " + strawberryVal + "%");
				prunePer1.setText("prune " + pruneVal + "%");
				
				chartP.repaint();
			}
		}
	}
	
	private class MyPanel extends JPanel{
		
		MyPanel(){
			applePer1.setForeground(Color.RED);
			cherryPer1.setForeground(Color.MAGENTA);
			strawberryPer1.setForeground(Color.PINK);
			prunePer1.setForeground(Color.ORANGE);
			
			add(applePer1);
			add(cherryPer1);
			add(strawberryPer1);
			add(prunePer1);
			
			repaint();
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			int r = getWidth()*70/100;
			int x = getWidth()/2 - r/2;
			int y = getHeight()/2 - r/2 + 10;
			
			int appleAngle = (int)Math.ceil(appleVal*3.6);
			int cherryAngle = (int) Math.round(cherryVal*3.6);
			int strawberryAngle = (int) Math.round(strawberryVal*3.6);
			int pruneAngle = (int) Math.round(pruneVal*3.6);
			
			
			g.setColor(Color.RED);
			g.fillArc(x, y, r, r, 0, appleAngle);
			g.setColor(Color.MAGENTA);
			g.fillArc(x, y, r, r, appleAngle, cherryAngle);
			g.setColor(Color.PINK);
			g.fillArc(x, y, r, r, appleAngle+cherryAngle, strawberryAngle);
			g.setColor(Color.ORANGE);
			g.fillArc(x, y, r, r, appleAngle+cherryAngle+strawberryAngle, pruneAngle);
		}
	}

	public static void main(String[] args) {
		new PieChartPercentage();
	}
}
