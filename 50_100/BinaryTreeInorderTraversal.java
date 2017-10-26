package com.dalai.par;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//94. Binary Tree Inorder Traversal
public class BinaryTreeInorderTraversal {

	/*
	 * Given a binary tree, return the inorder traversal of its nodes' values.
	 * 
	 * For example: Given binary tree [1,null,2,3],
	 * 
	 * return [1,3,2].
	 */
	public List<Integer> inorderTraversal(TreeNode root) {

		List<Integer> list = new ArrayList<>();

		if (root == null)
			return list;
		Stack<TreeNode> stack = new Stack<>();

		TreeNode curr = root;

		while (curr != null || !stack.empty()) {
			while (curr != null) {
				stack.add(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			list.add(curr.val);
			curr = curr.right;
		}

		return list;
	}

}
