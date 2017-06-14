/*
 * ��Ŀ����
 *	����һ�ö����������������ȡ�
 *	�Ӹ���㵽Ҷ������ξ����Ľ�㣨������Ҷ��㣩�γ�����һ��·����
 *	�·���ĳ���Ϊ������ȡ�
 * */

public class TreeDepth {

	// �����������
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
