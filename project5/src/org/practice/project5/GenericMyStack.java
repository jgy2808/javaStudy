package org.practice.project5;

import java.util.*;

interface Stack<T>{
	public T pop();
	public boolean push(T ob);
}

class MyStack<T> implements Stack<T>{
	LinkedList<T> ll = new LinkedList<T>();
	public T pop() {
		T temp;
		temp = ll.removeLast();
		return temp;
	}
	public boolean push(T ob) {
		return ll.add(ob);
	}
}

public class GenericMyStack {
	
	public static void main(String[] args) {
		MyStack<Integer> ms = new MyStack<Integer>();
		ms.push(1);
		ms.push(2);
		ms.push(3);
		System.out.println(ms.pop());
		System.out.println(ms.pop());
		System.out.println(ms.pop());
	}
}