package org.practice.project4;

import java.util.Scanner;

public class RandRCPGameClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int me, com;
		while (true) {
			try {
				System.out.print("me : ");
				me = sc.nextInt();
				if (me > 3 || me < 0) break;
				com = (int) (Math.random() * 10 % 3 + 1);
				System.out.println("com : " + com);
				if (me - com == -1 || me - com == 2) System.out.println("me win");
				else if (me == com) System.out.println("draw");
				else System.out.println("com win");
			} catch (Exception e) {
				sc = new Scanner(System.in);
				System.out.println("다시 입력");
			}
		}
//		}
	}
}
