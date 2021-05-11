package org.practice.project3;

public class ArrayUtilityClass2 {
	public static class ArrayUtility{
		static int[] concat(int[] s1, int[] s2) {
			int[] arr = new int[s1.length + s2.length];
			arr = s1;
			for (int i = s1.length; i < s2.length; i++) {
				arr[i] = s2[i - s1.length];
			}
			return arr;
		}
		static int[] remove(int[] s1, int[] s2) {
			int arr[];
			arr[0] = 1;
			return arr;
		}
	}
	public static void main(String[] args) {
		
	}

}
