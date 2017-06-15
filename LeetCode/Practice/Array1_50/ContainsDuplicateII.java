package com.dalai.array1_50;

import java.util.HashMap;
import java.util.Map;

/*Given an array of integers and an integer k, 
 * find out whether there are two distinct indices i 
 * and j in the array such that nums[i] = nums[j] 
 * and the absolute difference between i and j is at most k.*/

public class ContainsDuplicateII {

	// 219. Contains Duplicate II

	public boolean containsNearbyDuplicate(int[] nums, int k) {

		if (nums.length <= 0 || nums == null)
			return false;
		int len = nums.length;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < len; i++) {
			if (map.containsKey(nums[i])) {
				if (k >= Math.abs(i - map.get(nums[i]))) {
					return true;
				} else {
					map.put(nums[i], i);
				}
			} else {
				map.put(nums[i], i);
			}
		}
		return false;
	}
}
