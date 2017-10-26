package com.dalai.par;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

//687. Longest Univalue Path
public class LongestUnivaluePath {

	/*
	 * Given a binary tree, find the length of the longest path where each node in
	 * the path has the same value. This path may or may not pass through the root.
	 * 
	 * Note: The length of path between two nodes is represented by the number of
	 * edges between them.
	 */
	public int longestUnivaluePathII(TreeNode root) {

		Map<Integer, Integer> map = new HashMap<>();
		recurion(root, map);
		int max = 0;
		for (Entry<Integer, Integer> en : map.entrySet()) {
			if (max <= en.getValue()) {
				max = en.getValue();
			}
		}
		return max;
	}

	private void recurion(TreeNode root, Map<Integer, Integer> map) {

		if (root != null) {
			map.put(root.val, map.getOrDefault(root.val, -1) + 1);
			recurion(root.left, map);
			recurion(root.right, map);
		}
	}

	int len = 0;

	public int longestUnivaluePath(TreeNode root) {

		if (root == null)
			return 0;
		len = 0;
		getLen(root, root.val);
		return len;
	}

	private int getLen(TreeNode root, int val) {

		if (root == null)
			return 0;
		int left = getLen(root.left, root.val);
		int right = getLen(root.right, root.val);
		len = Math.max(len, left + right);
		if (val == root.val)
			return Math.max(left, right) + 1;
		return 0;

	}
}
