package com.dalai.DynamicProgramming1_50;

/**
 * 
 * @author dalai
 * 
 *         动态规划算法之递推
 *
 *         问题描述：在一个3 X N的长方形方格中，铺满1X2的骨牌（骨牌个数不限制），给定N，求方案数。
 * 
 *         解法分析：以下是状态方程 f[i][0] = f[i-2][0] + f[i-1][1] + f[i-2][2] f[i][1] =
 *         f[i-1][2] f[i][2] = f[i][0] + f[i-1][1] 边界条件 f[0][0] = f[1][1] =
 *         f[0][2] = 1
 * 
 *         返回值f[n-1][0]，因为f[i-1][1,2]是后f[i][0]计算的基础;
 */

public class Dominoes {

	public static int count(int n) {

		if (n < 1 || n % 2 != 0)
			return -1;
		int[][] f = new int[n][3];
		f[0][0] = f[1][1] = f[0][2] = 1;
		for (int i = 0; i < n; i++) {
			// 防止数组越界
			int i_2 = max(0, i - 2);
			int i_1 = max(0, i - 1);
			// 状态方程
			if (i != 0)
				f[i][0] = f[i_2][0] + f[i_1][1] + f[i_2][2];
			if (i != 1)
				f[i][1] = f[i_1][2];
			if (i != 0)
				f[i][2] = f[i][0] + f[i_1][1];
		}

		return f[n - 1][0];

	}

	private static int max(int n1, int n2) {
		return n1 > n2 ? n1 : n2;
	}

	public static void main(String[] args) {

		System.out.println(count(4));
	}

}
