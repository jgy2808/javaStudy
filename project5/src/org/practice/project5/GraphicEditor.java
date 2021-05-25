package org.practice.project5;

abstract class GraphicObject{
	private int x;
	private int y;
	private int w;
	private int h;
	GraphicObject(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	public abstract void view();
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getW() {
		return w;
	}
	public int getH() {
		return h;
	}
}

class Rect extends GraphicObject{

	Rect(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void view() {
		System.out.println(getX() + ", " + getY() + " -> " + getW() + ", " + getH() + "의 사각형");
	}
	
}

class Line extends GraphicObject {

	Line(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}
	public void view() {
		System.out.println(getX() + ", " + getY() + " -> " + getW() + ", " + getH() + "의 선");
	}
}

public class GraphicEditor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
