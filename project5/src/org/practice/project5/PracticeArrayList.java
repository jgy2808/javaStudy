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
			}
			System.out.println(al.size());
		}
		Iterator<Character> it = al.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}