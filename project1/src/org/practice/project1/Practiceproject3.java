package org.practice.project1;

import java.util.Scanner;
import java.util.Random;

public class Practiceproject3 {

	public static void main(String[] args) {
		String me;
		String com;
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		for (int i = 0; i < 3; i++) {
			System.out.print("�Է� : ");
			me = sc.next();
			System.out.println("me : " + me);

			int n = rand.nextInt(3);
			if (n == 0)
				com = "�ָ�";
			else if (n == 1)
				com = "����";
			else
				com = "��";
			System.out.println("com : " + com);
			if ((me == "�ָ�" && com == "����") || (me == "����" && com == "��") || (me == "��" && com == "�ָ�")) {
				System.out.println("me win");
			} else if ((com == "�ָ�" && me == "����") || (com == "����" && me == "��") || (com == "��" && me == "�ָ�")) {
				System.out.println("com win");
			} else if ((com == "�ָ�" && me == "�ָ�") || (com == "����" && me == "����") || (com == "��" && me == "��")){
				System.out.println("me = com");
			}
		}
	}
}