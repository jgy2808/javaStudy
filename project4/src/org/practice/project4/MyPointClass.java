package org.practice.project4;
import java.io.*;

public class MyPointClass {
	public static class MyPoint{
		private int n1;
		private int n2;
		public MyPoint(int n1, int n2) {
			this.n1 = n1;
			this.n2 = n2;
		}
		public String toString() {
			return "MyPoint(" + n1 + ", " + n2 + ")";
		}
	}
	public static void main(String[] args) {
		MyPoint a = new MyPoint(3, 4);
		System.out.println(a);
	}

}
