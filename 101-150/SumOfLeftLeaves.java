package com.dalai.par;

//404. Sum of Left Leaves
public class SumOfLeftLeaves {

	int sum = 0;

	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left != null) {
			sum += root.left.val;
			sumOfLeftLeaves(root.left);
		}
		if (root.right != null) {
			sumOfLeftLeaves(root.right);
		}
		return sum;
	}
}
