package org.practice.project1;
import java.util.Scanner;

public class Practiceproject4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char c;
		c = sc.next().charAt(0);
		if (c >= 'a' && c <= 'z') System.out.println("�ҹ����Դϴ�");
		else if(c >= 'A' && c <= 'Z') System.out.println("�빮���Դϴ�");
		else System.out.println("�����ڰ� �ƴմϴ�");

	}

}
