/*
 * 题目描述
 *	输入一棵二叉树，求该树的深度。
 *	从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
 *	最长路径的长度为树的深度。
 * */

public class TreeDepth {

	// 二叉树的深度
	public int treeDepth(TreeNode root) {

		if (root == null)
			return 0;
		int left = treeDepth(root.left);
		int right = treeDepth(root.right);

		return Math.max(left, right) + 1;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
