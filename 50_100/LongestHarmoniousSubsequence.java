package com.dalai.par;

import java.util.HashMap;
import java.util.Map;

//594. Longest Harmonious Subsequence
public class LongestHarmoniousSubsequence {

	/*
	 * We define a harmonious array is an array where the difference between its
	 * maximum value and its minimum value is exactly 1.
	 */
	public int findLHS(int[] nums) {

		if (nums == null)
			return 0;
		Map<Integer, Integer> map = new HashMap<>();
		int max = 0;
		for (int i = 0, len = nums.length; i < len; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		for (int key : map.keySet()) {
			if (map.containsKey(key + 1))
				max = Math.max(max, map.get(key) + map.get(key + 1));
		}

		return max;
	}
}
