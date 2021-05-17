package org.practice.inheritance;

public class CPointClass {
	public static class CPoint{
		private int a;
		private int b;
		CPoint(int a, int b){
			this.a = a;
			this.b = b;
		}
		public void show() {
			System.out.println("(" + a + ", " + b + ")");
		}
		public void show(String str) {
			System.out.println("(" + a + ", " + b + ")" + str);
		}
		public String toString() {
			return "(" + a + ", " + b + ")¿‘¥œ¥Ÿ";
		}
	}
	public static class CColorPoint extends CPoint{
		private String c;
		CColorPoint(int a, int b, String c){
			super(a, b);
			this.c = c;
		}
		public void show() {
			super.show(c);
		}
	}

	public static void main(String[] args) {
		CPoint a, b;
		
		a = new CPoint(2, 3);
		b = new CColorPoint(3, 4, "red");
		a.show();
		b.show();
		System.out.println(a);
		System.out.println(b);
	}

}
