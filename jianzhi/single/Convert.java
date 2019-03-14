/*
 * ��Ŀ����
 *	����һ�ö��������������ö���������ת����һ�������˫������
 *	Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
 * 
 * */

public class Convert {

	// ������������˫������
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
