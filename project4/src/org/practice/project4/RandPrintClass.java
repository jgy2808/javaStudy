package org.practice.project4;

import java.util.Random;

public class RandPrintClass {

	public static void main(String[] args) {
		Random r = new Random();
		for (int i = 0; i < 7; i++) {
			System.out.println(r.nextInt(45) + 1);
		}

	}

}
