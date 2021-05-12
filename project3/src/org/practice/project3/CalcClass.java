package org.practice.project3;

import java.util.Scanner;

public class CalcClass {
	public static class Add {
		private int a;
		private int b;

		public void setValue(int a, int b) {
			this.a = a;
			this.b = b;
		}

		public int Calculate() {
			return a + b;
		}

	}

	public static class Sub {
		private int a;
		private int b;

		public void setValue(int a, int b) {
			this.a = a;
			this.b = b;
		}

		public int Calculate() {
			return a - b;
		}
	}

	public static class Mul {
		private int a;
		private int b;

		public void setValue(int a, int b) {
			this.a = a;
			this.b = b;
		}

		public int Calculate() {
			return a * b;
		}
	}

	public static class Div {
		private int a;
		private int b;

		public void setValue(int a, int b) {
			this.a = a;
			this.b = b;
		}

		public int Calculate() {
			if (b == 0) {
				return 0;
			}
			return a / b;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 4; i++) {
			System.out.print("두 정수와 연산자 입력 : ");
			int a = sc.nextInt();
			int b = sc.nextInt();
			char c = sc.next().charAt(0);
			switch (c) {
			case '+':
				Add add = new Add();
				add.setValue(a, b);
				System.out.println(add.Calculate());
				break;
			case '-':
				Sub sub = new Sub();
				sub.setValue(a, b);
				System.out.println(sub.Calculate());
				break;
			case '*':
				Mul mul = new Mul();
				mul.setValue(a, b);
				System.out.println(mul.Calculate());
				break;
			case '/':
				Div div = new Div();
				div.setValue(a, b);
				System.out.println(div.Calculate());
				break;
			}
		}

	}

}
