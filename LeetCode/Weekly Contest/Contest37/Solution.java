package com.dalai.Contest37;

import java.util.*;
import java.util.Map.Entry;

public class Solution {

	/*
	 * Given m arrays, and each array is sorted in ascending order. Now you can
	 * pick up two integers from two different arrays (each array picks one) and
	 * calculate the distance. We define the distance between two integers a and
	 * b to be their absolute difference |a-b|. Your task is to find the maximum
	 * distance.
	 * 
	 * Example 1: Input: [[1,2,3], [4,5], [1,2,3]] Output: 4 Explanation: One
	 * way to reach the maximum distance 4 is to pick 1 in the first or third
	 * array and pick 5 in the second array.
	 */

	// 624. Maximum Distance in Arrays
	public int maxDistance(int[][] arrays) {

		if (arrays == null || arrays.length == 0)
			return 0;

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int result = 0;
		for (int i = 0, len = arrays.length; i < len; i++) {
			if (arrays[i].length == 0)
				continue;
			int currentMIn = arrays[i][0];
			int currentMax = arrays[i][arrays[i].length - 1];

			if (min != Integer.MAX_VALUE) {
				result = Math.max(result, Math.abs(min - currentMax));
				result = Math.max(result, Math.abs(max - currentMIn));

				min = Math.min(currentMIn, min);
				max = Math.max(currentMax, max);

			} else {
				min = currentMIn;
				max = currentMax;
			}
		}
		return result;
	}

	/*
	 * Given the root of a binary tree, then value v and depth d, you need to
	 * add a row of nodes with value v at the given depth d. The root node is at
	 * depth 1.
	 * 
	 * The adding rule is: given a positive integer depth d, for each NOT null
	 * tree nodes N in depth d-1, create two tree nodes with value v as N's left
	 * subtree root and right subtree root. And N's original left subtree should
	 * be the left subtree of the new left subtree root, its original right
	 * subtree should be the right subtree of the new right subtree root. If
	 * depth d is 1 that means there is no depth d-1 at all, then create a tree
	 * node with value v as the new root of the whole original tree, and the
	 * original tree is the new root's left subtree.
	 * 
	 * Example 1: Input: A binary tree as following: 4 / \ 2 6 / \ / 3 1 5
	 * 
	 * v = 1
	 * 
	 * d = 2
	 * 
	 * Output: 4 / \ 1 1 / \ 2 6 / \ / 3 1 5
	 */

	// 623. Add One Row to Tree
	public TreeNode addOneRow(TreeNode root, int v, int d) {

		if (d < 1) {
			return null;
		}
		if (d == 1) {
			TreeNode tmpRoot = new TreeNode(v);
			tmpRoot.left = root;
			return tmpRoot;
		}

		addOne(root, root.left, v, d - 1);
		addOne(root, root.right, v, d - 1);

		return root;
	}

	private void addOne(TreeNode parent, TreeNode root, int v, int d) {

		if (root == null && d != 1)
			return;
		if (d == 1) {
			TreeNode tmp = new TreeNode(v);
			if (parent.left == root) {
				tmp.left = root;
				parent.left = tmp;
				return;
			} else {
				tmp.right = root;
				parent.right = tmp;
				return;
			}
		} else {
			addOne(root, root.left, v, d - 1);
			addOne(root, root.right, v, d - 1);
		}
	}

	/*
	 * Given a positive integer a, find the smallest positive integer b whose
	 * multiplication of each digit equals to a.
	 * 
	 * If there is no answer or the answer is not fit in 32-bit signed integer,
	 * then return 0.
	 * 
	 * Example 1 Input:
	 * 
	 * 48 Output: 68 Example 2 Input:
	 * 
	 * 15 Output: 35
	 */

	// 625. Minimum Factorization
	public int smallestFactorization(int a) {

		if (a < 0)
			return 0;
		if (a == 1)
			return 1;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 9; i > 1; i--) {
			int num = 0;
			while (a % i == 0) {
				a /= i;
				num++;
			}
			if (num > 0)
				map.put(i, num);
		}

		if (a > 1) {
			return 0;
		} else {
			StringBuilder stringBuilder = new StringBuilder();

			for (Entry<Integer, Integer> each : map.entrySet()) {
				for (int i = 0; i < each.getValue(); i++) {
					stringBuilder.append(each.getKey());
				}
			}
			if (stringBuilder.length() > 12) {
				return 0;
			} else {
				long number = Long.parseLong(stringBuilder.toString());
				if (number < Integer.MAX_VALUE) {
					return (int) number;
				} else {
					return 0;
				}
			}

		}
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	/*
	 * Given a char array representing tasks CPU need to do. It contains capital
	 * letters A to Z where different letters represent different tasks.Tasks
	 * could be done without original order. Each task could be done in one
	 * interval. For each interval, CPU could finish one task or just be idle.
	 * 
	 * However, there is a non-negative cooling interval n that means between
	 * two same tasks, there must be at least n intervals that CPU are doing
	 * different tasks or just be idle.
	 * 
	 * You need to return the least number of intervals the CPU will take to
	 * finish all the given tasks.
	 * 
	 * Example 1: Input: tasks = ['A','A','A','B','B','B'], n = 2 Output: 8
	 * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B. Note: The number
	 * of tasks is in the range [1, 10000].
	 */

	// 两个版本，思想差不多，先统计字符数字，再计算。
	// 第一个版本是用map统计，再转换成数组，确实比较慢。
	// 第二个版本是用位图法，数组下标就是字符Ascii码值-A的值，确实比第一个版本快。

	// 621. Task Scheduler
	public int leastInterval(char[] tasks, int n) {

		if (tasks == null || tasks.length == 0 || n < 0)
			return 0;
		if (n == 0)
			return tasks.length;

		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0, len = tasks.length; i < len; i++) {

			if (map.containsKey(tasks[i])) {
				map.put(tasks[i], map.get(tasks[i]) + 1);
			} else {
				map.put(tasks[i], 1);
			}
		}

		List<Integer> list = new ArrayList<>(map.values());
		int len = map.size();
		int[] arr = new int[len];
		listToInt(list, arr);
		Arrays.sort(arr);

		int time = 0;
		int tmp = 0;

		for (int num = 0, count = 0; num < len;) {

			for (int i = len - 1; i >= num && count < n + 1; i--) {
				arr[i]--;
				count++;
				time++;
			}
			Arrays.sort(arr);
			while (num < len && arr[num] == 0) {
				num++;
			}
			if (count < n + 1 && count != 0 && num < len) {
				tmp = n + 1 - count;
				time += tmp;
			}
			count = 0;
		}

		return time;
	}

	private void listToInt(List<Integer> list, int[] arr) {

		if (list == null || arr == null || list.size() != arr.length) {
			return;
		}
		int index = 0;
		for (Integer i : list) {
			arr[index++] = i;
		}
	}

	public int leastInterval2(char[] tasks, int n) {
		int[] task_count = new int[26];
		for (int i = 0; i < tasks.length; i++) {
			task_count[tasks[i] - 'A'] += 1;
		}
		int count = -1;
		int res = 0;
		Arrays.sort(task_count);
		if (task_count[25] != 0) {

			res = (task_count[25] - 1) * (n + 1);

			for (int j = 25; j >= 0; j--) {
				if (count < n) {
					if (task_count[j] == task_count[25]) {
						res += 1;
						count++;

					}
				} else {

					res += task_count[j];

				}
			}

		}
		return res;
	}

	public static void main(String[] args) {

		char[] arr = { 'A', 'A', 'A', 'B', 'B', 'B' };
		System.out.println(new Solution().leastInterval(arr, 2));

	}
}
