package com.dalai.par;

//101. Symmetric Tree
public class SymmetricTree {

	/*
	 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric
	 * around its center).
	 */
	public boolean isSymmetric(TreeNode root) {
		return root==null||isSymmetricII(root.left,root.right);
	}

	private boolean isSymmetricII(TreeNode left, TreeNode right) {
		if(left==null||right==null)return left==right;
		if(left.val!=right.val)return false;
		return isSymmetricII(left.left, right.right)&&isSymmetricII(left.right, right.left);
	}
}
