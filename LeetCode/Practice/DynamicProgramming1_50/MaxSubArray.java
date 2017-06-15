package com.dalai.DynamicProgramming1_50;

/**
 * 
 * @author dalai
 *
 *         ��̬�滮�㷨
 * 
 *         ��������������������е������������е����ֵ �ⷨ����������ֳ������� <1>����arr[i-1]���ҹ�����������飻
 *         <2>arr[i-1]����������������飻
 *         <3>������arr[i-1]����ô��arr[1,...,i-1]��������������ת��Ϊ��arr[1,...,i-2]����������飻
 *         end[i-1]�ǰ���arr[i-1]����������飬��all[i-1]Ϊarr[1,...,i-1]�����������
 *         ��ô���Թ������¹�ϵ��all[i-1]=max(end[i-1],arr[i],all[i-2]);
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

	// �Ż��汾2.0
	// ���ڴ��ڿռ临�Ӷ�O(N)������ֻ�õ�end[i-1]��all[i-1],���Կ����ñ��������棻
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

	// �Ľ��汾3.0
	// ֻҪend[i-1]<0����end[i]=arr[i],���Ե�end[i-1]<0�����¿�ʼ�����±ꡣ
	// �����Ҫ�ҵ�������Ŀ�ʼ�ͽ���λ��
	private static int begin = 0; // ��¼������������ʾ�±�
	private static int end = 0; // ��¼���������Ľ����±�

	public static int maxSubArr3(int[] arr) {

		if (arr.length == 0)
			return Integer.MIN_VALUE;
		int nSum = 0; // ��������������һλ�����ֵ
		int maxSum = Integer.MIN_VALUE; // ����������ֵ
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
