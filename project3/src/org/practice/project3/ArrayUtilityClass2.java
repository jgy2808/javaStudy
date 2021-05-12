package org.practice.project3;

public class ArrayUtilityClass2 {
	public static class ArrayUtility{
		static int[] concat(int[] s1, int[] s2) {
			int[] arr = new int[s1.length + s2.length];
			for (int i = 0; i < s1.length; i++) {
				arr[i] = s1[i];
			}
			for (int i = s1.length; i < s1.length + s2.length; i++) {
				arr[i] = s2[i - s2.length];
			}
			return arr;
		}
		static int[] remove(int[] s1, int[] s2) {
			int cnt = 0;
			int i = 0, j = 0, k = 0;
			int[] temp;
			while(i < s1.length) {
				while(j < s2.length) {
					if (s1[i] == s2[j]) {
						s1[i] = 0;
						cnt++;
						break;
					}
					else if (s1[i] < s2[j]) {
						break;
					}
					j++;
				}
				i++;
			}
			temp = new int[s1.length - cnt];
			for (i = 0; i < s1.length; i++) {
				if (s1[i] > 0) {
					temp[k++] = s1[i];
				}
			}
			return temp;
		}
	}
	public static void main(String[] args) {
		ArrayUtility au = new ArrayUtility();
		int[] s1 = {1, 2, 3, 4, 5};
		int[] s2 = {1, 3, 6, 7, 8};
		System.out.print("concat : ");
		for (int i = 0; i < au.concat(s1, s2).length; i++) {
			System.out.print(au.concat(s1, s2)[i] + " ");
		}System.out.println();

		int[] re = au.remove(s1, s2);
		System.out.print("remove : ");
		for (int i = 0; i < re.length; i++) {
			System.out.print(re[i] + " ");
		}System.out.println();
		
	}

}
