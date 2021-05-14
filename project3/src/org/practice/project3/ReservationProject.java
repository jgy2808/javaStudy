package org.practice.project3;

import java.util.Scanner;

public class ReservationProject {
	public static final int NUM_SEATTYPE = 3;
	public static final int NUM_MAX_SEAT= 10;
	static Scanner sc = new Scanner(System.in);
	
	public enum SEAT_TYPE { S, A, B };

	public static int ChoiceSeat() {
		int seat;
		System.out.print("�¼����� S<1>, A<2>, B<3> >>");
		seat = sc.nextInt();
		return seat - 1;
	}
	
	public static class Subscriber {
		private String name;
		private int seat;
		private int number;

		public void setSubscriber() {
			seat = ChoiceSeat();
			System.out.print("�̸�>>");
			name = sc.next();
			System.out.print("��ȣ>>");
			number = sc.nextInt();
		}

		public String getName() {
			return name;
		}

		public int getSeat() {
			return seat;
		}

		public int getNumber() {
			return number - 1;
		}
	}

	public static class SubscriberList {
		private Subscriber s;
		private Subscriber[][] list = new Subscriber[NUM_SEATTYPE][];

		public SubscriberList() {
			for (int i = 0; i < NUM_SEATTYPE; i++) {
				list[i] = new Subscriber[NUM_MAX_SEAT];
				for (int j = 0; j < NUM_MAX_SEAT; j++) {
					list[i][j] = new Subscriber();
				}
			}
		}

		public void AddSubscriber() {
			s = new Subscriber();
			s.setSubscriber();
			if (s.getNumber() == list[s.getSeat()][s.getNumber()].getNumber()) {
				System.out.println("�̹� �ִ� �¼��Դϴ�.");
				return;
			}
			list[s.getSeat()][s.getNumber()] = s;
		}

		public void Viewseat(int seattype) {
			System.out.print(SEAT_TYPE.values()[seattype] + ">>");

			for (int i = 0; i < NUM_MAX_SEAT; i++) {
				System.out.print((i + 1) + ". ");
				if (list[seattype][i].getName() == null)
					System.out.print("_");
				else
					System.out.print(list[seattype][i].getName());
				if (i < NUM_MAX_SEAT - 1) System.out.print(" ");
			}
			System.out.println();
		}

		public void ViewAllSeat() {
			for (int i = 0; i < NUM_SEATTYPE; i++) {
				Viewseat(i);
			}
		}

		public boolean IsAllNull(int seattype) {
			for (int i = 0; i < NUM_MAX_SEAT; i++) {
				if (list[seattype][i].getName() != null)
					return false;
			}
			return true;
		}

		public int CancelReserve(int sC) {
			int num;
			int seattype = ChoiceSeat();
			Viewseat(seattype);
			if (IsAllNull(seattype)) {
				System.out.println("�ش� �¼� Ÿ���� �¼��� ��� ����ֽ��ϴ�.");
			}
			// -- �̸� ���� ��ȣ �Է��ؼ� ���� ����ϱ� -> �������� ���� �� ���� --
			System.out.print("��ȣ>>");
			num = sc.nextInt();
			if (list[seattype][num - 1].getName() == null) {
				System.out.println("�ش� �¼��� ����ֽ��ϴ�.");
			}
			else {
				list[seattype][num - 1] = new Subscriber();
				System.out.println("�¼� ������ ��ҵǾ����ϴ�.");
				return sC - 1;
			}
			return sC;
		}
	}

	public static void main(String[] args) {
		SubscriberList subList = new SubscriberList();
		int subscriberCount = 0;
		int num = 0, k;
		while (true) {
			try {
				System.out.print("����<1>, ��ȸ<2>, ���<3>, ������<4> >>");
				num = sc.nextInt();
				switch (num) {
				case 1:
					subList.ViewAllSeat();
					if (subscriberCount == 30) {
						System.out.print("��� �¼��� �� á���ϴ�.");
						break;
					}
					subList.AddSubscriber();
					subscriberCount++;
					break;
				case 2:
					subList.ViewAllSeat();
					System.out.println("<<<��ȸ�� �Ϸ��Ͽ����ϴ�.>>>");
					break;
				case 3:
					subscriberCount = subList.CancelReserve(subscriberCount);
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
