package com.dalai.par;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//637. Average of Levels in Binary Tree
public class AverageOfLevelsInBinaryTree {
	/*
	 * Given a non-empty binary tree, return the average value of the nodes on each
	 * level in the form of an array.
	 */

	public List<Double> averageOfLevels(TreeNode root) {

		LinkedList<TreeNode> queue = new LinkedList<>();
		ArrayList<Double> list = new ArrayList<>();
		ArrayList<Integer> avgList = new ArrayList<>();

		queue.add(root);
		queue.add(null);

		while (!queue.isEmpty()) {
			TreeNode node = queue.removeFirst();
			if (node == null) {
				double avg = getAvg(avgList);
				list.add(avg);
				avgList.clear();
				if (queue.size() > 0) {
					queue.add(null);
				}
			} else {
				avgList.add(node.val);
				if (node.left != null)
					queue.addLast(node.left);
				if (node.right != null)
					queue.addLast(node.right);
			}
		}
		return list;
	}

	private double getAvg(ArrayList<Integer> list) {

		if (list == null || list.size() == 0)
			return 0;
		double sum = 0;
		for (Integer integer : list) {
			sum += integer;
		}

		return sum / list.size();
	}

}
