package org.practice.inheritance;

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
		Calc a = new Mul();
		a.setValue(5, 3);
		System.out.println(a.calculate());
	}

}
