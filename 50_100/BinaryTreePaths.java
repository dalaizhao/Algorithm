package com.dalai.par;

import java.util.ArrayList;
import java.util.List;

//257. Binary Tree Paths
public class BinaryTreePaths {

	public List<String> binaryTreePaths(TreeNode root) {

		List<String> list = new ArrayList<>();
		if (root == null)
			return list;
		recurion(list, "", root);
		return list;
	}

	private void recurion(List<String> list, String s, TreeNode root) {

		if (root.left == null && root.right == null) {
			list.add(s + root.val);
		}
		if (root.left != null)
			recurion(list, s + root.val + "->", root.left);
		if (root.right != null)
			recurion(list, s + root.val + "->", root.right);
	}
}
