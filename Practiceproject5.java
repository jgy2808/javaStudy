package org.practice.project1;

import java.util.Scanner;

public class Practiceproject5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m;
		System.out.print("돈 : ");
		m = sc.nextInt();
		if (m / 50000 > 0) {
			System.out.println("5만원 : " + m / 50000 + "장");
			m %= 50000;
		}
		if (m / 10000 > 0) {
			System.out.println("1만원 : " + m / 10000 + "장");
			m %= 10000;
		}
		if (m / 5000 > 0) {
			System.out.println("5천원 : " + m / 5000 + "장");
			m %= 5000;
		}
		if (m / 1000 > 0) {
			System.out.println("1천원 : " + m / 1000 + "장");
			m %= 1000;
		}
		if (m / 500 > 0) {
			System.out.println("5백원 : " + m / 500 + "개");
			m %= 500;
		}
		if (m / 100 > 0) {
			System.out.println("1백원 : " + m / 100 + "개");
			m %= 100;
		}
		if (m / 50 > 0) {
			System.out.println("5십원 : " + m / 50 + "개");
			m %= 50;
		}
		if (m / 10 > 0) {
			System.out.println("1십원 : " + m / 10 + "개");
			m %= 10;
		}
				
	}
}
