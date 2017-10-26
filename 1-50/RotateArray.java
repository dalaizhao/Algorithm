package com.dalai.array1_50;

/*Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to 
[5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, 
there are at least 3 different ways to solve this problem.

[show hint]

Related problem: Reverse Words in a String II*/

public class RotateArray {

	// 189. Rotate Array
	public void rotate(int[] nums, int k) {

		// 这个办法比较慢
		// int time = k % nums.length;
		// myRotate(nums, time);

		// 这个快
		int[] res = new int[nums.length];
		if (k >= nums.length) {
			k = nums.length - k % nums.length;
		} else {
			k = nums.length - k;
		}
		System.arraycopy(nums, 0, res, 0, nums.length);
		System.arraycopy(res, k, nums, 0, nums.length - k);
		System.arraycopy(res, 0, nums, nums.length - k, k);

	}

	private void myRotate(int[] nums, int k) {

		int tmp = 0;
		int len = nums.length;
		for (int i = 0; i < len / 2; i++) {
			tmp = nums[i];
			nums[i] = nums[len - i - 1];
			nums[len - 1 - i] = tmp;
		}
		for (int i = 0; i < k / 2; i++) {
			tmp = nums[i];
			nums[i] = nums[k - 1 - i];
			nums[k - 1 - i] = tmp;
		}
		for (int i = 0; i < (len - k) / 2; i++) {
			tmp = nums[i + k];
			nums[i + k] = nums[len - i - 1];
			nums[len - 1 - i] = tmp;
		}

	}
}
