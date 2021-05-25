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
			System.out.print("나라>>");
			country = sc.next();
			System.out.print("인구");
			population = sc.nextInt();
			nation.put(country, population);
		}
		System.out.print("어떤 나라의 인구를? ");
		country = sc.next();
		if (nation.containsKey(country)) {
			System.out.println(country + "의 인구 : " + nation.get(country));
		}
		else {
			System.out.println("그런 나라 없음");
		}
		

	}

}
