package com.dalai.array1_50;

/*Given two sorted integer arrays nums1 and nums2, 
 * merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) 
to hold additional elements from nums2. 
The number of elements initialized in nums1 and nums2 are m and n respectively.*/

public class MergeSortedArray {

	// 88. Merge Sorted Array
	public void merge(int[] nums1, int m, int[] nums2, int n) {

		// 这个效率低
		// int i = 0, j = 0, k = 0;
		// int[] mCopy = new int[m];
		// System.arraycopy(nums1, 0, mCopy, 0, m);
		// while (i < m && j < n) {
		// if (mCopy[i] > nums2[j]) {
		// nums1[k++] = nums2[j++];
		// } else {
		// nums1[k++] = mCopy[i++];
		// }
		// }
		// if (n - j <= 0) {
		// System.arraycopy(mCopy, i, nums1, k, mCopy.length - i);
		// } else {
		// System.arraycopy(nums2, j, nums1, k, nums2.length - j);
		// }

		// 这个效率高
		int len = m + n - 1, i = m - 1, j = n - 1;
		while (i >= 0 && j >= 0) {
			if (nums1[i] > nums2[j]) {
				nums1[len] = nums1[i];
				i--;
			} else {
				nums1[len] = nums2[j];
				j--;
			}
			len--;
		}
		while (j >= 0) {
			nums1[j] = nums2[j];
			j--;
		}
	}

}
