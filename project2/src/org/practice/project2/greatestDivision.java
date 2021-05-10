package org.practice.project2;
import java.util.Scanner;

public class greatestDivision {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("두 수 입력 : ");
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		
		int max = 0;
		for(int i = 2; i <= n1; i++) {
			if (n1 % i == 0 && n2 % i == 0) {
				max = i;
			}
		}
		
		System.out.println("두 수의 최대공약수 : " + max);

	}

}
