package org.practice.inheritance;

import java.util.Scanner;

public class CalculateClass {

	public static abstract class Calc {
		public abstract void setValue(int a, int b);
		public abstract int calculate();
	}

	public static class Add extends Calc {
		private int a;
		private int b;

		public void setValue(int a, int b) {
			this.a = a;
			this.b = b;
		}
		public int calculate() {
			return a + b;
		}
	}

	public static class Sub extends Calc {
		private int a;
		private int b;

		public void setValue(int a, int b) {
			this.a = a;
			this.b = b;
		}
		public int calculate() {
			return a - b;
		}
	}

	public static class Mul extends Calc {
		private int a;
		private int b;

		public void setValue(int a, int b) {
			this.a = a;
			this.b = b;
		}
		public int calculate() {
			return a * b;
		}
	}

	public static class Div extends Calc {
		private int a;
		private int b;

		public void setValue(int a, int b) {
			this.a = a;
			this.b = b;
		}
		public int calculate() {
			return a / b;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b;
		char op;
		System.out.print("두 정수와 연산자 입력>>");
		a = sc.nextInt();
		b = sc.nextInt();
		op = sc.next().charAt(0);
		Calc c;
		switch(op) {
		case '+' :
			c = new Add();
			c.setValue(a, b);
			System.out.println(c.calculate());
			break;
		case '-' :
			c = new Sub();
			c.setValue(a, b);
			System.out.println(c.calculate());
			break;
		case '*' :
			c = new Mul();
			c.setValue(a, b);
			System.out.println(c.calculate());
			break;
		case '/' :
			c = new Div();
			c.setValue(a, b);
			System.out.println(c.calculate());
			break;
		}
	}

}
