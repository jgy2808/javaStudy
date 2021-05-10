package org.practice.project2;

import java.util.Random;

public class twoDimenArrayRandom {

	public static void main(String[] args) {
		Random rand = new Random();
		int[][] arr = new int[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				arr[i][j] = rand.nextInt(9) + 1;
			}
		}
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.printf("%2d", arr[i][j]);
			}System.out.println();
		}
	}

}
