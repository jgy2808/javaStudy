package org.practice.project1;

import java.util.Scanner;
import java.util.Random;

public class Practiceproject3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String me;
		String com;
		
		Random rand = new Random();
		for (int i = 0; i < 3; i++) {
			System.out.print("me �Է� : ");
			me = sc.next();
			int n = rand.nextInt(3);
			if (n == 0)
				com = "�ָ�";
			else if (n == 1)
				com = "����";
			else
				com = "��";
			System.out.println("com : " + com);
			
			
			if ((me.compareTo("�ָ�") == com.compareTo("����")) || (me.compareTo("����") == com.compareTo("��")) || (me.compareTo("��") == com.compareTo("�ָ�"))) {
				System.out.println("me win");
			} else if ((com.compareTo("�ָ�") == me.compareTo("����")) || (com.compareTo("����") == me.compareTo("��")) || (com.compareTo("��") == me.compareTo("�ָ�"))) {
				System.out.println("com win");
			} else if (me.compareTo(com) == 0){
				System.out.println("me = com");
			}
		}
	}
}