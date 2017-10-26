package com.dalai.array1_50;

/*
 * A zero-indexed array A consisting of N different integers is given. 
 * The array contains all integers in the range [0, N - 1].

Sets S[K] for 0 <= K < N are defined as follows:

S[K] = { A[K], A[A[K]], A[A[A[K]]], ... }.

Sets S[K] are finite for each K and should NOT contain duplicates.

Write a function that given an array A consisting of N integers, 
return the size of the largest set S[K] for this array.

Example 1:
Input: A = [5,4,0,3,1,6,2]
Output: 4
Explanation: 
A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.

One of the longest S[K]:
S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
Note:
N is an integer within the range [1, 20,000].
The elements of A are all distinct.
Each element of array A is an integer within the range [0, N-1].
 * */

public class ArrayNesting {

	// 565. Array Nesting
	public int arrayNesting(int[] nums) {

		// 当时测试用例太大，直接栈溢出了
		// if (nums == null || nums.length == 0) {
		// return 0;
		// }
		// List<Integer> numsArrayList = new ArrayList<>();
		// List<Integer> kArr=null;
		// for (int i = 0, len = nums.length; i < len; i++) {
		// kArr = new ArrayList<>();
		// kArr.add(nums[i]);
		// arrayNest(nums, nums[i], kArr);
		// numsArrayList.add(kArr.size());
		// }
		// return Collections.max(numsArrayList);
		// }
		//
		// private void arrayNest(int[] nums, int n, List<Integer> kArr) {
		// if (n >= 0 && n < nums.length) {
		// if (kArr.contains(nums[n])) {
		// return ;
		// }
		// kArr.add(nums[n]);
		// arrayNest(nums, nums[n], kArr);
		// }
		// return;

		int max = Integer.MIN_VALUE;
		byte[] visited = new byte[nums.length];
		for (int i = 0, len = nums.length; i < len; i++) {
			if (visited[i] != 1) {
				max = Math.max(max, calculateLen(nums, i, visited));
			}
		}
		return max;
	}

	private int calculateLen(int[] nums, int s, byte[] visited) {

		int i = s, count = 0;
		while (count == 0 || i != s) {
			visited[i] = 1;
			i = nums[i];
			count++;
		}
		return count;
	}
}
