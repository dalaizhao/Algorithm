package com.dalai.DynamicProgramming1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author dalai
 * 
 *         动态规划算法经典模型之线性模型
 * 
 *         问题描述：有n（n <= 50）个小朋友在桥的这边，现在他们需要过桥， 但是由于桥很窄，每次只允许不大于两人通过，他们只有一个手电筒，
 *         所以每次过桥的两个人需要把手电筒带回来，i号小朋友过桥的时间为T[i]， 两个人过桥的总时间为二者中时间长者。
 *         问所有小朋友过桥的总时间最短是多少 解题分析：最好让时间最短的人把手电筒送回来，所以对所有人按花费时间进行排序。
 *         最后会有两种情况,桥的这边有一个人或有两个人，并且手电筒还在桥的那边。
 *         一个人情况：让时间最短的人送回手电筒，时间应该是:time(i)=time(i-1)+a[1]+a[i];
 *         两个人情况：让时间最短的送回手电，并且让最后俩人先走，时间最短的人等候，再让桥那边的时间
 *         短的送回手电：时间是time(i)=time(i-2)+a[i]+2*a[2];
 *         从这里道出特征方程：time(i)=min(time(i-1)+a[0]+a[i],time(i-2)+a[0]+a[i]+2*a[1]);
 *
 */
public class CrossBridge {

	public static int crossTime(int[] arr) {

		if (arr == null || arr.length == 0)
			return -1;
		Arrays.sort(arr);
		int len = arr.length;
		int[] time = new int[len];
		for (int i = 1; i < len; i++) {
			int i_2 = max(0, i - 2);
			int i_1 = max(0, i - 1);
			time[i] = min(time[i_1] + arr[0] + arr[i], time[i_2] + 2 * arr[1] + arr[i]);
		}
		return time[len - 1];

	}

	public static int max(int n1, int n2) {
		return n1 > n2 ? n1 : n2;
	}

	public static int min(int n1, int n2) {
		return n1 > n2 ? n2 : n1;

	}

	public static void main(String[] args) {

		int[] arr = { 1, 2, 4, 5, 6, 7 };
		System.out.println(crossTime(arr));

		List<List<Integer>> triangle = new ArrayList<>();

		int w = triangle.size();
		int[][] arr1 = new int[w][];

		for (int i = 0; i < w; i++) {
			int len = triangle.get(i).size();
			arr1[i] = new int[len];
			for (int j = 0; j < triangle.get(i).size(); i++) {
				arr1[i][j] = triangle.get(i).get(j);
			}

		}

	}

}
