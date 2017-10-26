package com.dalai.par;

//108. Convert Sorted Array to Binary Search Tree
public class ConvertSortedArrayToBinarySearchTree {
	/*
	 * Given an array where elements are sorted in ascending order, convert it to a
	 * height balanced BST.
	 */
	public TreeNode sortedArrayToBST(int[] nums) {

		if (nums.length == 0)
			return null;
		return recurion(nums, 0, nums.length - 1);
	}

	private TreeNode recurion(int[] nums, int low, int high) {

		if (low > high)return null;

		int mid = (low + high) / 2;
		TreeNode node = new TreeNode(nums[mid]);
		node.left = recurion(nums, low, mid - 1);
		node.right = recurion(nums, mid = 1, high);
		return node;
	}
}
