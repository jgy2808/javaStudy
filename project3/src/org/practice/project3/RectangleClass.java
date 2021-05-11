package org.practice.project3;

public class RectangleClass {
	
	public static class Rectangle{
		private int x1;
		private int y1;
		private int x2;
		private int y2;
		
		Rectangle(){
			x1 = 0; y1 = 0; x2 = 0; y2 = 0;
		}
		Rectangle(int x1, int y1, int x2, int y2){
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}
		void set(int x1, int y1, int x2, int y2) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}
		int Square() {
			return (x2 - x1) * (y2 - y1);
		}
		void Show() {
			System.out.println("x1 : " + x1);
			System.out.println("y1 : " + y1);
			System.out.println("x2 : " + x2);
			System.out.println("y2 : " + y2);
			System.out.println("넓이 : " + Square());
		}
		boolean equals(Rectangle r) {
			if (r.x1 == x1 && r.y1 == y1 && r.x2 == x2 && r.y2 == y2){
				return true;
			}
			else return false;
		}
	}

	public static void main(String[] args) {
		Rectangle r = new Rectangle();
		Rectangle s = new Rectangle(1, 1, 2, 3);
		
		r.Show();
		s.Show();
		System.out.println(s.Square());
		r.set(-2, 2, -1, 4);
		r.Show();
		System.out.println(r.Square());
		if (r.equals(s)) {
			System.out.println("두 사각형은 같습니다");
		}
	}

}
