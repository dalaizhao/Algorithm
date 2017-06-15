package com.dalai.DynamicProgramming1_50;

/**
 * 
 * @author dalai
 *
 *         动态规划算法
 * 
 *         问题描述：求给定数组中的连续子数组中的最大值 解法分析：问题分成三部分 <1>包含arr[i-1]并且构成最大子数组；
 *         <2>arr[i-1]单独构成最大子数组；
 *         <3>不包含arr[i-1]，那么求arr[1,...,i-1]得最大子数组可以转换为求arr[1,...,i-2]的最大子数组；
 *         end[i-1]是包含arr[i-1]的最大子数组，而all[i-1]为arr[1,...,i-1]的最大子数组
 *         那么可以构造如下关系：all[i-1]=max(end[i-1],arr[i],all[i-2]);
 */
public class MaxSubArray {

	public static int maxSubArr(int[] arr) {
		if (arr.length == 0)
			return Integer.MIN_VALUE;
		int n = arr.length;
		int[] end = new int[n];
		int[] all = new int[n];
		all[n - 1] = arr[n - 1];
		end[n - 1] = arr[n - 1];
		end[0] = all[0] = arr[0];
		for (int i = 1; i < n; i++) {
			end[i] = max(end[i - 1] + arr[i], arr[i]);
			all[i] = max(end[i], all[i - 1]);
		}
		return all[n - 1];
	}

	private static int max(int a1, int a2) {
		return a1 > a2 ? a1 : a2;
	}

	// 优化版本2.0
	// 由于存在空间复杂度O(N)，并且只用到end[i-1]和all[i-1],所以可以用变量来代替；
	public static int maxSubArr2(int[] arr) {
		if (arr.length == 0)
			return Integer.MIN_VALUE;
		int n = arr.length;
		int end = arr[0];
		int all = arr[0];
		for (int i = 1; i < n; i++) {
			end = max(end + arr[i], arr[i]);
			all = max(end, all);
		}
		return all;
	}

	// 改进版本3.0
	// 只要end[i-1]<0就是end[i]=arr[i],所以当end[i-1]<0是重新开始计算下标。
	// 如果需要找到子数组的开始和结束位置
	private static int begin = 0; // 记录最大子数组的启示下标
	private static int end = 0; // 记录最大子数组的结束下标

	public static int maxSubArr3(int[] arr) {

		if (arr.length == 0)
			return Integer.MIN_VALUE;
		int nSum = 0; // 包含子数组的最后一位的最大值
		int maxSum = Integer.MIN_VALUE; // 子数组的最大值
		int nStart = 0;
		for (int i = 0; i < arr.length; i++) {
			if (nSum < 0) {
				nSum = arr[i];
				nStart = i;
			} else {
				nSum += arr[i];
			}
			if (nSum > maxSum) {
				maxSum = nSum;
				begin = nStart;
				end = i;
			}
		}
		return maxSum;
	}

	public static void main(String[] args) {
		int[] arr = { 1, -2, 4, 8, -4, 7, -1, -5 };
		System.out.println(maxSubArr(arr));
		System.out.println(maxSubArr2(arr));
		System.out.println(maxSubArr3(arr) + " begin:" + begin + " end:" + end);
	}
}
