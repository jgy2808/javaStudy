package org.practice.project3;

import java.util.Scanner;

public class WordGameApp {
	public class Player{
		Scanner sc = new Scanner(System.in);
		private String name;
		private String word;
		
		public void setName(String name) {
			this.name = name;
		}
		public void SayWord() {
			System.out.print(name + ">>");
			word = sc.nextLine();
		}
		public String getWord() {
			return word;
		}
		public void Succeed(String last) {
			if (last.charAt(last.length() - 1) != word.charAt(0)) {
				return;
			}
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name, word; int num;
		System.out.print("���ӿ� �����ϴ� �ο��� ����Դϱ�>>");
		num = sc.nextInt();
		Player[] p = new Player[num];
		for (int i = 0; i < num; i++) {
			System.out.print("�������� �̸��� �Է��ϼ���>>");
			name = sc.nextLine();
			p[i].setName(name);
		}
		System.out.println("�����ϴ� �ܾ�� �ƹ����Դϴ�");
		int i = 0;
		word = "�ƹ���";
		while(true) {
			p[i].SayWord();
			p[i].Succeed();
		}
	}

}
