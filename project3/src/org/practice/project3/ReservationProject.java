package org.practice.project3;

import java.util.Scanner;

public class ReservationProject {
	public static class Subscriber {
		Scanner sc = new Scanner(System.in);
		private String name;
		private String seat;
		private int num;

		public void Reserve() {
			System.out.print("좌석구분 S<1>, A<2>, B<3> >>");
			num = sc.nextInt();
			if (num == 1) {

			}
			else if (num == 2) {

			}
			else if (num == 3) {

			}
			System.out.print();
			System.out.print("이름>>");
			name = sc.next();
			System.out.print("");
		}

		public void ViewAllSeat() {

		}

		public void CancelReserve() {

		}

	}

	public static void main(String[] args) {

	}

}
