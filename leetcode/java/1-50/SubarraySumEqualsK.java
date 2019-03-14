package com.dalai.array1_50;

import java.util.HashMap;
import java.util.Map;

/*Given an array of integers and an integer k, you need to 
 * find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
Note:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] 
and the range of the integer k is [-1e7, 1e7].*/

public class SubarraySumEqualsK {

	// 560. Subarray Sum Equals K
	public int subarraySum(int[] nums, int k) {

		// 运行时间好慢，时间复杂度接近O(n^2)
		// if (nums == null || nums.length == 0) {
		// return 0;
		// }
		// int sum = 0,tmp=k;
		// for (int i = 0, len = nums.length; i < len; i++) {
		// k=tmp;
		// for (int j = i; j < len; j++) {
		// k -= nums[j];
		// if (k == 0) {
		// sum++;
		// }
		// }
		// }
		// return sum;

		if (nums == null || nums.length == 0 || nums.length > 20000) {
			return 0;
		}

		if (k >= 1e7 && k <= -1e7) {
			return 0;
		}

		Map<Integer, Integer> preSum = new HashMap<>();
		preSum.put(0, 1);
		int sum = 0, sol = 0;
		for (int i : nums) {
			sum += i;
			int pre = sum - k;
			if (preSum.containsKey(pre)) {
				sol += preSum.get(pre);
			}
			preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
		}
		return sol;
	}
}
