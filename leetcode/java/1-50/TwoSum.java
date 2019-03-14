package com.dalai.array1_50;

import java.util.HashMap;
import java.util.Map;

/*Given an array of integers, return indices of the two numbers 
 such that they add up to a specific target.

You may assume that each input would have exactly one solution, 
and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].*/

public class TwoSum {

	// 1. Two Sum
	public int[] twoSum(int[] nums, int target) {

		if (nums.length == 0 || nums == null)
			return new int[2];
		int len = nums.length;

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < len; i++) {
			if (map.containsKey(target - nums[i])) {
				return new int[] { i, map.get(target - nums[i]) };
			} else {
				map.put(nums[i], i);
			}
		}

		return new int[2];
	}

}
