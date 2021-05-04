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
			System.out.print("ÀÔ·Â : ");
			me = sc.next();
			System.out.println("me : " + me);

			int n = rand.nextInt(3);
			if (n == 0)
				com = "ÁÖ¸Ô";
			else if (n == 1)
				com = "°¡À§";
			else
				com = "º¸";
			System.out.println("com : " + com);
			if ((me == "ÁÖ¸Ô" && com == "°¡À§") || (me == "°¡À§" && com == "º¸") || (me == "º¸" && com == "ÁÖ¸Ô")) {
				System.out.println("me win");
			} else if ((com == "ÁÖ¸Ô" && me == "°¡À§") || (com == "°¡À§" && me == "º¸") || (com == "º¸" && me == "ÁÖ¸Ô")) {
				System.out.println("com win");
			} else if ((com == "ÁÖ¸Ô" && me == "ÁÖ¸Ô") || (com == "°¡À§" && me == "°¡À§") || (com == "º¸" && me == "º¸")){
				System.out.println("me = com");
			}
		}
	}
}