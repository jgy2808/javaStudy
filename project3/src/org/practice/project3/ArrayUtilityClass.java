package org.practice.project3;

public class ArrayUtilityClass {
	public static class ArrayUtility{
		static double[] intToDouble(int[] source) {
			double[] darr = new double[source.length];
			for(int i = 0; i < source.length; i++) {
				darr[i] = (double)source[i];
			}
			return darr;
		}
		static int[] doubleToInt(double[] source) {
			int[] iarr = new int[source.length];
			for(int i = 0; i < source.length; i++) {
				iarr[i] = (int)source[i];
			}
			return iarr;
		}
	}
	
	public static void main(String[] args) {
		ArrayUtility au = new ArrayUtility();
		int[] iarr = {1, 2, 3, 4, 5};
		double[] darr = {1.0, 2.0, 3.0, 4.0, 5.0};
		int[] doubleToint;
		double[] intTodouble;
		intTodouble = au.intToDouble(iarr);
		doubleToint = au.doubleToInt(darr);
		for (int i= 0; i < intTodouble.length; i++) {
			System.out.print(intTodouble[i] + " ");
		}System.out.println();
		for (int i = 0; i < doubleToint.length; i++) {
			System.out.print(doubleToint[i] + " ");
		}
	}

}
