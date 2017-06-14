/*
 * 题目描述
 *	输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 *	要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 
 * */

public class Convert {

	// 二叉搜索树与双向链表
	public TreeNode convert(TreeNode pRootOfTree) {
		if (pRootOfTree == null)
			return null;
		TreeNode pLastNodeInList = null;
		pLastNodeInList = convertNode(pRootOfTree, pLastNodeInList);

		TreeNode pHeadOfList = pLastNodeInList;

		while (pHeadOfList != null && pHeadOfList.left != null) {
			pHeadOfList = pHeadOfList.left;
		}
		return pHeadOfList;
	}

	private TreeNode convertNode(TreeNode pRootOfTree, TreeNode pLastNodeInList) {

		if (pRootOfTree == null)
			return null;
		TreeNode pCurrent = pRootOfTree;

		if (pCurrent.left != null)
			pLastNodeInList = convertNode(pCurrent.left, pLastNodeInList);
		pCurrent.left = pLastNodeInList;
		if (pLastNodeInList != null) {
			pLastNodeInList.right = pCurrent;
		}
		pLastNodeInList = pCurrent;
		if (pCurrent.right != null)
			pLastNodeInList = convertNode(pCurrent.right, pLastNodeInList);
		return pLastNodeInList;
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
