package org.practice.project5;

import java.util.Iterator;
import java.util.Vector;

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
	}
	public void view() {
		System.out.println(getX() + ", " + getY() + " -> " + getW() + ", " + getH() + "의 사각형");
	}
	
}

class Line extends GraphicObject {

	Line(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	public void view() {
		System.out.println(getX() + ", " + getY() + " -> " + getW() + ", " + getH() + "의 선");
	}
}

public class GraphicEditor {
	
	Vector<GraphicObject> v = new Vector<GraphicObject>();
	void add(GraphicObject ob) {
		v.add(ob);
	}
	void draw() {
		Iterator<GraphicObject> it = v.iterator();
		while(it.hasNext()) {
			it.next().view();
		}
	}
	
	public static void main(String[] args) {
		GraphicEditor g = new GraphicEditor();
		g.add(new Rect(2, 2, 3, 4));
		g.add(new Line(3, 3, 8, 8));
		g.add(new Line(2, 5, 6, 6));
		g.draw();
	}

}
