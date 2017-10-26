package com.dalai.par;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 15. 3  sum
public class _3Sum {

	/*
	 * Given an array S of n integers, are there elements a, b, c in S such that a +
	 * b + c = 0? Find all unique triplets in the array which gives the sum of zero.
	 * 
	 * Note: The solution set must not contain duplicate triplets.
	 * 
	 * For example, given array S = [-1, 0, 1, 2, -1, -4],
	 * 
	 * A solution set is: [ [-1, 0, 1], [-1, -1, 2] ]
	 */

	public List<List<Integer>> threeSum(int[] nums) {

		if (nums == null || nums.length < 0)
			return null;

		List<List<Integer>> list = new ArrayList<>();

		if (nums.length < 3)
			return list;

		Arrays.sort(nums);

		for (int i = 0, len = nums.length; i + 2 < len; i++) {

			if (nums[i] > 0)
				break;

			if (i > 0 && nums[i] == nums[i - 1]) { // skip same result
				continue;
			}

			int target = -nums[i];

			int j = i + 1, k = len - 1;
			while (j < k) {

				if (target == (nums[j] + nums[k])) {
					list.add(Arrays.asList(nums[i], nums[j], nums[k]));

					j++;
					k--;

					while (j < k && nums[j] == nums[j - 1])
						j++;
					while (j < k && nums[k] == nums[k + 1])
						k--;
				} else if (target < (nums[j] + nums[k])) {
					k--;
				} else {
					j++;
				}
			}
		}

		return list;
	}

	public static void main(String[] args) {

	}

}
