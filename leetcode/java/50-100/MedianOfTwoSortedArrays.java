package com.dalai.par;

import java.util.ArrayList;

//4. Median of Two Sorted Arrays
public class MedianOfTwoSortedArrays {

	/*
	 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
	 * 
	 * Find the median of the two sorted arrays. The overall run time complexity
	 * should be O(log (m+n)).
	 * 
	 * Example 1: nums1 = [1, 3] nums2 = [2]
	 * 
	 * The median is 2.0 Example 2: nums1 = [1, 2] nums2 = [3, 4]
	 * 
	 * The median is (2 + 3)/2 = 2.5
	 */
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {

		if (nums1 == null || nums2 == null)
			return 0;
		int len1 = nums1.length, len2 = nums2.length, sum = len1 + len2;
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0, j = 0; i < len1 || j < len2;) {

			if (i >= len1) {
				list.add(nums2[j++]);
			} else if (j >= len2) {
				list.add(nums1[i++]);
			} else if (nums1[i] <= nums2[j]) {
				list.add(nums1[i++]);
			} else {
				list.add(nums2[j++]);
			}
		}
		System.out.println(list.toString());
		boolean flag = (sum % 2 == 0) ? true : false; // Å¼ÊýµÄ»°true
		if (flag) {

			return (list.get(sum / 2) + list.get(sum / 2 - 1)) / 2.0;
		} else {

			return list.get(sum / 2);
		}
	}

	public static void main(String[] args) {
		int[] arr1 = { 1 };
		int[] arr2 = {};
		System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(arr1, arr2));
	}
}
