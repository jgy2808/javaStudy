package org.practice.project5;
import java.util.*;

class MyClass<T>{
	private T s;
	public MyClass(T s) {
		this.s = s;
	}
	public T getS() {
		return s;
	}
	public void setS(T s) {
		this.s = s;
	}
}

public class PracticeGenericClass {

	public static void main(String[] args) {
		MyClass<String> s = new MyClass<String>("This is String");
		MyClass<Integer> i = new MyClass<Integer>(50);
		MyClass<Double> d = new MyClass<Double>(3.14);
		System.out.println(s.getS());
		System.out.println(i.getS());
		System.out.println(d.getS());

	}

}
