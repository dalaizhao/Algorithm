import java.util.ArrayList;
import java.util.LinkedList;

/*
 * 题目描述
 * 	请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 	第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * */

public class Print {

	// 按之字形式顺序打印二叉树
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
