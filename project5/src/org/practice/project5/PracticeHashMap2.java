package org.practice.project5;

import java.util.*;

class Student{
	private String name;
	private String major;
	private double scoreaver;
	private String Hakbun;
	public Student(String name, String major, double scoreaver, String Hakbun) {
		this.Hakbun = Hakbun;
		this.major = major;
		this.name = name;
		this.scoreaver = scoreaver;
	}
}

public class PracticeHashMap2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, Student> dept = new HashMap<String, Student>();
		String name;
		String major;
		double score;
		String Hakbun;
		for (int i = 0; i < 3; i++) {
			System.out.print("�̸� : ");
			name = sc.next();
			System.out.print("�а� : ");
			major = sc.next();
			System.out.print("���� ��� : ");
			score = sc.nextDouble();
			System.out.println("�й� : ");
			Hakbun = sc.next();
			dept.put(Hakbun, new Student(name, major, score, Hakbun));
		}
		while(true) {
			
		}

	}

}
