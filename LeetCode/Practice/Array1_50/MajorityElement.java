package com.dalai.array1_50;

/*Given an array of size n, find the majority element. 
 * The majority element is the element that appears more than âŒ? n/2 âŒ? times.

You may assume that the array is non-empty 
and the majority element always exist in the array.*/

public class MajorityElement {

	// 169. Majority Element
	public int majorityElement(int[] nums) {

		//è¿™ä¸ªæ–¹æ³•æ…?
		// int num = nums.length / 2;
		// Map<Integer, Integer> map = new HashMap<>();
		// for (Integer i : nums) {
		// if (map.containsKey(i)) {
		// map.put(i, map.get(i) + 1);
		// } else {
		// map.put(i, 1);
		// }
		// }
		// for (Integer i : nums) {
		// if (map.get(i) > num) {
		// return i;
		// }
		// }
		// return 0;
		
		//å¿?
		int maj = nums[0];
		int count = 1;
		for (int i = 1; i < nums.length; i++) {

			if (maj == nums[i])
				count++;
			else if (count == 0) {
				maj = nums[i];
				count = 1;
			} else {
				count--;
			}

		}
		return maj;
	}
}
