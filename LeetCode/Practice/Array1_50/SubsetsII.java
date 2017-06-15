package com.dalai.array1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given a collection of integers that might contain duplicates, nums, 
 * return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 * */

public class SubsetsII {

	// 90. Subsets II
	public List<List<Integer>> subsetsWithDup(int[] nums) {

		if (nums == null || nums.length == 0) {
			return null;
		}
		Arrays.sort(nums);
		List<List<Integer>> subSets = new ArrayList<>();
		List<Integer> each = new ArrayList<>();
		subSet(0, subSets, each, nums);
		return subSets;
	}

	private void subSet(int n, List<List<Integer>> subSets, List<Integer> each, int[] nums) {

		if (n <= nums.length) {
			subSets.add(each);
		}
		int i = n;
		while (i < nums.length) {
			each.add(nums[i]);
			subSet(i + 1, subSets, new ArrayList<>(each), nums);
			each.remove(each.size() - 1);
			i++;
			while (i < nums.length && nums[i] == nums[i - 1]) {
				i++;
			}
		}
	}
}
