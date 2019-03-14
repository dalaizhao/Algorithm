package com.dalai.par;

//104. Maximum Depth of Binary Tree
public class MaximumDepthOfBinaryTree {

	/*
	 * Given a binary tree, find its maximum depth.
	 * 
	 * The maximum depth is the number of nodes along the longest path from the root
	 * node down to the farthest leaf node.
	 */
	public int maxDepth(TreeNode root) {

		if(root==null)return 0;
		
		int left=maxDepth(root.left);
		int right = maxDepth(root.right);
		
		return Math.max(left, right)+1;
	}
}
