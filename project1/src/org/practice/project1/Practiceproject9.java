package org.practice.project1;
import java.util.Scanner;
public class Practiceproject9 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x, y;
		System.out.print("x, y��ǥ �Է��Ͻÿ� : ");
		x = sc.nextInt();
		y = sc.nextInt();
		if ((x >= 50 && x <= 100) && (y >= 50 && y <= 100)) {
			System.out.println("�簢�� �ȿ� ���� �ֽ��ϴ�");
		}
		else {
			System.out.println("�簢�� �ۿ� ���� �ֽ��ϴ�");
		}
	}
}
