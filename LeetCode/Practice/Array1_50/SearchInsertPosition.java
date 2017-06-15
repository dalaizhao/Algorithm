package com.dalai.array1_50;

/*Given a sorted array and a target value, 
 * return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 ¡ú 2
[1,3,5,6], 2 ¡ú 1
[1,3,5,6], 7 ¡ú 4
[1,3,5,6], 0 ¡ú 0*/

public class SearchInsertPosition {

	// 35.Search Insert Position

	public int searchInsert(int[] nums, int target) {

		if (nums == null || nums.length == 0) {
			return -1;
		}
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] > target) {
				right = mid - 1;
			} else if (nums[mid] == target) {
				return mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}
}
