package org.practice.project2;
import java.util.Scanner;
import java.util.Random;
public class Practiceproject1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		int input, max = 99, min = 0;
		char c;
		int n = rand.nextInt(100);
		System.out.println("수를 결정하였습니다. 맞춰보세요");
		while(true) {
			input = sc.nextInt();
			if (n == input) {
				System.out.print("맞았습니다. 다시 하겠습니까?(Y/N) ");
				if (sc.next().equals("y")) {
					n = rand.nextInt(100);
					System.out.println("수를 결정하였습니다. 맞춰보세요");
					max = 99; min = 0;
					continue;
				}
				else break;
			}
			else if (n > input) {
				System.out.println("더 높게");
				System.out.println(input + " ~ " + max);
				min = input;
			}
			else {
				System.out.println("더 낮게");
				System.out.println(min + " ~ " + input);
				max = input;
			}
		}
	}

}
