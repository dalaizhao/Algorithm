import java.util.ArrayList;
import java.util.LinkedList;

/*
 * ��Ŀ����
 *	����һ�Ŷ�������һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����
 *	·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����
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

	// �������к�Ϊĳһֵ��·��
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
