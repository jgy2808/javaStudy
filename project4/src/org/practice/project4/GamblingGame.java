package org.practice.project4;

import java.util.Scanner;

public class GamblingGame {
	public static class Person{
		private String name;
		public Person(String name) {
			this.name = name;
		}
		public String getName() {
			return name;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("player1 : ");
		Person p1 = new Person(sc.next());
		System.out.print("player2 : ");
		Person p2 = new Person(sc.next());
		sc.nextLine();
		
		int[] r = new int[3];
		boolean whonow = true;
		String now;
		while(true) {
			try {
				now = (whonow)?p1.getName():p2.getName();
				System.out.print(now + ">> press Enter");
				sc.nextLine();
				for (int i = 0; i < 3; i++) {
					r[i] = (int)(Math.random()*10%4);
					System.out.print(r[i] + " ");
				}System.out.println();
				if (r[0] == r[1] && r[1] == r[2]) {
					System.out.println(now + " win!!");
					break;
				}
				else {
					System.out.println("Failed");
					whonow = !whonow;
				}System.out.println();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}