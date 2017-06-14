
/*
 * ��Ŀ����:
 *	����ĳ��������ǰ���������������Ľ�������ؽ����ö�������
 *	���������ǰ���������������Ľ���ж������ظ������֡�
 *	��������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}��
 *	���ؽ������������ء�
 * 
 * */
public class ReConstructBinaryTree {

	// �ؽ�������
	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {

		if (pre == null || in == null || pre.length == 0 || in.length == 0)
			return null;
		return build(pre, 0, pre.length, in, 0, in.length);
	}

	private TreeNode build(int[] pre, int preStart, int preLen, int[] in, int inStart, int inLen) {

		TreeNode root = null;
		if (preLen > 0) {
			root = new TreeNode(pre[preStart]);
			int inRootIndex = 0;
			for (int i = 0; i < inLen; i++) {
				if (pre[preStart] == in[i + inStart]) {
					inRootIndex = i + inStart;
					break;
				}
			}
			int leftLen = inRootIndex - inStart;
			int rightLen = inStart + inLen - inRootIndex - 1;
			root.left = build(pre, preStart + 1, leftLen, in, inStart, leftLen);
			root.right = build(pre, preStart + leftLen + 1, rightLen, in, inRootIndex + 1, rightLen);
		}
		return root;
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
