
/*题目描述
 *	输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 *	如果是则输出Yes,否则输出No。
 *	假设输入的数组的任意两个数字都互不相同。
 **/
public class VerifySquenceOfBST {

	// 二叉搜索树的后序遍历序列
	public boolean verifySquenceOfBST(int[] sequence) {

		if (sequence == null || sequence.length == 0)
			return false;

		return verifySquence(sequence, 0, sequence.length);
	}

	private boolean verifySquence(int[] sequence, int start, int len) {

		if (sequence == null || len == 0)
			return false;

		int root = sequence[start + len - 1];

		// 二叉搜索树中左子树小于根节点
		int i = 0;
		for (; i < len - 1; i++) {
			if (sequence[i + start] > root)
				break;
		}
		// 二叉搜索树中右子树大于根节点
		int j = i;
		for (; j < len - 1; j++) {
			if (sequence[j + start] < root)
				return false;
		}
		// 判断左子树是不是二叉搜索树
		boolean left = true;
		if (i > 0)
			left = verifySquence(sequence, start, i);
		// 判断柚子树
		boolean right = true;
		if (i < len - 1)
			right = verifySquence(sequence, i + start, len - i - 1);
		return (left && right);
	}
}
