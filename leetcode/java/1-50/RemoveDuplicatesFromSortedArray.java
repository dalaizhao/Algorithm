package com.dalai.array1_50;

/*Given a sorted array, remove the duplicates in place 
 * such that each element appear only once and return the new length.

Do not allocate extra space for another array, 
you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, 
with the first two elements of nums being 1 and 2 respectively. 
It doesn't matter what you leave beyond the new length.*/

public class RemoveDuplicatesFromSortedArray {

	// 26. Remove Duplicates from Sorted Array

	public int removeDuplicates(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}
		int len = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != nums[len]) {
				nums[++len] = nums[i];
			}
		}
		return ++len; // ����++len��len+1�����������࣬++len���졣
	}
}
