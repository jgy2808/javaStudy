package org.practice.project4;

public class StringQueryClass {

	public static void main(String[] args) {
		String key = "";
		String val = "";
		boolean iskey = true;
		boolean isval = false;
		for (int i = 0; i < args.length; i++) {
			if (!args[i].equals("=") && iskey) {
				key = key.concat(args[i]);
			}
			else if (args[i].equals("=")){
				iskey = false;
				isval = true;
			}
			if (!args[i].equals("&") && isval) {
				val = val.concat(args[i]);
			}
			else if (args[i].equals("&")){
				isval = false;
				iskey = true;
				System.out.printf("%10s%s", key, val);
				System.out.println();
				key = "";
				val = "";
			}
			
		}

	}

}
