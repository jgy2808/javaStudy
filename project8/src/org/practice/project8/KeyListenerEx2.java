package org.practice.project8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KeyListenerEx2 extends JFrame {
	private JPanel contentPane = new JPanel();
	private JLabel jl = new JLabel();
	KeyListenerEx2(){
		setTitle("% : YELLOW F1 : GREEN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(contentPane);
		contentPane.addKeyListener(new MyKeyListener());
		contentPane.add(jl);
		
		setSize(300,  300);
		setVisible(true);
		contentPane.requestFocus();
	}
	
	private class MyKeyListener extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			jl.setText(e.getKeyText(e.getKeyCode()) + "키가 입력되었습니다.");
			if (e.getKeyChar() == '%') {
				contentPane.setBackground(Color.YELLOW);
			}
			else if (e.getKeyCode() == KeyEvent.VK_F1) {
				contentPane.setBackground(Color.GREEN);
			}
		}
	}

	public static void main(String[] args) {
		new KeyListenerEx2();

	}

}
