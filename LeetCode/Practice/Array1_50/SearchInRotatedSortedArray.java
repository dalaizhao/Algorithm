package com.dalai.array1_50;

/*Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.*/

public class SearchInRotatedSortedArray {

	// 33. Search in Rotated Sorted Array
	public int search(int[] nums, int target) {

		if (nums == null || nums.length == 0)
			return -1;
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
					return mid;
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
					return mid;
				} else if (nums[mid] > target) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
		}
		return -1;
	}
}
