package org.practice.project6;
import java.io.*;
public class FileOutputStreamEx {

	public static void main(String[] args) {
		try {
			FileOutputStream fout = new FileOutputStream("C:\\Temp/test.txt");
			FileInputStream fin = null;
			for (int i = 0; i < 10; i++) {
				int n = 10 - i;
				fout.write(n);
			}
			fout.close();
			fin = new FileInputStream("C:\\Temp/test.txt");
			int c = 0;
			while ((c = fin.read()) != -1) {
				System.out.print(c);
			}
			fin.close();
		} catch (IOException e) {
			System.out.println(e + " 입출력 오류");
		}
	}
}