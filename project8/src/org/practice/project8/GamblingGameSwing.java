package org.practice.project8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamblingGameSwing extends JFrame {
	private JPanel gamePane = new JPanel();
	private JLabel[] numla = new JLabel[3];
	private JLabel la = new JLabel();
	GamblingGameSwing(){
		setTitle("Gambling Game Swing Project");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(gamePane);
		gamePane.setLayout(null);
		gamePane.addKeyListener(new MyKeyListener());
		
		for (int i = 0; i < 3; i++) {
			int x = (int)(Math.random()*4);
			numla[i] = new JLabel("0");
			numla[i].setSize(50, 30);
			numla[i].setLocation(i * 60 + 150, 150);
			numla[i].setOpaque(true);
			numla[i].setBackground(Color.magenta);
			numla[i].setForeground(Color.YELLOW);
			numla[i].setHorizontalAlignment(JLabel.CENTER);
			numla[i].setFont(new Font("����", Font.ITALIC, 30));
			gamePane.add(numla[i]);
		}
		
		la.setText("�����մϴ�");
		la.setSize(180, 30);
		la.setLocation(150, 300);
		la.setFont(new Font("����", Font.BOLD, 30));
		gamePane.add(la);
		
		setSize(500, 400);
		setVisible(true);
		gamePane.requestFocus();
	}
	
	private class MyKeyListener extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			if (e.getKeyChar() == '\n') {
				for (int i = 0; i < 3; i++) {
					int x = (int)(Math.random()*4);
					numla[i].setText(String.valueOf(x));
				}
				if (numla[0].getText().equals(numla[1].getText()) && numla[1].getText().equals(numla[2].getText())) {
					la.setText("�����մϴ�!");
				}
				else {
					la.setText("�ƽ�����");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new GamblingGameSwing();

	}

}
