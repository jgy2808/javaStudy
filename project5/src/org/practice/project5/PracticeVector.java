package org.practice.project5;

import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class PracticeVector {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Vector<Double> v = new Vector<Double>(10);
		for (int i = 0; i < v.capacity(); i++) {
			v.add(sc.nextDouble());
		}
		double max = Collections.max(v);
		System.out.println("max : " + max);
	}

}
