package org.practice.project1;

import java.util.Scanner;
import java.util.Random;

public class Practiceproject3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String me;
		String com;
		
		Random rand = new Random();
		for (int i = 0; i < 3; i++) {
			System.out.print("me 입력 : ");
			me = sc.next();
			int n = rand.nextInt(3);
			if (n == 0)
				com = "주먹";
			else if (n == 1)
				com = "가위";
			else
				com = "보";
			System.out.println("com : " + com);
			
			
			if ((me.compareTo("주먹") == com.compareTo("가위")) || (me.compareTo("가위") == com.compareTo("보")) || (me.compareTo("보") == com.compareTo("주먹"))) {
				System.out.println("me win");
			} else if ((com.compareTo("주먹") == me.compareTo("가위")) || (com.compareTo("가위") == me.compareTo("보")) || (com.compareTo("보") == me.compareTo("주먹"))) {
				System.out.println("com win");
			} else if (me.compareTo(com) == 0){
				System.out.println("me = com");
			}
		}
	}
}