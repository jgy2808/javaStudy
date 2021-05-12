package org.practice.project3;

import java.util.Scanner;

public class ReservationProject {
	public static class Subscriber {
		Scanner sc = new Scanner(System.in);
		private String name;
		private char seat;
		private int number;

		public void setSubscriber(int n) {
			if (n == 1) {
				seat = 'S';
			} else if (n == 2) {
				seat = 'A';
			} else if (n == 3) {
				seat = 'B';
			}
			System.out.print("이름>>");
			name = sc.next();
			System.out.print("번호>>");
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
	
	public static class SubscriberList{
		Scanner sc = new Scanner(System.in);
		Subscriber[] sList = new Subscriber[10];
		Subscriber[] aList = new Subscriber[10];
		Subscriber[] bList = new Subscriber[10];
		
		public void AddSubscriber(Subscriber s) {
			sList[s.getNumber() - 1] = s;
		}
		
		public void ViewSseat() {
			System.out.print("S>>");
			for (int i = 0; i < sList.length; i++) {
				if (sList[i] == null) System.out.print("□");
				else System.out.print(sList[i].getName());
				if (i < sList.length - 1) System.out.print(" ");
			}System.out.println();
		}
		
		public void ViewAseat() {
			System.out.print("A>>");
			for (int i = 0; i < aList.length; i++) {
				if (aList[i] == null) System.out.print("□");
				else System.out.print(aList[i].getName());
				if (i < aList.length - 1) System.out.print(" ");
			}System.out.println();
		}
		
		public void ViewBseat() {
			System.out.print("B>>");
			for (int i = 0; i < bList.length; i++) {
				if (bList[i] == null) System.out.print("□");
				else System.out.print(bList[i].getName());
				if (i < bList.length - 1) System.out.print(" ");
			}System.out.println();
		}
		
		public void ViewAllSeat() {
			ViewSseat();
			ViewAseat();
			ViewBseat();
			System.out.println("<<<조회를 완료하였습니다.>>>");
		}
		
		public void CancelReserve(int n) {
			String name;
			if (n == 1) { 
				ViewSseat();
				System.out.print("이름>>");
				name = sc.next();
				for (int i = 0; i < sList.length; i++) {
					if (sList[i] != null && sList[i].getName() == name) {
						sList[i] = null;
					}
				}
			}
			else if (n == 2) { ViewAseat(); }
			else if (n == 3) { ViewBseat(); }
			
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Subscriber[] s = new Subscriber[9];
		SubscriberList subList = new SubscriberList();
		int sCount = 0;
		int k;
		while (true) {
			System.out.print("예약<1>, 조회<2>, <취소>, <끝내기> >>");
			int num = sc.nextInt();
			switch (num) {
			case 1:
				while (true) {
					System.out.print("좌석구분 S<1>, A<2>, B<3> >>");
					k = sc.nextInt();
					if (k >= 1 && k <= 3) {
						s[sCount] = new Subscriber();
						s[sCount].setSubscriber(k);
						subList.AddSubscriber(s[sCount]);
						sCount++;
						break;
					}
					else {
						System.out.println("다시 입력해주세요.>>");
					}
				}
				break;
			case 2:
				subList.ViewAllSeat();
				break;
			case 3:
				while (true) {
					System.out.print("좌석구분 S<1>, A<2>, B<3> >>");
					k = sc.nextInt();
					if (k >= 1 && k <= 3) {
						subList.CancelReserve(k);
						break;
					}
					else {
						System.out.println("다시 입력해주세요.>>");
					}
				}
			}
		}
	}
}
