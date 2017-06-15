package com.dalai.array1_50;

/*Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, 
with the first five elements of nums being 1, 1, 2, 2 and 3. 
It doesn't matter what you leave beyond the new length.*/

public class RemoveDuplicatesFromSortedArrayII {

	// 80. Remove Duplicates from Sorted Array II
	public int removeDuplicates2(int[] nums) {

		if (nums == null || nums.length == 0)
			return 0;

		int index = 0, count = 0;
		for (int len = nums.length, i = 1; i < len; i++) {
			if (nums[index] != nums[i]) {
				nums[++index] = nums[i];
				if (count > 0) {
					count = 0;
				}
			} else if (nums[index] == nums[i] && count == 0) {
				count++;
				nums[++index] = nums[i];
			} else
				;
		}
		return ++index;
	}
}
