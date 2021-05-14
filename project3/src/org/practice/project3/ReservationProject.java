package org.practice.project3;

import java.util.Scanner;

public class ReservationProject {
	public static final int NUM_SEATTYPE = 3;
	public static final int NUM_MAX_SEAT= 10;
	static Scanner sc = new Scanner(System.in);
	
	public enum SEAT_TYPE { S, A, B };

	public static int ChoiceSeat() {
		int seat;
		System.out.print("좌석구분 S<1>, A<2>, B<3> >>");
		seat = sc.nextInt();
		return seat - 1;
	}
	
	public static class Subscriber {
		private String name;
		private int seat;
		private int number;

		public void setSubscriber() {
			seat = ChoiceSeat();
			System.out.print("이름>>");
			name = sc.next();
			System.out.print("번호>>");
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
				System.out.println("이미 있는 좌석입니다.");
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
				System.out.println("해당 좌석 타입의 좌석이 모두 비어있습니다.");
			}
			// -- 이름 말고 번호 입력해서 예약 취소하기 -> 동명이인 있을 수 있음 --
			System.out.print("번호>>");
			num = sc.nextInt();
			if (list[seattype][num - 1].getName() == null) {
				System.out.println("해당 좌석은 비어있습니다.");
			}
			else {
				list[seattype][num - 1] = new Subscriber();
				System.out.println("좌석 예약이 취소되었습니다.");
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
				System.out.print("예약<1>, 조회<2>, 취소<3>, 끝내기<4> >>");
				num = sc.nextInt();
				switch (num) {
				case 1:
					subList.ViewAllSeat();
					if (subscriberCount == 30) {
						System.out.print("모든 좌석이 꽉 찼습니다.");
						break;
					}
					subList.AddSubscriber();
					subscriberCount++;
					break;
				case 2:
					subList.ViewAllSeat();
					System.out.println("<<<조회를 완료하였습니다.>>>");
					break;
				case 3:
					subscriberCount = subList.CancelReserve(subscriberCount);
					break;
				case 4:
					return;
				}
			} catch (Exception e) {
				sc = new Scanner(System.in);
				System.out.println("다시 입력해주세요.");
			}
		}
	}
}
