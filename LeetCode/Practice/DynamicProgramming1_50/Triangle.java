package com.dalai.DynamicProgramming1_50;

/**
 * 
 * @author dalai
 *
 *         dp算法 问题描述：给定一个数字三角形，从顶部到底部的最小路径和。 每一行可以移动到下一行相邻数字上； [2] [3,4] [9,6,8]
 *         [4,1,5,10]
 *
 *         从顶到底部的最小路径和为2+3+6+1=12
 *
 *         解法分析：创建一个等数组素组长都的组数，需要保存最短距离，直接看代码吧，不难。 转移方程：sum[i][j] =max(sum[左孩子],
 *         sum[右孩子]) + a[i][j]；
 */

// 120. Triangle
public class Triangle {

	public static int minSum(int[][] arr) {

		if (arr.length == 0 || arr == null)
			return 0;

		int len = arr.length;
		int[][] array = new int[len][len];
		array[0][0] = arr[0][0];
		for (int i = 1; i < len; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				// 防止数组越界
				int lower = max(0, j - 1);
				int upper = min(j, arr[i - 1].length - 1);

				array[i][j] = min(array[i - 1][lower], array[i - 1][upper]) + arr[i][j];
			}
		}
		int tmp = array[len - 1][0];
		for (int i = 1; i < array[len - 1].length; i++) {

			if (tmp > array[len - 1][i])
				tmp = array[len - 1][i];
		}
		// for (int i = 0; i < array.length; i++)
		// System.out.println(Arrays.toString(array[i]));
		return tmp;
	}

	private static int min(int n1, int n2) {
		return n1 > n2 ? n2 : n1;
	}

	private static int max(int n1, int n2) {
		return n1 > n2 ? n1 : n2;
	}

	public static void main(String[] args) {
		int[][] arr = { { 2 }, { 3, 4 }, { 9, 6, 8 }, { 4, 1, 5, 10 } };
		System.out.println(minSum(arr));
	}
}
