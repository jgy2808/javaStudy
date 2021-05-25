package org.practice.project5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class PracticeArrayList {
	enum Grade{A, B, C, D, F};
	
	static boolean InGrade(String s) {
		for(int i = 0; i < 5; i++) {
			if (s.compareTo(String.valueOf(Grade.values()[i])) == 0) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Character> al = new ArrayList<Character>(5);
		String c;
		while(al.size() < 5) {
			c = sc.next();
			if (InGrade(c)) {
				al.add(c.charAt(0));
				System.out.println(al.size());
			}
			else {
				System.out.println("다시 입력");
			}
		}
		char ci;
		Iterator<Character> it = al.iterator();
		while(it.hasNext()) {
			ci = it.next();
			System.out.print(ci + ">>");
			switch(ci) {
			case 'A' :
				System.out.println(5);
				break;
			case 'B' :
				System.out.println(4);
				break;
			case 'C' :
				System.out.println(3);
				break;
			case 'D' :
				System.out.println(2);
				break;
			case 'F' :
				System.out.println(1);
				break;
			}
		}
	}
}