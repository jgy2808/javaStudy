package org.practice.project3;

import java.util.Scanner;

public class WordGameApp {
	public static class Player{
		Scanner sc = new Scanner(System.in);
		private String name;
		private String word;
		private String[] temp;
		static String[] wordList = new String[0];
		
		public void setName(String name) {
			this.name = name;
		}
		public void SayWord() {
			System.out.print(name + ">>");
			word = sc.next();
		}
		public String getWord() {
			return word;
		}
		public boolean IsRepeatedSameChar(String str) {
			char c = str.charAt(0);
			for(int i = 1; i < str.length(); i++) {
				if (c == str.charAt(i)) return true;
			}
			return false;
		}
		public boolean ExistSameStr(String str) {
			for (int i = 0; i < wordList.length; i++) {
				if (wordList[i].compareTo(str) == 0) return true;
			}
			return false;
		}
		public boolean Succeed(String lastword) {
			if (lastword.compareTo(word) == 0 || lastword.charAt(lastword.length() - 1) != word.charAt(0) || IsRepeatedSameChar(word) || ExistSameStr(word)) {
				System.out.println(name + "��(��) �����ϴ�.");
				return false;
			}
			else {
				temp = new String[wordList.length + 1];
				for (int i = 0; i < wordList.length; i++) {
					temp[i] = wordList[i];
				}
				temp[temp.length - 1] = word;
				wordList = temp;
				return true;
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
			name = sc.next();
			p[i] = new Player();
			p[i].setName(name);
		}
		System.out.println("�����ϴ� �ܾ�� �ƹ����Դϴ�");
		int i = 0;
		boolean f = true;
		word = "�ƹ���";
		while(f) {
			p[i].SayWord();
			f = p[i].Succeed(word);
			word = p[i].getWord();
			i = (i+1)%num;
		}
	}

}
