package org.practice.project4;

import java.io.IOException;
import java.io.InputStreamReader;

public class WordCountClass {

	public static void main(String[] args) {
		InputStreamReader rd = new InputStreamReader(System.in);
		int upperCount = 0, count = 0, len, max;
		try {
			while(true) {
				int c = rd.read();
				if (c == -1) break;
				if ((c == 32 || c == 13)) {
					count++;
				}
				if (c >= 'A' && c <= 'Z') {
					upperCount++;
				}
				System.out.print((char)c);
			}
		} catch (IOException e) {
			System.out.println("입력 오류 발생");
		}
		System.out.println(count);
		System.out.println(upperCount);
	}
}