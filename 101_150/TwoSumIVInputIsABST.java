package com.dalai.par;

import java.util.HashSet;
import java.util.Set;

//653. Two Sum IV - Input is a BST
public class TwoSumIVInputIsABST {

	/*
	 * Given a Binary Search Tree and a target number, return true if there exist
	 * two elements in the BST such that their sum is equal to the given target.
	 */
	boolean fl = false;

	public boolean findTarget(TreeNode root, int k) {

		Set<Integer> set = new HashSet<>();

		recurion(root, k, set);

		return fl;
	}

	private void recurion(TreeNode root, int k, Set<Integer> set) {

		if (root == null)
			return;

		if (set.contains(k - root.val)) {
			fl = true;
		} else {
			set.add(root.val);
			recurion(root.left, k, set);
			recurion(root.right, k, set);
		}
	}
}
