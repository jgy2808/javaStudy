package org.practice.inheritance;

import java.util.Scanner;

public class DObjectClass {
	public static abstract class DObject {
		protected abstract void draw();
	}

	public static class Line extends DObject {
		public void draw() {
			System.out.println("Line");
		}
	}

	public static class Rect extends DObject {
		public void draw() {
			System.out.println("Rect");
		}
	}

	public static class Circle extends DObject {
		public void draw() {
			System.out.println("Circle");
		}
	}

	public static void main(String[] args) {
		DObject[] d = new DObject[10];
		Scanner sc = new Scanner(System.in);
		int sw, DCount = 0;
		while (true) {
			try {
				System.out.print("����<1>, ����<2>, ��� ����<3>, ����<4> >>");
				sw = sc.nextInt();
				switch (sw) {
				case 1:
					System.out.print("���� ���� Line<1>, Rect<2>, Circle<3> >>");
					sw = sc.nextInt();
					switch(sw) {
					case 1:
						d[DCount++] = new Line();
						break;
					case 2:
						d[DCount++] = new Rect();
						break;
					case 3:
						d[DCount++] = new Circle();
						break;
					}
					break;
				case 2:
					System.out.print("������ ������ ��ġ>>");
					sw = sc.nextInt();
					if (sw >= 1 && sw <= DCount) {
						for (int i = sw - 1; i < DCount - 1; i++) {
							d[i] = d[i + 1];
						}
						DCount--;
					} else {
						System.out.println("������ �� �����ϴ�.");
					}
					break;
				case 3:
					for (int i = 0; i < DCount; i++) {
						d[i].draw();
					}
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