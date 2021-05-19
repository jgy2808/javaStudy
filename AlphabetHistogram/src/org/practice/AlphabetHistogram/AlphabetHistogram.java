package org.practice.AlphabetHistogram;

import java.io.IOException;
import java.io.InputStreamReader;

public class AlphabetHistogram {

	public static void main(String[] args) {
		InputStreamReader rd = new InputStreamReader(System.in);
		int[] count = new int[26];
		try {
			while (true)
			{
				int a = rd.read();
				if (a == -1)
				{
					break;
				}
				else if (a >= 'a' && a <= 'z') {
					count[a - 'a'] += 1;
				}
			}
		} catch (IOException e) {
			System.out.println("입력 오류 발생");	
		}
		for (int i = 0; i < count.length; i++) {
			System.out.print((char) (i + 65) + ">");
			for (int j = 0; j < count[i]; j++) {
				System.out.print("-");
			} System.out.println();
		}
	}
}