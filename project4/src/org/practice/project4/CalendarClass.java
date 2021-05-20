package org.practice.project4;

import java.util.Calendar;

public class CalendarClass {

	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();
		System.out.println(now.getTime().getHours());
		if (now.getTime().getHours() >= 4 && now.getTime().getHours() < 12) {
			System.out.println("Good Morning!");
		}
		else if (now.getTime().getHours() < 18) {
			System.out.println("Good Afternoon!");
		}
		else if (now.getTime().getHours() < 22 ){
			System.out.println("Good Evening!");
		}
		else {
			System.out.println("Good Night!");
		}
		

	}

}
