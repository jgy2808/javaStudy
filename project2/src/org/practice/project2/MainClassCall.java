package org.practice.project2;
public class MainClassCall {

	public static void main(String[] args) {
		int sum = 0, n, sw = 0;
		for (int i = 0; i < args.length; i++) {
			sw = 1;
			for (int j = 0; j < args[i].length(); j++) {
				if (args[i].charAt(j) < '0' || args[i].charAt(j) > '9') {
					sw = 0; 
					 break;
				}
			}
			if (sw == 1) {
				n = Integer.parseInt(args[i]);
				sum += n;
			}
		}
		System.out.println(sum);
	}

}
