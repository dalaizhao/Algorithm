/*
 * 题目描述
 *	 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 
 * */

public class IsBalanced {

	// 平衡二叉树
	private boolean isBalanced = true;

	public boolean isBalanced_Solution(TreeNode root) {

		if (root == null)
			return true;
		getBalancedFactor(root);

		return isBalanced;
	}

	private int getBalancedFactor(TreeNode root) {

		if (root == null)
			return 0;
		int left = getBalancedFactor(root.left);
		int right = getBalancedFactor(root.right);
		if (left - right > 1 || left - right < -1) {
			isBalanced = false;
		}
		return right > left ? right + 1 : left + 1;
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
