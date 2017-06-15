package com.dalai.array1_50;

/*Given a binary array, find the maximum number of consecutive 1s in this array.

Example 1:
Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.
Note:

The input array will only contain 0 and 1.
The length of input array is a positive integer and will not exceed 10,000*/

public class MaxConsecutiveOnes {

	// 485.Max Consecutive Ones

	public int findMaxConsecutiveOnes(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}
		int maxCount = 0, tmpCount = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1 && tmpCount >= 0) {
				tmpCount++;
			} else {
				if (tmpCount > maxCount)
					maxCount = tmpCount;
				tmpCount = 0;
			}
		}

		return maxCount > tmpCount ? maxCount : tmpCount;
	}
}
