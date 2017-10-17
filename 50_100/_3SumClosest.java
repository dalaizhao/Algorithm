package com.dalai.par;

import java.util.Arrays;

import javax.imageio.ImageTypeSpecifier;

public class _3SumClosest {

	/*
	 * Given an array S of n integers, find three integers in S such that the sum is
	 * closest to a given number, target. Return the sum of the three integers. You
	 * may assume that each input would have exactly one solution.
	 * 
	 * For example, given array S = {-1 2 1 -4}, and target = 1.
	 * 
	 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
	 */

	public int threeSumClosest(int[] nums, int target) {

		if (nums == null || nums.length <= 0)
			return 0;

		int res = nums[0] + nums[1] + nums[nums.length - 1];
		Arrays.sort(nums);

		for (int i = 0, len = nums.length; i < len - 2; i++) {
			int start = i + 1, end = len - 1;
			while (start < end) {
				int sum = nums[i] + nums[start] + nums[end];
				if (sum > target) {
					end--;
				} else {
					start++;
				}
				if (Math.abs(sum - target) < Math.abs(res - target)) {
					res = sum;
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {

	}

}
