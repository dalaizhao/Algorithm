package com.dalai.par;

//110. Balanced Binary Tree
public class BalancedBinaryTree {

	/*
	 * Given a binary tree, determine if it is height-balanced.
	 * 
	 * For this problem, a height-balanced binary tree is defined as a binary tree
	 * in which the depth of the two subtrees of every node never differ by more
	 * than 1.
	 */

	boolean fl = true;

	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		recurion(root);
		return fl;
	}

	private int recurion(TreeNode root) {
		if (root == null)
			return 0;
		int left = recurion(root.left);
		int right = recurion(root.right);

		if (Math.abs(left - right) > 1)
			fl = false;
		return Math.max(left, right) + 1;
	}
}
