package com.dalai.par;

import java.util.ArrayList;
import java.util.List;

//95. Unique Binary Search Trees II
public class UniqueBinarySearchTreesII {

	/*
	 * Given an integer n, generate all structurally unique BST's (binary search
	 * trees) that store values 1...n.
	 * 
	 * For example, Given n = 3, your program should return all 5 unique BST's shown
	 * below.
	 */
	public List<TreeNode> generateTrees(int n) {

		List<TreeNode> list = new ArrayList<>();

		if (n <= 0)
			return list;

		return generateSubTrees(1, n);
	}

	private List<TreeNode> generateSubTrees(int s, int e) {

		List<TreeNode> list = new ArrayList<>();

		if (s > e) {
			list.add(null);
			return list;
		}

		for (int i = s; i <= e; i++) {
			List<TreeNode> leftSubTrees = generateSubTrees(s, i - 1);
			List<TreeNode> rigthSubTrees = generateSubTrees(i + 1, e);

			for (TreeNode left : leftSubTrees) {
				for (TreeNode right : rigthSubTrees) {
					TreeNode root = new TreeNode(i);
					root.left = left;
					root.right = right;
					list.add(root);
				}
			}
		}

		return list;
	}

	public static void main(String[] args) {

	}
}
