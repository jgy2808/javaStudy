package org.practice.project3;

import java.util.Scanner;

public class ReservationProject {
	public static class Subscriber {
		Scanner sc = new Scanner(System.in);
		private String name;
		private char seat;
		private int number;

		public void Reserve() {
			int n;
			while (true) {
				System.out.print("�¼����� S<1>, A<2>, B<3> >>");
				n = sc.nextInt();
				if (n == 1) {
					seat = 'S'; break;
				} else if (n == 2) {
					seat = 'A'; break;
				} else if (n == 3) {
					seat = 'B'; break;
				} else {
					System.out.println("�ٽ� �Է����ּ���");
				}
			}
			System.out.print("�̸�>>");
			name = sc.next();
			System.out.print("��ȣ>>");
			number = sc.nextInt();
		}

		public String getName() {
			return name;
		}

		public void CancelReserve() {
			String name;
			System.out.print("�̸�>>");
			name = sc.next();
			if (this.name == name) {
				this = new Subscriber();
			}
		}

	}

	public static void main(String[] args) {

	}

}
