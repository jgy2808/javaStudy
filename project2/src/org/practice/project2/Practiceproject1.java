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
		System.out.println("���� �����Ͽ����ϴ�. ���纸����");
		while(true) {
			input = sc.nextInt();
			if (n == input) {
				System.out.print("�¾ҽ��ϴ�. �ٽ� �ϰڽ��ϱ�?(Y/N) ");
				if (sc.next().equals("y")) {
					n = rand.nextInt(100);
					System.out.println("���� �����Ͽ����ϴ�. ���纸����");
					max = 99; min = 0;
					continue;
				}
				else break;
			}
			else if (n > input) {
				System.out.println("�� ����");
				System.out.println(input + " ~ " + max);
				min = input;
			}
			else {
				System.out.println("�� ����");
				System.out.println(min + " ~ " + input);
				max = input;
			}
		}
	}

}
