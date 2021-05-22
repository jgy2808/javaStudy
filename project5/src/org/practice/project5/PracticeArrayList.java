package org.practice.project5;

import java.util.ArrayList;
import java.util.Scanner;

public class PracticeArrayList {
	enum Grade{A, B, C, D, F};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Character> al = new ArrayList<Character>(5);
		char c;
		while(al.size() < 5) {
			c = sc.next().charAt(0);
			
			EnumUtils.isValidEnum(Grade, String.valueOf(c));
			
			
			
			al.add(c);
			Grade n = Grade.valueOf(String.valueOf(c));
			System.out.println(n);
		}
	}
}