package org.practice.project9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ImageSlideSwing extends JFrame {
	Container contentPane;
	ImageIcon[] image = {
			new ImageIcon("image/IU1.jpg"),
			new ImageIcon("image/IU2.jpg"),
			new ImageIcon("image/IU3.jpg"),
			new ImageIcon("image/IU4.jpg")
	};
	JLabel imgla = new JLabel(image[0]);
	JButton lb = new JButton("¡ç");
	JButton rb = new JButton("¡æ");
	int imgindex = 0;
	
	ImageSlideSwing() {
		setTitle("Image Slide Practice");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		contentPane.add(imgla, BorderLayout.CENTER);
		imgla.setHorizontalAlignment(SwingConstants.CENTER);
		
		MenuPanel southP = new MenuPanel();
		contentPane.add(southP, BorderLayout.SOUTH);


		setSize(500, 600);
		setVisible(true);
		
	}

	private class MenuPanel extends JPanel{
		MenuPanel(){
			setLayout(new FlowLayout());
			lb.setSize(50, 50);
			rb.setSize(50, 50);
			lb.addActionListener(new MyActionListener());
			rb.addActionListener(new MyActionListener());
			add(lb);
			add(rb);
		}
	}
	
	private class MyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == lb && imgindex > 0) {
				imgla.setIcon(image[imgindex--]);
			}
			else if (e.getSource() == rb && imgindex < 3) {
				imgla.setIcon(image[imgindex++]);
			}
		}
	}
	
	public static void main(String[] args) {
		new ImageSlideSwing();

	}

}
