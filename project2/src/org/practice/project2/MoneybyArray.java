package org.practice.project2;

import java.util.Scanner;

public class MoneybyArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int[] unit = {50000, 10000, 1000, 500, 100, 50, 10, 1};
		int[] cnt = new int[unit.length];
		for (int i = 0; i < unit.length; i++) {
			cnt[i] = m / unit[i];
			m %= unit[i]; 
		}
		System.out.print("ÁöÆó/µ¿Àü ¼ö : ");
		for (int i = 0; i < cnt.length; i++) {
			System.out.print(cnt[i] + " ");
		}
	
	}

}
