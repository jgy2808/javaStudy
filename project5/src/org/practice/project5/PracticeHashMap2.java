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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public double getScoreaver() {
		return scoreaver;
	}
	public void setScoreaver(double scoreaver) {
		this.scoreaver = scoreaver;
	}
	public String getHakbun() {
		return Hakbun;
	}
	public void setHakbun(String hakbun) {
		Hakbun = hakbun;
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
			System.out.print("�й� : ");
			Hakbun = sc.next();
			dept.put(Hakbun, new Student(name, major, score, Hakbun));
		}
		while(true) {
			try {
				System.out.print("ã�� �л� �й� (����:0) : ");
				Hakbun = sc.next();
				if (Hakbun.equals("0")) break;
				else if (dept.containsKey(Hakbun)) {
					System.out.print("�̸� : ");
					System.out.println(dept.get(Hakbun).getName());
					System.out.print("�а� : ");
					System.out.println(dept.get(Hakbun).getMajor());
					System.out.print("���� ��� : ");
					System.out.println(dept.get(Hakbun).getScoreaver());
					System.out.print("�й� : ");
					System.out.println(dept.get(Hakbun).getHakbun());
					System.out.println("------�л����� ��------");
				}
				else {
					System.out.println("�л� ���� ����");
				}
			} catch (Exception e) {
				sc = new Scanner(System.in);
				System.out.println("�ٽ� �Է�");
			}
		}

	}

}
