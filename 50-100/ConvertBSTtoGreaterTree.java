package com.dalai.par;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.w3c.dom.ls.LSInput;

//538. Convert BST to Greater Tree
public class ConvertBSTtoGreaterTree {

	/*
	 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that
	 * every key of the original BST is changed to the original key plus sum of all
	 * keys greater than the original key in BST.
	 */

	public TreeNode convertBST(TreeNode root) {

		ArrayList<Integer> list = new ArrayList<>();
		preOrder(root, list);

		Collections.sort(list);
		addVal(root, list);

		return root;
	}

	private void preOrder(TreeNode root, ArrayList<Integer> list) {
		if (root != null) {
			list.add(root.val);
			preOrder(root.left, list);
			preOrder(root.right, list);
		}
	}

	private void addVal(TreeNode root, List<Integer> list) {

		if (root != null) {
			int idx = list.indexOf(root.val)+1;
			for (; idx < list.size(); idx++) {
				root.val += list.get(idx);
			}
			addVal(root.left, list);
			addVal(root.right, list);
		}
	}

	public static void main(String[] args) {

	}

}
