/*
 * ��Ŀ����
 *	���������Ķ�����������任ΪԴ�������ľ��� 
 *	��������:
 *	�������ľ����壺Դ������ 
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9 11
    	���������
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11 9 7  5
  * */

public class Mirror {

	// �������ľ���
	public void mirror(TreeNode root) {

		if (root == null) {
			return;
		}
		TreeNode tmpNode = root.left;
		root.left = root.right;
		root.right = tmpNode;

		if (root.left != null) {
			mirror(root.left);
		}
		if (root.right != null) {
			mirror(root.right);
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
