/*
 * ��Ŀ����
 * 	����һ�Ŷ��������������ҳ����еĵ�k��Ľ�㡣
 * 	���磬 5 / \ 3 7 /\ /\ 2 4 6 8 �У��������ֵ��С˳�����������ֵΪ4��
 * */

public class KthNode {

	// �����������ĵ�k�����
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
