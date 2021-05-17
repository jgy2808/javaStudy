package org.practice.inheritance;

import java.util.Scanner;

public class PrinterClass {
	static Scanner sc = new Scanner(System.in);

	public static class Printer {
		private String modelName;
		private String make;
		private String interfaceType;
		private int numofprint;
		private int numofavailable;

		public Printer() {
			System.out.print("모델명>>");
			modelName = sc.next();
			System.out.print("제조사>>");
			make = sc.next();
			System.out.print("인터페이스 종류(USB 또는 병렬 인터페이스)>>");
			interfaceType = sc.next();
			numofprint = 1;
			numofavailable = 0;
		}

		public void addPaper(int num) {
			numofavailable += num;
		}

		public int print() {
			if (numofavailable < numofprint) {
				System.out.println("종이 부족");
				return 0;
			}
			numofavailable -= numofprint;
			System.out.println("남은 종이 수>>" + numofavailable);
			return 1;
		}
		public int getnumofprint() {
			return numofprint;
		}
		public int getnumofavailable() {
			return numofavailable;
		}
	}

	public static class InkjetPrinter extends Printer {
		private int ink;
		
		public InkjetPrinter() {
			super();
			ink = 100;
		}
		
		public void addInk() {
			ink = 100;
		}
		
		public void Inkjetprint() {
			if (ink < 5) {
				System.out.println("잉크 부족");
				return;
			}
			super.print();
			if (getnumofavailable() < getnumofprint()) {
				return;
			}
			ink -= getnumofprint() * 5;
			System.out.println("잉크 >>" + ink);
		}
	}
	
	public static class LaserPrinter extends Printer{
		private int toner;
		public LaserPrinter() {
			super();
			toner = 100;
		}
		
		public void addToner() {
			toner = 100;
		}
		
		public void Laserprint() {
			if (toner < 5) {
				System.out.println("토너 부족");
				return;
			}
			if (super.print() ==  0 ) {
				return;
			}
			toner -= getnumofprint() * 5;
			System.out.println("토너 >>" + toner);
		}
	}

	public static void main(String[] args) {
		LaserPrinter lp = new LaserPrinter();
		lp.addPaper(2);
		lp.Laserprint();
		lp.Laserprint();
		lp.Laserprint();
		lp.addPaper(50);
		for (int i = 0; i < 30; i++) {
			lp.Laserprint();
		}
	}

}
