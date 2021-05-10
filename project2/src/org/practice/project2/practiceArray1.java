package org.practice.project2;

import java.util.Scanner;

public class practiceArray1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		System.out.print("수 10개 입력 : ");
		for (int i = 0; i < 10; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.print("3의 배수 : ");
		for (int i = 0; i < 10; i++) {
			if (arr[i] % 3 == 0) {
				System.out.print(arr[i] + " ");
			}
		}
		
	}

}
