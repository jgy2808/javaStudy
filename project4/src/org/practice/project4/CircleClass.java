package org.practice.project4;

public class CircleClass {
	public static class Circle{
		private int x;
		private int y;
		private int radius;
		
		public Circle(int x, int y, int ra) {
			this.x = x;
			this.y = y;
			radius = ra;
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
		
		public int getRadius() {
			return radius;
		}

		public void setRadius(int radius) {
			this.radius = radius;
		}

		public void equals(Circle c) {
			if (radius == c.getRadius()) {
				System.out.println("같음");
			}
			else {
				System.out.println("다름");
			}
		}
		
	}

	public static void main(String[] args) {
		Circle c1 = new Circle(2, 4, 10);
		Circle c2 = new Circle(1, 3, 10);
		Circle c3 = new Circle(2, 4, 8);
		c1.equals(c2);
		c1.equals(c3);
	}

}
