package org.practice.inheritance;

public class MyPointOverridding {
	public static abstract class MyPoint{
		private int x, y;
		public MyPoint(int x, int y) {
			this.x = x;
			this.y = y;
		}
		protected abstract void move(int x, int y);
		protected abstract void reverse();
		protected void show() {
			System.out.println(x + ", " + y);
		}
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		
	}
	public static class MyColorPoint extends MyPoint{
		private String c;
		public MyColorPoint(int x, int y, String c) {
			super(x, y);
			this.c = c;
		}
		public void move(int x, int y) {
			setX(x);
			setY(y);
		}
		public void reverse() {
			int temp = getX();
			setX(getY());
			setY(temp);
		}
		public void show() {
			System.out.println(getX() + ", " + getY() + ", " + c);
		}
	}
	public static void main(String[] args) {
		MyPoint p = new MyColorPoint(2, 3, "blue");
		p.move(3, 4);
		p.reverse();
		p.show();
	}

}
