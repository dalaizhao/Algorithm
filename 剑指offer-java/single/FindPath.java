import java.util.ArrayList;
import java.util.LinkedList;

/*
 * 题目描述
 *	输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 *	路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * */
public class FindPath {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// 二叉树中和为某一值的路径
	public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {

		if (root == null)
			return new ArrayList<>();
		ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
		LinkedList<Integer> stackList = new LinkedList<>();
		int currentSum = 0;
		finfPaths(root, target, currentSum, paths, stackList);
		return paths;
	}

	private void finfPaths(TreeNode root, int target, int currentSum, ArrayList<ArrayList<Integer>> paths,
			LinkedList<Integer> stackList) {

		currentSum += root.val;
		stackList.add(root.val);
		boolean isLeaf = root.left == null && root.right == null;
		if (currentSum == target && isLeaf) {
			ArrayList<Integer> tmpList = new ArrayList<>();
			for (Integer integer : stackList) {
				tmpList.add(integer);
			}
			paths.add(tmpList);
		}
		if (root.left != null)
			finfPaths(root.left, target, currentSum, paths, stackList);
		if (root.right != null)
			finfPaths(root.right, target, currentSum, paths, stackList);
		currentSum -= root.val;
		stackList.removeLast();
	}
}
