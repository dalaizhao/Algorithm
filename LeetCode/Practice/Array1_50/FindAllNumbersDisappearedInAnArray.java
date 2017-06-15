package com.dalai.array1_50;

import java.util.ArrayList;
import java.util.List;

/*Given an array of integers where 1 ¡Ü a[i] ¡Ü n (n = size of array), 
 * some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? 
You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]*/

public class FindAllNumbersDisappearedInAnArray {

	// 448. Find All Numbers Disappeared in an Array

	public List<Integer> findDisappearedNumbers(int[] nums) {

		ArrayList<Integer> arrayList = new ArrayList<>();
		/*
		 * if (nums == null || nums.length == 0) return arrayList; for (int i =
		 * 0; i < nums.length; i++) { int value = Math.abs(nums[i]) - 1; if
		 * (nums[value] > 0) nums[value] = -nums[value]; } for (int j = 0; j <
		 * nums.length; j++) { if (nums[j] > 0) arrayList.add(j + 1); }
		 */
		byte[] bs = new byte[nums.length];
		for (int i = 0; i < nums.length; i++) {
			bs[nums[i] - 1] = 1;
		}
		for (int j = 0; j < nums.length; j++) {
			if (bs[j] != 1)
				arrayList.add(j + 1);
		}

		return arrayList;
	}
}
