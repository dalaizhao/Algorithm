import java.util.ArrayList;
import java.util.LinkedList;

/*
 * ��Ŀ����
 * 	��ʵ��һ����������֮���δ�ӡ������������һ�а��մ����ҵ�˳���ӡ��
 * 	�ڶ��㰴�մ��������˳���ӡ�������а��մ����ҵ�˳���ӡ���������Դ����ơ�
 * */

public class Print {

	// ��֮����ʽ˳���ӡ������
	public ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		if (pRoot == null)
			return list;
		LinkedList<TreeNode> queue = new LinkedList<>();
		LinkedList<TreeNode> stack = new LinkedList<>();
		queue.add(pRoot);
		while (!queue.isEmpty() || !stack.isEmpty()) {
			ArrayList<Integer> arrayList = new ArrayList<>();
			if (!queue.isEmpty()) {
				while (!queue.isEmpty()) {
					TreeNode tmpNode = queue.removeFirst();
					arrayList.add(tmpNode.val);
					if (tmpNode.left != null)
						stack.push(tmpNode.left);
					if (tmpNode.right != null)
						stack.push(tmpNode.right);
				}
				list.add(arrayList);
			} else {
				while (!stack.isEmpty()) {
					TreeNode tmpNode = stack.pop();
					arrayList.add(tmpNode.val);
					if (tmpNode.right != null)
						queue.addFirst(tmpNode.right);
					if (tmpNode.left != null)
						queue.addFirst(tmpNode.left);

				}
				list.add(arrayList);
			}

		}
		return list;
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
