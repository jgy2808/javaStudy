package org.practice.project1;
import java.util.Scanner;

public class Practiceproject4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char c;
		c = sc.next().charAt(0);
		if (c >= 'a' && c <= 'z') System.out.println("소문자입니다");
		else if(c >= 'A' && c <= 'Z') System.out.println("대문자입니다");
		else System.out.println("영문자가 아닙니다");

	}

}
