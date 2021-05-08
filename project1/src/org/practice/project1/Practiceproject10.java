package org.practice.project1;
import java.util.Scanner;
public class Practiceproject10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x1, y1, x2, y2;
		System.out.print("직사각형 좌표 입력 : ");
		x1 = sc.nextInt();
		y1 = sc.nextInt();
		x2 = sc.nextInt();
		y2 = sc.nextInt();
		if ( ((x1 >= 50 && x1 <= 100) && (y1 >= 50 && y1 <= 100)) || ((x2 >= 50 && x2 <= 100) && (y2 >= 50 && y2 <= 100))) {
			System.out.println("사각형이 겹칩니다");
		}
		else {
			System.out.println("겹치지 않습니다");
		}
	}

}
