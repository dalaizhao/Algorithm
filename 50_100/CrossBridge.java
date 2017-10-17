package com.dalai.DynamicProgramming1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author dalai
 * 
 *         ��̬�滮�㷨����ģ��֮����ģ��
 * 
 *         ������������n��n <= 50����С�������ŵ���ߣ�����������Ҫ���ţ� ���������ź�խ��ÿ��ֻ������������ͨ��������ֻ��һ���ֵ�Ͳ��
 *         ����ÿ�ι��ŵ���������Ҫ���ֵ�Ͳ��������i��С���ѹ��ŵ�ʱ��ΪT[i]�� �����˹��ŵ���ʱ��Ϊ������ʱ�䳤�ߡ�
 *         ������С���ѹ��ŵ���ʱ������Ƕ��� ��������������ʱ����̵��˰��ֵ�Ͳ�ͻ��������Զ������˰�����ʱ���������
 *         �������������,�ŵ������һ���˻��������ˣ������ֵ�Ͳ�����ŵ��Ǳߡ�
 *         һ�����������ʱ����̵����ͻ��ֵ�Ͳ��ʱ��Ӧ����:time(i)=time(i-1)+a[1]+a[i];
 *         �������������ʱ����̵��ͻ��ֵ磬����������������ߣ�ʱ����̵��˵Ⱥ��������Ǳߵ�ʱ��
 *         �̵��ͻ��ֵ磺ʱ����time(i)=time(i-2)+a[i]+2*a[2];
 *         ����������������̣�time(i)=min(time(i-1)+a[0]+a[i],time(i-2)+a[0]+a[i]+2*a[1]);
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
