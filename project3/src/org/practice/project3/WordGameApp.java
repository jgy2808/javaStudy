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
		System.out.print("게임에 참가하는 인원은 몇명입니까>>");
		num = sc.nextInt();
		Player[] p = new Player[num];
		for (int i = 0; i < num; i++) {
			System.out.print("참가자의 이름을 입력하세요>>");
			name = sc.nextLine();
			p[i].setName(name);
		}
		System.out.println("시작하는 단어는 아버지입니다");
		int i = 0;
		word = "아버지";
		while(true) {
			p[i].SayWord();
			p[i].Succeed();
		}
	}

}
