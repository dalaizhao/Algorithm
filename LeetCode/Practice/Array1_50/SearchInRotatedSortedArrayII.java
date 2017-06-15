package com.dalai.array1_50;

/*Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?
Suppose an array sorted in ascending order is rotated at some pivot 
unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Write a function to determine if a given target is in the array.

The array may contain duplicates.*/

public class SearchInRotatedSortedArrayII {

	// 81. Search in Rotated Sorted Array II
	public boolean search2(int[] nums, int target) {

		if (nums == null || nums.length == 0)
			return false;
		int maxNumIndex = nums.length - 1;
		for (int i = 0, len = nums.length - 1; i < len; i++) {
			if (nums[i] > nums[i + 1]) {
				maxNumIndex = i;
				break;
			}
		}
		int left = 0, right = nums.length - 1;
		if (target >= nums[left]) {
			right = maxNumIndex;
			while (left <= right) {
				int mid = (left + right) / 2;
				if (nums[mid] == target) {
					return true;
				} else if (nums[mid] > target) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
		} else {
			left = maxNumIndex + 1;
			while (left <= right) {
				int mid = (left + right) / 2;
				if (nums[mid] == target) {
					return true;
				} else if (nums[mid] > target) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
		}
		return false;
	}
}
