package com.dalai.array1_50;

import java.util.Arrays;

/*Given an array of integers, find if the array contains any duplicates. 
 * Your function should return true if any value appears at least twice in the array, 
 * and it should return false if every element is distinct.*/

public class ContainsDuplicate {

	// 217. Contains Duplicate
	public boolean containsDuplicate(int[] nums) {

		if (nums == null || nums.length == 0)
			return false;
		// 这个比较慢
		/*
		 * Set<Integer> set=new HashSet<>(); for(int i=0;i<nums.length;i++){
		 * if(set.contains(nums[i])){ return true; }else{ set.add(nums[i]); } }
		 * return false;
		 */
		// 这个快
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == nums[i + 1]) {
				return true;
			}
		}
		return false;
	}
}
