package com.dalai.par;

//572. Subtree of Another Tree
public class SubtreeOfAnotherTree {
	/*
	 * Given two non-empty binary trees s and t, check whether tree t has exactly
	 * the same structure and node values with a subtree of s. A subtree of s is a
	 * tree consists of a node in s and all of this node's descendants. The tree s
	 * could also be considered as a subtree of itself.
	 */

	public boolean isSubtree(TreeNode s, TreeNode t) {

		if (s == null)return false;
		if (subTree(s, t))return true;
		return isSubtree(s.left, t) || isSubtree(s.right, t);
	}

	private boolean subTree(TreeNode s, TreeNode t) {
		if (s == null && t == null)return true;
		if (s == null || t == null)return false;
		if (s.val != t.val)return false;
		return subTree(s.left, t.left) && subTree(s.right, t.right);
	}
}
