package org.practice.project5;

import java.util.HashMap;
import java.util.Scanner;

public class PracticeHashMap {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, Integer> nation = new HashMap<String, Integer>(10);
		String country;
		int population;
		while(nation.size() < 3) {
			System.out.print("����>>");
			country = sc.next();
			System.out.print("�α�");
			population = sc.nextInt();
			nation.put(country, population);
		}
		System.out.print("� ������ �α���? ");
		country = sc.next();
		if (nation.containsKey(country)) {
			System.out.println(country + "�� �α� : " + nation.get(country));
		}
		else {
			System.out.println("�׷� ���� ����");
		}
		

	}

}
