/*
 * 题目描述
 * 	给定一颗二叉搜索树，请找出其中的第k大的结点。
 * 	例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
 * */

public class KthNode {

	// 二叉搜索树的第k个结点
	private int kThIndex = 0;
	private TreeNode KTHNODE = null;

	public TreeNode kthNode(TreeNode pRoot, int k) {

		if (pRoot == null || k <= 0)
			return KTHNODE;
		kThIndex = k;
		KthNodeInOrder(pRoot);
		return KTHNODE;
	}

	private void KthNodeInOrder(TreeNode pRoot) {
		TreeNode tmp = null;
		if (pRoot != null) {
			KthNodeInOrder(pRoot.left);
			if (kThIndex == 1) {
				KTHNODE = pRoot;
			}
			kThIndex--;
			KthNodeInOrder(pRoot.right);
		}
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
