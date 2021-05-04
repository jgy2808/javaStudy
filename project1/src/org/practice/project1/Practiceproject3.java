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
			System.out.print("입력 : ");
			me = sc.next();
			System.out.println("me : " + me);
			if (me == "주먹") { System.out.println("주먹"); }
			else if (me == "가위") { System.out.println("가위"); }
			else if (me == "보") { System.out.println("보"); }
			
			int n = rand.nextInt(3);
			if (n == 0)
				com = "주먹";
			else if (n == 1)
				com = "가위";
			else
				com = "보";
			System.out.println("com : " + com);
			
			
			if ((me == "주먹" && com == "가위") || (me == "가위" && com == "보") || (me == "보" && com == "주먹")) {
				System.out.println("me win");
			} else if ((com == "주먹" && me == "가위") || (com == "가위" && me == "보") || (com == "보" && me == "주먹")) {
				System.out.println("com win");
			} else if (com ==  me){
				System.out.println("me = com");
			}
		}
	}
}
