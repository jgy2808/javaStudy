package org.practice.project4;

public class StringQueryClass {

	public static void main(String[] args) {
		String key = "";
		String val = "";
		boolean iskey = true;
		boolean isval = false;
		for (int i = 0; i < args[0].length(); i++) {
			if (args[0].charAt(i) != '=' && iskey) {
				key = key + String.valueOf(args[0].charAt(i));
			}
			else if (args[0].charAt(i) == '='){
				iskey = false;
				isval = true;
			}
			else if (args[0].charAt(i) != '&' && isval) {
				val = val + String.valueOf(args[0].charAt(i));
			}
			if (args[0].charAt(i) == '&' || i == args[0].length()-1){
				isval = false;
				iskey = true;
				System.out.printf("%s\t%s", key, val);
				System.out.println();
				key = "";
				val = "";
			}
		}
	}
}
