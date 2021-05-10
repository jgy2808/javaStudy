package org.practice.project2;
import java.util.Scanner;

public class greatestDivision {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("두 수 입력 : ");
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int[] arr1 = new int[n1/2]; int a1 = 0;
		int[] arr2 = new int[n2/2]; int a2 = 0;
		for (int i = 2; i <= n1/2; i++) {
			if(n1 % i == 0) {
				arr1[a1++] = i;
			}
		}
		for (int i = 2; i <= n2/2; i++) {
			if(n2 % i == 0) {
				arr2[a2++] = i;
			}
		}
		System.out.print("arr1의 약수들 : ");
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}System.out.println();
		System.out.print("arr2의 약수들 : ");
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}System.out.println();
		int max = 0;
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				if (arr1[i] == arr2[j] && arr1[i] > max) {
					max = arr1[i];
					break;
				}
			}
		}
		System.out.println("두 수의 최대공약수 : " + max);

	}

}
