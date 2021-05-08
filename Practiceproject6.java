package org.practice.project1;
import java.util.Scanner;
public class Practiceproject6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		n = sc.nextInt();
		if ((n%10)%3 == 0 ) {
			if ((n/10)%3 == 0 && n/10 > 0) {
				System.out.println("¹Ú¼ö Â¦Â¦");
			}
			else {
				System.out.println("¹Ú¼ö Â¦");
			}
		}
	}

}
