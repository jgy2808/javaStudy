package org.practice.project1;
import java.util.Scanner;
public class Practiceproject7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a[] = new int[3], temp;
		for (int i = 0; i < 3; i++)
			a[i] = sc.nextInt();
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i+1; j < a.length; j++) {
				if (a[i] > a[j]) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		if (a[0] + a[1] > a[2]) System.out.println("True");
		else System.out.println("False");
	}

}
