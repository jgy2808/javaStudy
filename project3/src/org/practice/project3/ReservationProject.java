package org.practice.project3;

import java.util.Scanner;

public class ReservationProject {
	public static final int NUM_SEAT_TYPE = 3;
	public static final int NUM_SEAT = 10;

	public static class Subscriber {
		Scanner sc = new Scanner(System.in);
		private String name;
		private char seat;
		private int number;

		public void setSubscriber(int seattype) {
			if (seattype == 1) {
				seat = 'S';
			} else if (seattype == 2) {
				seat = 'A';
			} else if (seattype == 3) {
				seat = 'B';
			}
			System.out.print("�̸�>>");
			name = sc.next();
			System.out.print("��ȣ>>");
			number = sc.nextInt();
		}

		public String getName() {
			return name;
		}

		public char getSeat() {
			return seat;
		}

		public int getNumber() {
			return number;
		}
	}

	public static class SubscriberList {
		Scanner sc = new Scanner(System.in);
		private Subscriber[][] list = new Subscriber[NUM_SEAT_TYPE][];

		public SubscriberList() {
			for (int i = 0; i < NUM_SEAT_TYPE; i++) {
				list[i] = new Subscriber[NUM_SEAT];
				for (int j = 0; j < NUM_SEAT; j++) {
					list[i][j] = new Subscriber();
				}
			}
		}

		public void AddSubscriber(Subscriber s) {
			if (s.getSeat() == 'S') {
				list[0][s.getNumber() - 1] = s;
			} else if (s.getSeat() == 'A') {
				list[1][s.getNumber() - 1] = s;
			} else if (s.getSeat() == 'B') {
				list[2][s.getNumber() - 1] = s;
			}
		}

		public void Viewseat(int seattype) {
			if (seattype == 1) {
				System.out.print("S>>");
			} else if (seattype == 2) {
				System.out.print("A>>");
			} else if (seattype == 3) {
				System.out.print("B>>");
			}

			for (int i = 0; i < NUM_SEAT; i++) {
				System.out.print((i + 1) + ". ");
				if (list[seattype - 1][i].getName() == null)
					System.out.print("��");
				else
					System.out.print(list[seattype - 1][i].getName());
				if (i < NUM_SEAT - 1)
					System.out.print(" ");
			}
			System.out.println();
		}

		public void ViewAllSeat() {
			for (int i = 1; i <= NUM_SEAT_TYPE; i++) {
				Viewseat(i);
			}
			System.out.println("<<<��ȸ�� �Ϸ��Ͽ����ϴ�.>>>");
		}

		public boolean IsAllNull(int seattype) {
			for (int i = 0; i < NUM_SEAT; i++) {
				if (list[seattype][i] != null)
					return false;
			}
			return true;
		}

		public void CancelReserve(int seattype) {
			String name;
			Viewseat(seattype);
			if (IsAllNull(seattype - 1)) {
				System.out.println("�ش� �¼� Ÿ���� �¼��� ��� ����ֽ��ϴ�.");
				return;
			}
			System.out.print("�̸�>>");
			name = sc.next();
			for (int i = 0; i < NUM_SEAT; i++) {
				if (list[seattype - 1][i] != null && list[seattype - 1][i].getName().compareTo(name) == 0) {
					list[seattype - 1][i] = null;
				}
			}
		}
	}

	public static int ChoiceSeat() {
		Scanner sc = new Scanner(System.in);
		int seat;
		while (true) {
			System.out.print("�¼����� S<1>, A<2>, B<3> >>");
			seat = sc.nextInt();
			if (seat >= 1 && seat <= 3)
				break;
			System.out.println("�ٽ� �Է����ּ���.");
		}
		return seat;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Subscriber[] s = new Subscriber[9];
		SubscriberList subList = new SubscriberList();
		int sCount = 0;
		int num = 0, k;
		while (true) {
			try {
				System.out.print("����<1>, ��ȸ<2>, ���<3>, ������<4> >>");
				num = sc.nextInt();
				switch (num) {
				case 1:
					k = ChoiceSeat();
					s[sCount] = new Subscriber();
					s[sCount].setSubscriber(k);
					subList.AddSubscriber(s[sCount]);
					sCount++;
					break;
				case 2:
					subList.ViewAllSeat();
					break;
				case 3:
					k = ChoiceSeat();
					subList.CancelReserve(k);
					break;
				case 4:
					return;
				}
			} catch (Exception e) {
				System.out.println("�ٽ� �Է����ּ���.");
			}

		}
	}
}
