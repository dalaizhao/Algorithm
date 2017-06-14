
/*
 * ��Ŀ����
 *	�������ö�����A��B���ж�B�ǲ���A���ӽṹ����ps������Լ��������������һ�������ӽṹ��
 * */

public class HasSubtree {

	// �����ӽṹ
	public boolean hasSubtree(TreeNode root1, TreeNode root2) {

		boolean result = false;
		if (root1 != null && root2 != null) {
			if (root1.val == root2.val) {
				result = doesTree1HaveTree2(root1, root2);
			}
			if (!result) {
				result = hasSubtree(root1.left, root2);
			}
			if (!result) {
				result = hasSubtree(root1.right, root2);
			}
		}
		return result;
	}

	private boolean doesTree1HaveTree2(TreeNode root1, TreeNode root2) {

		if (root2 == null)
			return true;
		if (root1 == null) {
			return false;
		}
		if (root1.val != root2.val)
			return false;
		return doesTree1HaveTree2(root1.left, root2.left) && doesTree1HaveTree2(root1.right, root2.right);
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
