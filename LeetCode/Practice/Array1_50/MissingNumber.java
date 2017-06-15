package com.dalai.array1_50;

/*Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, 
 * find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. 
Could you implement it using only constant extra space complexity?*/

public class MissingNumber {

	// 268. Missing Number
	public int missingNumber(int[] nums) {

		byte[] arr = new byte[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			arr[nums[i]] = 1;
		}
		for (int i = 0; i <= nums.length; i++) {
			if (arr[i] != 1)
				return i;
		}

		return 0;
	}
}
