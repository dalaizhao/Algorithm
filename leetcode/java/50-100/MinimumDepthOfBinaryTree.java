package com.dalai.par;

//111. Minimum Depth of Binary Tree
public class MinimumDepthOfBinaryTree {

	/*
	 * Given a binary tree, find its minimum depth.
	 * 
	 * The minimum depth is the number of nodes along the shortest path from the
	 * root node down to the nearest leaf node.
	 */

	public int minDepth(TreeNode root) {

		if (root == null)
			return 0;
		int left = minDepth(root.left);
		int right = minDepth(root.right);

		return (left == 0 || right == 0) ? (left + right + 1) : (Math.min(left, right) + 1);

	}
}
