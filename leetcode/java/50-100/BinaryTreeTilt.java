package com.dalai.par;

//563. Binary Tree Tilt
public class BinaryTreeTilt {

	/*
	 * Given a binary tree, return the tilt of the whole tree.
	 * 
	 * The tilt of a tree node is defined as the absolute difference between the sum
	 * of all left subtree node values and the sum of all right subtree node values.
	 * Null node has tilt 0.
	 * 
	 * The tilt of the whole tree is defined as the sum of all nodes' tilt.
	 */

	public int findTilt(TreeNode root) {

		if (root == null)
			return 0;
		find(root);

		return sum;
	}

	int sum = 0;

	private int find(TreeNode root) {

		if (root == null)
			return 0;
		int left = find(root.left);
		int right = find(root.right);
		sum += Math.abs(left - right);

		return left + right + root.val;
	}

	public static void main(String[] args) {

	}

}
