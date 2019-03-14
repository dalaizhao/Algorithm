package com.dalai.par;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//107. Binary Tree Level Order Traversal II
public class BinaryTreeLevelOrderTraversalII {

	/*
	 * Given a binary tree, return the bottom-up level order traversal of its nodes'
	 * values. (ie, from left to right, level by level from leaf to root).
	 */

	public List<List<Integer>> levelOrderBottom(TreeNode root) {

		Queue<TreeNode> queue = new LinkedList<>();
		List<List<Integer>> list = new LinkedList<>();

		if (root == null)
			return list;

		queue.offer(root);
		while (!queue.isEmpty()) {
			int levelNum = queue.size();
			List<Integer> each = new LinkedList<>();
			for (int i = 0; i < levelNum; i++) {
				if (queue.peek().left != null)
					queue.offer(queue.peek().left);
				if (queue.peek().right != null)
					queue.offer(queue.peek().right);
				each.add(queue.poll().val);
			}
			list.add(0, each);
		}

		return list;
	}

	public List<List<Integer>> levelOrderBottomII(TreeNode root) {

		List<List<Integer>> wrapList = new LinkedList<>();
		levelMaker(wrapList, root, 0);
		return wrapList;
	}

	public void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
		if (root == null)
			return;
		if (level >= list.size()) {
			list.add(0, new LinkedList<Integer>());
		}
		levelMaker(list, root.left, level + 1);
		levelMaker(list, root.right, level + 1);
		list.get(list.size() - level - 1).add(root.val);
	}
}
