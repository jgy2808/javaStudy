package org.practice.project2;

import java.util.Scanner;

public class ForPracticeSort {
	public static int QuickPartition(int arr[], int left, int right) {
		int pivot = arr[left];
		int low = left + 1;
		int high = right;
		int temp;
		while(low <= high) {
			while(arr[low] <= pivot && low <= right) low++;
			while(arr[high] >= pivot && high >= left + 1) high--;
			if (low <= high) {
				temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp;
			}
		}
		temp = arr[left];
		arr[left] = arr[high];
		arr[high] = temp;
		
		return high;
	}
	
	public static void QuickSort(int arr[], int left, int right) {
		int pivot;
		if (left <= right) {
			pivot = QuickPartition(arr, left, right);
			QuickSort(arr, left, pivot - 1);
			QuickSort(arr, pivot + 1, right);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		System.out.print("두 수 입력 : ");
		for (int i = 0; i < 10; i++) {
			arr[i] = sc.nextInt();
		}
		QuickSort(arr, 0, 9);
		System.out.print("정렬 후 : ");
		for (int i = 0; i < 10; i++) {
			System.out.print(arr[i] + " ");
		}
		
	}

}
