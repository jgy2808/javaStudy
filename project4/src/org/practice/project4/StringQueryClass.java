package org.practice.project4;

public class StringQueryClass {

	public static void main(String[] args) {
		String key = "";
		String val = "";
		String temp = "";
		for (int i = 0; i < args[0].length(); i++) {
			char c = args[0].charAt(i);
			if (c != '=' && c != '&') {
				temp += c;
			}
			else if (c == '=') {
				key = temp;
				temp = "";
			}
			if (c == '&' || i == args[0].length() - 1){
				val = temp;
				temp = "";
				System.out.printf("%s\t%s", key, val);
				System.out.println();
			}
		}
	}
}