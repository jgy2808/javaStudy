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
				System.out.println(name + "이(가) 졌습니다.");
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
		System.out.print("게임에 참가하는 인원은 몇명입니까>>");
		num = sc.nextInt();
		Player[] p = new Player[num];
		for (int i = 0; i < num; i++) {
			System.out.print("참가자의 이름을 입력하세요>>");
			name = sc.next();
			p[i] = new Player();
			p[i].setName(name);
		}
		System.out.println("시작하는 단어는 아버지입니다");
		int i = 0;
		boolean f = true;
		word = "아버지";
		while(f) {
			p[i].SayWord();
			f = p[i].Succeed(word);
			word = p[i].getWord();
			i = (i+1)%num;
		}
	}

}
