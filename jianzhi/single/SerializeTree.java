/*
 * ��Ŀ����
 *	��ʵ�������������ֱ��������л��ͷ����л�������
 * 
 * */

public class SerializeTree {

	// ���л��������ͷ����л�������
	private int serializeIndex = -1;

	public String Serialize(TreeNode root) {

		StringBuilder sb = new StringBuilder();
		if (root == null) {
			sb.append("#,");
			return sb.toString();
		}
		sb.append(root.val + ",");
		sb.append(Serialize(root.left));
		sb.append(Serialize(root.right));
		return sb.toString();
	}

	public TreeNode Deserialize(String str) {

		serializeIndex++;
		if (serializeIndex >= str.length())
			return null;
		String[] strings = str.split(",");
		TreeNode node = null;
		if (!strings[serializeIndex].equals("#")) {
			node = new TreeNode(Integer.valueOf(strings[serializeIndex]));
			node.left = Deserialize(str);
			node.right = Deserialize(str);
		}
		return node;
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
