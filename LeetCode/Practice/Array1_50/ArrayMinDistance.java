package com.dalai.array1_50;

/**
 * 
 * @author dalai
 * 
 *         找到两个数字在给定的数组中找到最近的距离
 *
 */

public class ArrayMinDistance {

	public static int minDis(int[] arr, int n1, int n2) {

		int n1_index = Integer.MIN_VALUE;
		int n2_index = Integer.MIN_VALUE;
		int distance = Integer.MAX_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == n1) {
				n1_index = i;
				if (n1_index != Integer.MIN_VALUE && n2_index != Integer.MIN_VALUE) {
					if (distance > Math.abs(n1_index - n2_index)) {
						distance = Math.abs(n1_index - n2_index);
					}
				}
			}
			if (arr[i] == n2) {
				n2_index = i;
				if (n1_index != Integer.MIN_VALUE && n2_index != Integer.MIN_VALUE) {
					if (distance > Math.abs(n1_index - n2_index)) {
						distance = Math.abs(n1_index - n2_index);
					}
				}
			}
		}
		return distance;
	}

	public static void main(String[] args) {
		int[] arr = { 4, 5, 6, 4, 7, 4, 6, 4, 7, 8, 5, 6, 4, 3, 10, 8 };
		System.out.println(minDis(arr, 4, 8));
	}
}
