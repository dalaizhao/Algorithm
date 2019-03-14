/*
 * ��Ŀ����
 * 	��ʵ��һ�������������ж�һ�Ŷ������ǲ��ǶԳƵġ�
 * 	ע�⣬���һ��������ͬ�˶������ľ�����ͬ���ģ�������Ϊ�ԳƵġ�
 * */

public class IsSymmetrical {

	// �Գƶ�����
	public boolean isSymmetrical(TreeNode pRoot) {

		if (pRoot == null || (pRoot.left == null && pRoot.right == null)) {
			return true;
		} else if (pRoot.left != null && pRoot.right != null) {
			if (pRoot.left.val != pRoot.right.val)
				return false;
		} else {
			return false;
		}
		return isSym(pRoot.left, pRoot.right);
	}

	private boolean isSym(TreeNode left, TreeNode right) {

		boolean l = false, r = false;
		if (left != null && right != null) {

			if (left.val == right.val) {
				l = isSym(left.left, right.right);
				r = isSym(left.right, right.left);
				if (l && r)
					return true;
			}
		} else if (left == null && right == null) {
			return true;
		}
		return false;
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
