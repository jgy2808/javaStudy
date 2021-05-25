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
			System.out.print("이름 : ");
			name = sc.next();
			System.out.print("학과 : ");
			major = sc.next();
			System.out.print("학점 평균 : ");
			score = sc.nextDouble();
			System.out.print("학번 : ");
			Hakbun = sc.next();
			dept.put(Hakbun, new Student(name, major, score, Hakbun));
		}
		while(true) {
			try {
				System.out.print("찾을 학생 학번 (종료:0) : ");
				Hakbun = sc.next();
				if (Hakbun.equals("0")) break;
				else if (dept.containsKey(Hakbun)) {
					System.out.print("이름 : ");
					System.out.println(dept.get(Hakbun).getName());
					System.out.print("학과 : ");
					System.out.println(dept.get(Hakbun).getMajor());
					System.out.print("학점 평균 : ");
					System.out.println(dept.get(Hakbun).getScoreaver());
					System.out.print("학번 : ");
					System.out.println(dept.get(Hakbun).getHakbun());
					System.out.println("------학생정보 끝------");
				}
				else {
					System.out.println("학생 정보 없음");
				}
			} catch (Exception e) {
				sc = new Scanner(System.in);
				System.out.println("다시 입력");
			}
		}

	}

}
