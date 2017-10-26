package com.dalai.par;

//98. Validate Binary Search Tree
public class ValidateBinarySearchTree {

	/*
	 * Given a binary tree, determine if it is a valid binary search tree (BST).
	 * 
	 * Assume a BST is defined as follows:
	 * 
	 * The left subtree of a node contains only nodes with keys less than the node's
	 * key. The right subtree of a node contains only nodes with keys greater than
	 * the node's key. Both the left and right subtrees must also be binary search
	 * trees.
	 */
	public boolean isValidBST(TreeNode root) {

		return isValidSubBST(root, Long.MAX_VALUE, Long.MIN_VALUE);
	}

	private boolean isValidSubBST(TreeNode root, long max, long min) {

		if (root == null) {
			return true;
		}
		if (root.val >= max || root.val <= min) {
			return false;
		}
		return isValidSubBST(root.left, root.val, min) && isValidSubBST(root.right, max, root.val);
	}

	public static void main(String[] args) {

	}

}
