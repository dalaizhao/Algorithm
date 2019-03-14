import java.util.ArrayList;
import java.util.LinkedList;

/*
 * 题目描述
 *	从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * */
public class PrintFromTopToBottom {

	// 从上往下打印二叉树
	public ArrayList<Integer> printFromTopToBottom(TreeNode root) {

		if (root == null)
			return new ArrayList<>();
		ArrayList<Integer> returnList = new ArrayList<>();
		LinkedList<TreeNode> queueList = new LinkedList<>();
		queueList.add(root);
		while (!queueList.isEmpty()) {
			TreeNode node = queueList.pop();
			if (node.left != null)
				queueList.add(node.left);
			if (node.right != null)
				queueList.add(node.right);
			returnList.add(node.val);
		}
		return returnList;
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
