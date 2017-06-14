import java.util.ArrayList;
import java.util.LinkedList;

/*
 * 题目描述
 *	从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * */
public class Printh {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// 把二叉树打印成多行
	ArrayList<ArrayList<Integer>> printh(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		if (pRoot == null)
			return list;
		LinkedList<TreeNode> queue = new LinkedList<>();
		LinkedList<TreeNode> queue2 = new LinkedList<>();
		queue.add(pRoot);
		while (!queue.isEmpty() || !queue2.isEmpty()) {
			ArrayList<Integer> arrayList = new ArrayList<>();
			if (!queue.isEmpty()) {
				while (!queue.isEmpty()) {
					TreeNode tmpNode = queue.removeFirst();
					arrayList.add(tmpNode.val);
					if (tmpNode.left != null)
						queue2.add(tmpNode.left);
					if (tmpNode.right != null)
						queue2.add(tmpNode.right);
				}
				list.add(arrayList);
			} else {
				while (!queue2.isEmpty()) {
					TreeNode tmpNode = queue2.removeFirst();
					arrayList.add(tmpNode.val);
					if (tmpNode.left != null)
						queue.add(tmpNode.left);
					if (tmpNode.right != null)
						queue.add(tmpNode.right);

				}
				list.add(arrayList);
			}

		}
		return list;
	}
}
