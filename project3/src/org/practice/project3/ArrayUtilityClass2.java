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
			for(int i = 0; i < s1.length; i++) {
				for (int j : s2) {
					if (s1[i] == j) {
						s1[i] = 0;
						break;
					}
					else if(j > s1[i]) {
						cnt++;	
						break;
					}
				}
			}
			System.out.println("cnt : " + cnt);
			int arr[] = new int[cnt];
			int k = 0;
			for (int i = 0; i < cnt; i++) {
				for (int j = k; j < s1.length; j++) { 
					if (s1[j] > 0) {
						arr[i] = s1[j];
						k = j + 1;
						break;
					}
				}
			}
			return arr;
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
		}
	}

}
