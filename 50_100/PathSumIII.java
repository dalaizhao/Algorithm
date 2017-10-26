package com.dalai.par;

//437. Path Sum III
public class PathSumIII {

	/*
	 * You are given a binary tree in which each node contains an integer value.
	 * 
	 * Find the number of paths that sum to a given value.
	 * 
	 * The path does not need to start or end at the root or a leaf, but it must go
	 * downwards (traveling only from parent nodes to child nodes).
	 * 
	 * The tree has no more than 1,000 nodes and the values are in the range
	 * -1,000,000 to 1,000,000.
	 */

	int num = 0;

	public int pathSum(TreeNode root, int sum) {

		if (root == null)
			return 0;
		int tempSum = sum;
		redurion(root, sum, tempSum);
		return num;
	}

	private void redurion(TreeNode root, int sum, int tempSum) {
		if(tempSum==0)num++;
		if(root.val>tempSum)tempSum=sum;
		if(root.left!=null)
			redurion(root.left, sum, tempSum-root.val);
	}
}
