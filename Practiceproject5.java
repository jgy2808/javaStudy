package org.practice.project1;

import java.util.Scanner;

public class Practiceproject5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m;
		System.out.print("�� : ");
		m = sc.nextInt();
		if (m / 50000 > 0) {
			System.out.println("5���� : " + m / 50000 + "��");
			m %= 50000;
		}
		if (m / 10000 > 0) {
			System.out.println("1���� : " + m / 10000 + "��");
			m %= 10000;
		}
		if (m / 5000 > 0) {
			System.out.println("5õ�� : " + m / 5000 + "��");
			m %= 5000;
		}
		if (m / 1000 > 0) {
			System.out.println("1õ�� : " + m / 1000 + "��");
			m %= 1000;
		}
		if (m / 500 > 0) {
			System.out.println("5��� : " + m / 500 + "��");
			m %= 500;
		}
		if (m / 100 > 0) {
			System.out.println("1��� : " + m / 100 + "��");
			m %= 100;
		}
		if (m / 50 > 0) {
			System.out.println("5�ʿ� : " + m / 50 + "��");
			m %= 50;
		}
		if (m / 10 > 0) {
			System.out.println("1�ʿ� : " + m / 10 + "��");
			m %= 10;
		}
				
	}
}
