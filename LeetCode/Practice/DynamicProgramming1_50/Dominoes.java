package com.dalai.DynamicProgramming1_50;

/**
 * 
 * @author dalai
 * 
 *         ��̬�滮�㷨֮����
 *
 *         ������������һ��3 X N�ĳ����η����У�����1X2�Ĺ��ƣ����Ƹ��������ƣ�������N���󷽰�����
 * 
 *         �ⷨ������������״̬���� f[i][0] = f[i-2][0] + f[i-1][1] + f[i-2][2] f[i][1] =
 *         f[i-1][2] f[i][2] = f[i][0] + f[i-1][1] �߽����� f[0][0] = f[1][1] =
 *         f[0][2] = 1
 * 
 *         ����ֵf[n-1][0]����Ϊf[i-1][1,2]�Ǻ�f[i][0]����Ļ���;
 */

public class Dominoes {

	public static int count(int n) {

		if (n < 1 || n % 2 != 0)
			return -1;
		int[][] f = new int[n][3];
		f[0][0] = f[1][1] = f[0][2] = 1;
		for (int i = 0; i < n; i++) {
			// ��ֹ����Խ��
			int i_2 = max(0, i - 2);
			int i_1 = max(0, i - 1);
			// ״̬����
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
