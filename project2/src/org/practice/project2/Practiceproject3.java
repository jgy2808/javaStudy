package org.practice.project2;
import java.util.Scanner;
public class Practiceproject3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char c = sc.next().charAt(0);
		while(c >= 'a') {
			for(char i = 'a'; i <= c; i++ ) {
				System.out.print(i);
			}System.out.println();
			c--;
		}

	}

}
