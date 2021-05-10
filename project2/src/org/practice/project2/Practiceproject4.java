package org.practice.project2;
import java.util.Scanner;

public class Practiceproject4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, cnt = 0;
		System.out.print("임의의 수 입력 : ");
		n = sc.nextInt();
		String bin = Integer.toBinaryString(n);
		System.out.println(n + "의 2진수 : " + bin);
		for (int i = 0; i < bin.length(); i++) {
			if (bin.charAt(i) == '1') {
				cnt++;
			}
		}
		System.out.println("1 개수 : " + cnt);
	}

}
