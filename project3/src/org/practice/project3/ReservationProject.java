package org.practice.project3;

import java.util.Scanner;

public class ReservationProject {
	public static final int NUM_SEAT_TYPE = 3;
	public static final int NUM_SEAT = 10;
	static Scanner sc = new Scanner(System.in);

	public static class Subscriber {
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
			while (true) {
				try {
					System.out.print("��ȣ>>");
					number = sc.nextInt();
					if (number >= 0 && number <= NUM_SEAT) {
						break;
					}
				} catch (Exception e) {
					sc = new Scanner(System.in);
					System.out.println("�ٽ� �Է����ּ���.");
				}
			}
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
				if (s.getNumber() == list[0][s.getNumber() - 1].getNumber()) {
					System.out.println("�̹� �ִ� �¼��Դϴ�.");
					return;
				}
				list[0][s.getNumber() - 1] = s;
			}
			else if (s.getSeat() == 'A') {
				if (s.getNumber() == list[1][s.getNumber() - 1].getNumber()) {
					System.out.println("�̹� �ִ� �¼��Դϴ�.");
					return;
				}
				list[1][s.getNumber() - 1] = s;
			}
			else if (s.getSeat() == 'B') {
				if (s.getNumber() == list[2][s.getNumber() - 1].getNumber()) {
					System.out.println("�̹� �ִ� �¼��Դϴ�.");
					return;
				}
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
					System.out.print("_");
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
				if (list[seattype][i].getName() != null)
					return false;
			}
			return true;
		}

		public void CancelReserve(int seattype) {
			int num;
			Viewseat(seattype);
			if (IsAllNull(seattype - 1)) {
				System.out.println("�ش� �¼� Ÿ���� �¼��� ��� ����ֽ��ϴ�.");
				return;
			}
			// -- �̸� ���� ��ȣ �Է��ؼ� ���� ����ϱ� -> �������� ���� �� ���� --
			System.out.print("��ȣ>>");
			num = sc.nextInt();
			if (list[seattype - 1][num - 1].getName() == null) {
				System.out.println("�ش� �¼��� ����ֽ��ϴ�.");
			}
			else {
				list[seattype - 1][num - 1] = new Subscriber();
				System.out.println("�¼� ������ ��ҵǾ����ϴ�.");
			}
		}
	}

	public static int ChoiceSeat() {
		int seat;
		while (true) {
			try {
				System.out.print("�¼����� S<1>, A<2>, B<3> >>");
				seat = sc.nextInt();
				if (seat >= 1 && seat <= 3) {
					break;
				}
				System.out.println("�ٽ� �Է����ּ���.");
			} catch (Exception e) {
				sc = new Scanner(System.in);
				System.out.println("�ٽ� �Է����ּ���.");	
			}
		}
		return seat;
	}

	public static void main(String[] args) {
		Subscriber s;
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
					s = new Subscriber();
					s.setSubscriber(k);
					subList.AddSubscriber(s);
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
				sc = new Scanner(System.in);
				System.out.println("�ٽ� �Է����ּ���.");
			}
		}
	}
}
