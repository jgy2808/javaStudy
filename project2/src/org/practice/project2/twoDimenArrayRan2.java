package org.practice.project2;

import java.util.Random;

public class twoDimenArrayRan2 {

	public static void main(String[] args) {
		Random rand = new Random();
		int[][] arr = new int[4][4];
		int num, row, col;
		for (int i = 0; i < 8; i++) {
			num = rand.nextInt(9) + 1;
			do {
			row = rand.nextInt(4);
			col = rand.nextInt(4);
			}while(arr[row][col] != 0);
			arr[row][col] = num;
		}
		System.out.println("랜덤 수 생성 후 : ");
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.printf("%2d", arr[i][j]);
			}System.out.println();
		}
	}

}
