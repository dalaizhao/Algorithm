package com.dalai.array1_50;

/*Given an array with n objects colored red, white or blue, 
 * sort them so that objects of the same color are adjacent, 
 * with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, 
and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.*/

public class SortColors {

	// 75. Sort Colors
	public void sortColors(int[] nums) {

		if (nums == null || nums.length == 0)
			return;
		int j = 0;
		for (int i = 1, len = nums.length; i < len; i++) {
			int tmp = nums[i];
			for (j = i; j > 0 && tmp < nums[j - 1]; j--) {
				nums[j] = nums[j - 1];
			}
			nums[j] = tmp;
		}
	}
}
