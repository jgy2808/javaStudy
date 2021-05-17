package org.practice.inheritance;

public class StackInterface {
	interface Stack{
		public abstract int length();
		public abstract Object pop();
		boolean push(Object ob);
	}
	public static class StringStack implements Stack {
		private String str = "";
		public int length() {
			return str.length();
		}
		public Object pop() {
			char c = str.charAt(length() - 1);
			str = str.substring(0, length() - 1);
			return c;
		}
		public boolean push(Object ob) {
			if (ob.getClass() == str.getClass()) {
				str = str.concat(ob.toString());
				return true;
			}
			return false;
		}
	}
	public static void main(String[] args) {
		StringStack ss = new StringStack();
		ss.push("hello");
		int len = ss.length();
		for (int i = 0; i < len; i++) {
			System.out.println(ss.pop());
		}
		
	}

}
