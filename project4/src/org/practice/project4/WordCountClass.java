package org.practice.project4;

import java.io.IOException;
import java.io.InputStreamReader;

public class WordCountClass {

	public static void main(String[] args) {
		InputStreamReader rd = new InputStreamReader(System.in);
		int upperCount = 0, count = 0, len, max;
		String biggest = "";
		String temp = "";
		try {
			while(true) {
				int c = rd.read();
				if (c == -1) break;
				if (c != 32 && c != 13 && c != 10) {
					temp = temp.concat(String.valueOf((char)c));
				}
				if (c == 32 || c == 13) {
					if (temp.length() > biggest.length()) {
						biggest = temp;
					}
					temp = "";
					count++;
				}
				if (c >= 'A' && c <= 'Z') {
					upperCount++;
				}
				
			}
		} catch (IOException e) {
			System.out.println("입력 오류 발생");
		}
		System.out.println("w : " + count);
		System.out.println("u : " + upperCount);
		System.out.println("b : " + biggest + ", len : " + biggest.length());
	}
}