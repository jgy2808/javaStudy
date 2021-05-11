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
		int num = sc.nextInt();
		Player[] p = new Player[num];
		for (int i = 0; i < num; i++) {
			
		}
	}

}
