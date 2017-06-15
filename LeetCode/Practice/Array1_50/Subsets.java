package com.dalai.array1_50;

import java.util.ArrayList;
import java.util.List;

/*Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
Subscribe to see which companies asked this question.*/

public class Subsets {

	// 78. Subsets
	public List<List<Integer>> subsets(int[] nums) {

		if (nums == null || nums.length == 0)
			return null;
		List<List<Integer>> subSets = new ArrayList<>();
		List<Integer> each = new ArrayList<>();
		subset(0, subSets, each, nums);
		return subSets;
	}

	private void subset(int n, List<List<Integer>> subSets, List<Integer> each, int[] nums) {

		if (n <= nums.length) {
			subSets.add(each);
		}
		for (int i = n, len = nums.length; i < len; i++) {
			each.add(nums[i]);
			subset(++n, subSets, new ArrayList<>(each), nums);
			each.remove(each.size() - 1);
		}
	}

}
