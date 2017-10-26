package com.dalai.par;

//112. Path Sum
public class PathSum {

	/*
	 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path
	 * such that adding up all the values along the path equals the given sum.Given
	 * a binary tree and a sum, determine if the tree has a root-to-leaf path such
	 * that adding up all the values along the path equals the given sum.
	 */

	public boolean hasPathSum(TreeNode root, int sum) {

		if (root == null )
			return false;

		if (root.left == null && root.right == null && (sum-root.val) == 0)
			return true;
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}

}
