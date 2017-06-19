package com.dalai.Array1_50;

import java.util.Arrays;

/*Given an integer array with all positive numbers and no duplicates, 
 * find the number of possible combinations that add up to a positive integer target.

Example:

nums = [1, 2, 3]
target = 4

The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)

Note that different sequences are counted as different combinations.

Therefore the output is 7.

Follow up:
What if negative numbers are allowed in the given array?
How does it change the problem?
What limitation we need to add to the question to allow negative numbers?*/

//377. Combination Sum IV
public class CombinationSumIV {

	// 纯递归实现，可以成功，但是leetcode显示超时了。
	// public int combinationSum4(int[] nums, int target) {
	//
	// if (nums == null || nums.length == 0 || target < 0)
	// return 0;
	//
	// return combinationSum(nums, target);
	// }
	//
	// private int combinationSum(int[] nums, int target) {
	//
	// if (target < 0)
	// return 0;
	// if (target == 0)
	// return 1;
	// int sum = 0;
	// for (int i = 0, len = nums.length; i < len; i++) {
	// sum += combinationSum(nums, target - nums[i]);
	// }
	// return sum;
	// }

	// 动态规划实现，7ms 自下而上的解决方法，慢
	public int combinationSum4(int[] nums, int target) {
		if (nums == null || nums.length == 0 || target < 0)
			return 0;

		int[] comb = new int[target + 1];
		comb[0] = 1;
		for (int i = 1, len = comb.length; i < len; i++) {
			for (int j = 0, len2 = nums.length; j < len2; j++) {
				if (i - nums[j] >= 0) {
					comb[i] += comb[i - nums[j]];
				}
			}
		}

		return comb[target];
	}

	// 更快1ms，解决方案是自上而下的。
	private int[] dp;

	public int combinationSum4_2(int[] nums, int target) {
		dp = new int[target + 1];
		Arrays.fill(dp, -1);
		dp[0] = 1;
		return helper(nums, target);
	}

	private int helper(int[] nums, int target) {
		if (dp[target] != -1) {
			return dp[target];
		}
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			if (target >= nums[i]) {
				res += helper(nums, target - nums[i]);
			}
		}
		dp[target] = res;
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		System.out.println(new CombinationSumIV().combinationSum4(nums, 4));
	}
}
