package com.dalai.DynamicProgramming1_50;

/**
 * 
 * @author dalai
 *
 *         dp�㷨 ��������������һ�����������Σ��Ӷ������ײ�����С·���͡� ÿһ�п����ƶ�����һ�����������ϣ� [2] [3,4] [9,6,8]
 *         [4,1,5,10]
 *
 *         �Ӷ����ײ�����С·����Ϊ2+3+6+1=12
 *
 *         �ⷨ����������һ�����������鳤������������Ҫ������̾��룬ֱ�ӿ�����ɣ����ѡ� ת�Ʒ��̣�sum[i][j] =max(sum[����],
 *         sum[�Һ���]) + a[i][j]��
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
				// ��ֹ����Խ��
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
