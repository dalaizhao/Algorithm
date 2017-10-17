package com.dalai.array1_50;

/*Given an array of integers that is already sorted in ascending order, 
 * find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such 
that they add up to the target, where index1 must be less than index2. 
Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution 
and you may not use the same element twice.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2*/

public class TwoSumII_InputArrayIsSorted {

	// 167. Two Sum II - Input array is sorted
	public int[] twoSum2(int[] numbers, int target) {

		// 效率低
		// int[] arr=new int[2];
		// Map<Integer, Integer> map=new HashMap<>();
		// for(int i=0;i<numbers.length;i++){
		// if(map.containsKey(target-numbers[i])){
		// arr[0]=map.get(target-numbers[i])+1;
		// arr[1]=i+1;
		// return arr;
		// }else{
		// map.put(numbers[i], i);
		// }
		// }
		//
		// return arr;

		// 效率高
		int[] res = new int[2];
		int start = 0;
		int end = numbers.length - 1;

		while (start < end) {
			if (numbers[start] + numbers[end] == target) {
				res[0] = start + 1;
				res[1] = end + 1;
				return res;
			} else if (numbers[start] + numbers[end] < target) {
				start++;
			} else {
				end--;
			}
		}
		return res;
	}
}
