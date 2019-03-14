import java.util.*;
import java.util.regex.*;

/**
 * @author dalai
 * 
 * @finished 2017/06/14
 */
public class Solution {

	// ��ά�����еĲ�������
	public boolean Find(int target, int[][] array) {

		if (array == null || array.length == 0)
			return false;
		int row = 0, rowLen = array.length;
		int col = array[0].length - 1;
		while (row < rowLen && col >= 0) {
			if (array[row][col] == target) {
				return true;
			} else if (array[row][col] > target) {
				col--;
			} else {
				row++;
			}
		}
		return false;
	}

	// �滻�ո�
	public String replaceSpace(StringBuffer str) {

		if (str == null || str.length() == 0) {
			return str.toString();
		}
		StringBuffer stringBuffer = new StringBuffer();

		for (int i = 0, len = str.length(); i < len; i++) {
			if (str.charAt(i) == ' ') {
				stringBuffer.append("%20");
			} else {
				stringBuffer.append(str.charAt(i));
			}
		}
		return stringBuffer.toString();
	}

	// ��β��ͷ��ӡ����
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

		ArrayList<Integer> arrayList = new ArrayList<>();
		printList(arrayList, listNode);
		return arrayList;
	}

	private void printList(ArrayList<Integer> list, ListNode node) {

		if (node != null) {
			printList(list, node.next);
			list.add(node.val);
		}
	}

	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

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

	// ������ջʵ�ֶ���
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	public void push(int node) {
		stack1.push(node);
	}

	public int pop() {

		while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		int first = stack2.pop();
		while (!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
		return first;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// ��ת�������С����
	public int minNumberInRotateArray(int[] array) {

		if (array == null || array.length == 0)
			return 0;
		int left = 0;
		int right = array.length - 1;
		int mid = left;

		while (array[left] >= array[right]) {
			if ((right - left) == 1) {
				mid = right;
				break;
			}

			mid = (left + right) / 2;

			// ����±�Ϊleft,right,midָ�������������ȣ���ֻ����ѭ�����
			if (array[left] == array[mid] && array[mid] == array[right]) {
				return MinInOrder(array, left, right);
			}

			if (array[mid] >= array[left]) {
				left = mid;
			} else if (array[mid] <= array[right]) {
				right = mid;
			}
		}
		return array[mid];
	}

	private int MinInOrder(int[] array, int left, int right) {

		int result = array[left];
		for (int i = left + 1; i <= right; i++) {
			if (result > array[i])
				result = array[i];
		}
		return result;
	}

	// 쳲���������
	public int Fibonacci(int n) {

		if (n < 0)
			return n;
		int[] res = { 0, 1 };
		if (n < 2)
			return res[n];
		int fibOne = 0;
		int fibTwo = 1;
		int fibN = 0;
		for (int i = 2; i <= n; i++) {
			fibN = fibOne + fibTwo;
			fibOne = fibTwo;
			fibTwo = fibN;
		}
		return fibN;
	}

	// ��̨��
	public int JumpFloor(int n) {
		if (n <= 0)
			return n;
		if (n == 1)
			return 1;
		int fibOne = 1;
		int fibTwo = 1;
		int fibN = 0;
		for (int i = 2; i <= n; i++) {
			fibN = fibOne + fibTwo;
			fibOne = fibTwo;
			fibTwo = fibN;
		}
		return fibN;
	}

	// ��̬��̨��
	public int JumpFloorII(int target) {

		if (target <= 0) {
			return target;
		}
		// ��ѧ���ɷ����Եõ�f(n)=2^(n-1)
		return (int) Math.pow(2, target - 1);
	}

	// ���󸲸�
	public int RectCover(int n) {

		if (n <= 0)
			return n;
		if (n == 1)
			return 1;
		int fibOne = 1;
		int fibTwo = 1;
		int fibN = 0;
		for (int i = 2; i <= n; i++) {
			fibN = fibOne + fibTwo;
			fibOne = fibTwo;
			fibTwo = fibN;
		}
		return fibN;
	}

	// �������е�1�ĸ���
	public int NumberOf1(int n) {

		int count = 0;
		while (n != 0) {
			++count;
			n = n & (n - 1);
		}

		return count;
	}

	// ��ֵ�������η�
	public double Power(double base, int exponent) {

		return Math.pow(base, exponent);
	}

	// ��������˳��ʹ����λ��ż��ǰ��
	public void reOrderArray(int[] array) {

		if (array == null || array.length == 0)
			return;
		int len = array.length;
		ArrayList<Integer> evenList = new ArrayList<>();
		int index = 0, currentIndex = 0;
		while (index < len) {
			if (isOddNumber(array[index])) {
				array[currentIndex++] = array[index++];
			} else {
				evenList.add(array[index++]);
			}
		}
		for (int i = currentIndex; i < len; i++) {
			array[i] = evenList.get(i - currentIndex);
		}

	}

	private boolean isOddNumber(int num) {
		return (num % 2) != 0;
	}

	// �����е�����k���ڵ�
	public ListNode FindKthToTail(ListNode head, int k) {

		if (head == null || k <= 0)
			return null;
		ListNode pANode = head;
		ListNode pBNode = null;
		for (int i = 0; i < k - 1; i++) {
			if (pANode.next != null) {
				pANode = pANode.next;
			} else {
				return null;
			}
		}
		pBNode = head;
		while (pANode.next != null) {
			pANode = pANode.next;
			pBNode = pBNode.next;
		}
		return pBNode;
	}

	// ��ת����
	public ListNode ReverseList(ListNode head) {

		if (head == null)
			return null;
		if (head.next == null)
			return head;
		ListNode pAListNode = head;
		ListNode pBListNode = head.next;
		pAListNode.next = null;
		return ReverseList2(pAListNode, pBListNode);
	}

	private ListNode ReverseList2(ListNode nodeA, ListNode nodeB) {

		if (nodeB.next == null) {
			nodeB.next = nodeA;
			return nodeB;
		}

		ListNode tmpNode = nodeB.next;
		nodeB.next = nodeA;

		return ReverseList2(nodeB, tmpNode);
	}

	// �ϲ��������������
	public ListNode Merge(ListNode list1, ListNode list2) {

		if (list1 == null)
			return list2;
		if (list2 == null)
			return list1;
		ListNode head = null;
		if (list1.val < list2.val) {
			head = list1;
			list1 = list1.next;
		} else {
			head = list2;
			list2 = list2.next;
		}
		head.next = Merge(list1, list2);
		return head;
	}

	// �����ӽṹ
	public boolean HasSubtree(TreeNode root1, TreeNode root2) {

		boolean result = false;
		if (root1 != null && root2 != null) {
			if (root1.val == root2.val) {
				result = DoesTree1HaveTree2(root1, root2);
			}
			if (!result) {
				result = HasSubtree(root1.left, root2);
			}
			if (!result) {
				result = HasSubtree(root1.right, root2);
			}
		}
		return result;
	}

	private boolean DoesTree1HaveTree2(TreeNode root1, TreeNode root2) {

		if (root2 == null)
			return true;
		if (root1 == null) {
			return false;
		}
		if (root1.val != root2.val)
			return false;
		return DoesTree1HaveTree2(root1.left, root2.left) && DoesTree1HaveTree2(root1.right, root2.right);
	}

	// �������ľ���
	public void Mirror(TreeNode root) {

		if (root == null) {
			return;
		}
		TreeNode tmpNode = root.left;
		root.left = root.right;
		root.right = tmpNode;

		if (root.left != null) {
			Mirror(root.left);
		}
		if (root.right != null) {
			Mirror(root.right);
		}
	}

	// ˳ʱ���ӡ����
	public ArrayList<Integer> printMatrix(int[][] matrix) {

		if (matrix == null || matrix.length == 0)
			return null;
		int start = 0, rows = matrix[0].length, cols = matrix.length;
		ArrayList<Integer> matrixList = new ArrayList<>();
		while (rows > start * 2 && cols > start * 2) {
			printMatrixCircle(matrix, start, matrixList);
			start++;
		}
		return matrixList;
	}

	private void printMatrixCircle(int[][] matrix, int start, ArrayList<Integer> matrixList) {
		int endX = matrix[0].length - start - 1;
		int endY = matrix.length - start - 1;
		// ������
		for (int i = start; i <= endX; i++) {
			matrixList.add(matrix[start][i]);
		}
		// ���ϵ���
		if (start < endY) {
			for (int i = start + 1; i <= endY; i++) {
				matrixList.add(matrix[i][endX]);
			}
		}
		// right to left
		if (start < endX && start < endY) {
			for (int i = endX - 1; i >= start; i--) {
				matrixList.add(matrix[endY][i]);
			}
		}
		// down to up
		if (start < endX && start < endY - 1) {
			for (int i = endY - 1; i >= start + 1; i--) {
				matrixList.add(matrix[i][start]);
			}
		}
	}

	// ����min������ջ
	public Stack<Integer> dataStack = new Stack<>();
	public Stack<Integer> minStack = new Stack<>();

	public void myPush(int node) {
		dataStack.push(node);
		if (minStack.size() == 0 || node < minStack.peek()) {
			minStack.push(node);
		} else {
			minStack.push(minStack.peek());
		}
	}

	public void myPop() {
		assert (dataStack.size() > 0 && minStack.size() > 0);
		dataStack.pop();
		minStack.pop();
	}

	public int myMin() {

		assert (dataStack.size() > 0 && minStack.size() > 0);
		return minStack.peek();
	}

	// ջ��ѹ�롢��������
	public boolean IsPopOrder(int[] pushA, int[] popA) {

		if (pushA == null || popA == null || pushA.length == 0 || popA.length == 0 || pushA.length != popA.length)
			return false;

		Stack<Integer> pushAStack = new Stack<>();
		int pushAIndex = 0, popAIndex = 0;
		while (popAIndex < popA.length) {
			while (pushAStack.empty() || pushAStack.peek() != popA[popAIndex]) {
				if (pushAIndex == pushA.length)
					break;
				pushAStack.push(pushA[pushAIndex]);
				pushAIndex++;
			}
			if (pushAStack.peek() != popA[popAIndex]) {
				break;
			}
			pushAStack.pop();
			popAIndex++;
		}
		if (pushAStack.empty() && popAIndex == popA.length)
			return true;
		return false;
	}

	// �������´�ӡ������
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

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

	// �����������ĺ����������
	public boolean VerifySquenceOfBST(int[] sequence) {

		if (sequence == null || sequence.length == 0)
			return false;

		return VerifySquence(sequence, 0, sequence.length);
	}

	private boolean VerifySquence(int[] sequence, int start, int len) {

		if (sequence == null || len == 0)
			return false;

		int root = sequence[start + len - 1];

		// ������������������С�ڸ��ڵ�
		int i = 0;
		for (; i < len - 1; i++) {
			if (sequence[i + start] > root)
				break;
		}
		// ���������������������ڸ��ڵ�
		int j = i;
		for (; j < len - 1; j++) {
			if (sequence[j + start] < root)
				return false;
		}
		// �ж��������ǲ��Ƕ���������
		boolean left = true;
		if (i > 0)
			left = VerifySquence(sequence, start, i);
		// �ж�������
		boolean right = true;
		if (i < len - 1)
			right = VerifySquence(sequence, i + start, len - i - 1);
		return (left && right);
	}

	// �������к�Ϊĳһֵ��·��
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

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

	// ����������
	public RandomListNode Clone(RandomListNode pHead) {
		if (pHead == null)
			return null;
		// ����ԭʼ���������ڵ�N�������ڵ�N1���ٰ�n1���ӵ�N�ĺ���
		cloneNodes(pHead);
		// ���ýڵ��random
		connectRandomNodes(pHead);
		// �ֿ�Ϊ��������
		return reconnectNodes(pHead);
	}

	private RandomListNode reconnectNodes(RandomListNode pHead) {

		RandomListNode pNode = pHead;
		RandomListNode pClonedHead = null;
		RandomListNode pClonedNode = null;
		if (pNode != null) {
			pClonedHead = pClonedNode = pNode.next;
			pNode.next = pClonedHead.next;
			pNode = pNode.next;
		}
		while (pNode != null) {
			pClonedNode.next = pNode.next;
			pClonedNode = pClonedNode.next;
			pNode.next = pClonedNode.next;
			pNode = pNode.next;
		}
		return pClonedHead;
	}

	private void connectRandomNodes(RandomListNode pHead) {

		RandomListNode pNode = pHead;
		while (pNode != null) {
			RandomListNode pCloned = pNode.next;
			if (pNode.random != null) {
				pCloned.random = pNode.random.next;
			}
			pNode = pCloned.next;
		}
	}

	private void cloneNodes(RandomListNode pHead) {

		RandomListNode pNode = pHead;
		while (pNode != null) {
			RandomListNode pCloned = new RandomListNode(pNode.label);
			pCloned.next = pNode.next;
			pCloned.random = null;

			pNode.next = pCloned;
			pNode = pCloned.next;
		}
	}

	public class RandomListNode {
		int label;
		RandomListNode next = null;
		RandomListNode random = null;

		RandomListNode(int label) {
			this.label = label;
		}
	}

	// ������������˫������
	public TreeNode Convert(TreeNode pRootOfTree) {
		if (pRootOfTree == null)
			return null;
		TreeNode pLastNodeInList = null;
		pLastNodeInList = convertNode(pRootOfTree, pLastNodeInList);

		TreeNode pHeadOfList = pLastNodeInList;

		while (pHeadOfList != null && pHeadOfList.left != null) {
			pHeadOfList = pHeadOfList.left;
		}
		return pHeadOfList;
	}

	private TreeNode convertNode(TreeNode pRootOfTree, TreeNode pLastNodeInList) {

		if (pRootOfTree == null)
			return null;
		TreeNode pCurrent = pRootOfTree;

		if (pCurrent.left != null)
			pLastNodeInList = convertNode(pCurrent.left, pLastNodeInList);
		pCurrent.left = pLastNodeInList;
		if (pLastNodeInList != null) {
			pLastNodeInList.right = pCurrent;
		}
		pLastNodeInList = pCurrent;
		if (pCurrent.right != null)
			pLastNodeInList = convertNode(pCurrent.right, pLastNodeInList);
		return pLastNodeInList;
	}

	// �ַ���������
	public ArrayList<String> Permutation(String str) {

		ArrayList<String> result = new ArrayList<String>();
		if (str == null || str.length() == 0) {
			return result;
		}

		char[] chars = str.toCharArray();
		TreeSet<String> temp = new TreeSet<>();
		Permutation(chars, 0, temp);
		result.addAll(temp);
		return result;
	}

	public void Permutation(char[] chars, int begin, TreeSet<String> result) {
		if (chars == null || chars.length == 0 || begin < 0 || begin > chars.length - 1) {
			return;
		}

		if (begin == chars.length - 1) {
			result.add(String.valueOf(chars));
			System.out.println(String.valueOf(chars));
		} else {
			for (int i = begin; i <= chars.length - 1; i++) {
				swap(chars, begin, i);

				Permutation(chars, begin + 1, result);

				swap(chars, begin, i);
			}
		}
	}

	public void swap(char[] x, int a, int b) {
		char t = x[a];
		x[a] = x[b];
		x[b] = t;
	}

	// �����г��ִ�������һ�������
	public int MoreThanHalfNum_Solution(int[] array) {

		if (array == null || array.length == 0)
			return 0;
		int result = array[0];
		int times = 1;
		for (int i = 1, len = array.length; i < len; i++) {
			if (times == 0) {
				result = array[i];
				times = 1;
			} else if (array[i] == result) {
				times++;
			} else {
				times--;
			}
		}
		if (checkMoreThanHalf(array, result))
			return result;
		return 0;
	}

	public boolean checkMoreThanHalf(int[] array, int results) {

		int times = 0;
		for (int i = 0, len = array.length; i < len; i++) {
			if (array[i] == results)
				times++;
		}

		return times > array.length / 2 ? true : false;
	}

	// ��С��k����
	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {

		ArrayList<Integer> tmpList = new ArrayList<>();

		if (input == null || input.length == 0 || k > input.length || k <= 0)
			return tmpList;
		int[] maxHeap = new int[k];
		for (int i = 0, len = input.length; i < len; i++) {
			if (i < k) {
				maxHeap[i] = input[i];
			} else {

				if (maxHeap[k - 1] > input[i]) {
					maxHeap[k - 1] = input[i];
					heapSort(maxHeap);
				}
			}
			if (i == k - 1)
				heapSort(maxHeap);
		}

		for (int i = 0; i < k; i++) {
			tmpList.add(maxHeap[i]);
		}
		return tmpList;
	}

	private void heapSort(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		for (int len = nums.length, i = len / 2 - 1; i >= 0; --i) {
			percDown(nums, i, len);
		}
		for (int i = nums.length - 1; i > 0; i--) {
			swapReference(nums, 0, i);
			percDown(nums, 0, i);
		}
	}

	private void percDown(int[] nums, int i, int len) {

		int child = 0;
		int tmp = 0;
		for (tmp = nums[i]; leftChild(i) < len; i = child) {
			child = leftChild(i);
			if (child != len - 1 && nums[child] < nums[child + 1])
				child++;
			if (tmp < nums[child])
				nums[i] = nums[child];
			else
				break;
		}
		nums[i] = tmp;
	}

	private int leftChild(int i) {

		return 2 * i + 1;
	}

	/*
	 * private int partition(int[] nums, int start, int end) {
	 * 
	 * if (nums == null || nums.length == 0 || start < 0 || end >= nums.length)
	 * return 0; int index = RandomInRange(start, end);
	 * System.out.println(index); swapReference(nums, index, end); int small =
	 * start - 1; for (index = start; index < end; ++index) { if (nums[index] <
	 * nums[end]) { ++small; if (small != index) swapReference(nums, index,
	 * small); } } ++small; swapReference(nums, small, end);
	 * 
	 * return small; }
	 * 
	 * private int RandomInRange(int start, int end) { Random random = new
	 * Random(); return random.nextInt(end - start) + start; }
	 */

	private void swapReference(int[] nums, int i, int j) {

		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	// ���������������
	public int FindGreatestSumOfSubArray(int[] array) {

		if (array == null || array.length == 0)
			return 0;

		int maxSub = array[0], tmpMaxSub = array[0];

		for (int i = 1, len = array.length; i < len; i++) {
			tmpMaxSub = Math.max(tmpMaxSub + array[i], array[i]);
			maxSub = Math.max(tmpMaxSub, maxSub);
		}

		return maxSub;
	}

	// ������һ���ֵĴ���
	public int NumberOf1Between1AndN_Solution(int n) {

		if (n < 1)
			return 0;
		int ones = 0;
		for (long m = 1; m <= n; m *= 10)
			ones += (n / m + 8) / 10 * m + (n / m % 10 == 1 ? n % m + 1 : 0);
		return ones;
	}

	// �������ų���С����
	public String PrintMinNumber(int[] numbers) {

		if (numbers == null || numbers.length == 0)
			return new String();
		String[] strings = new String[numbers.length];
		for (int i = 0, len = numbers.length; i < len; i++) {
			strings[i] = String.valueOf(numbers[i]);
		}
		Arrays.sort(strings, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				int o1Len = o1.length();
				int o2Len = o2.length();
				int i = 0, j = 0;
				boolean iFlag = true, jFlag = true;

				while (i < o1Len && j < o2Len) {
					if (o1.charAt(i) < o2.charAt(j)) {
						return -1;
					} else if (o1.charAt(i) > o2.charAt(j)) {
						return 1;
					}
					i++;
					j++;
					if (i >= o1Len && jFlag) {
						i = 0;
						iFlag = false;
					}
					if (j >= o2Len && iFlag) {
						j = 0;
						jFlag = false;
					}
				}
				return 0;
			}
		});
		StringBuilder stringBuilder = new StringBuilder();
		for (String string : strings) {
			stringBuilder.append(string);
		}
		return stringBuilder.toString();
	}

	// ����
	public int GetUglyNumber_Solution(int index) {

		if (index <= 0) {
			return 0;
		}
		int[] uglyNums = new int[index];
		int count = 0;
		int i2 = 0;
		int i3 = 0;
		int i5 = 0;
		uglyNums[0] = 1;
		int tmp = 0;
		while (count < index - 1) {
			tmp = min(uglyNums[i2] * 2, uglyNums[i3] * 3, uglyNums[i5] * 5);
			if (tmp == uglyNums[i2] * 2)
				i2++;
			if (tmp == uglyNums[i3] * 3)
				i3++;
			if (tmp == uglyNums[i5] * 5)
				i5++;
			uglyNums[++count] = tmp;
		}
		return uglyNums[index - 1];
	}

	private int min(int i, int j, int k) {
		int min = i > j ? j : i;
		return min > k ? k : min;
	}

	// ��һ��ֻ����һ�ε��ַ�
	public int FirstNotRepeatingChar(String str) {

		if (str == null || str.length() == 0)
			return -1;
		HashMap<Character, Integer> hashMap = new HashMap<>();
		for (int i = 0, len = str.length(); i < len; i++) {
			char c = str.charAt(i);
			if (hashMap.containsKey(c)) {
				hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
			} else {
				hashMap.put(c, 1);
			}
		}
		for (int i = 0, len = str.length(); i < len; i++) {
			char c = str.charAt(i);
			if (hashMap.get(c) == 1)
				return i;
		}
		return -1;
	}

	// �����е������
	public int InversePairs(int[] array) {

		if (array == null || array.length == 0)
			return 0;
		int[] copyArr = new int[array.length];
		int count = inversePairsCore(array, copyArr, 0, array.length - 1);
		return count;
	}

	private int inversePairsCore(int[] array, int[] copyArr, int start, int end) {

		if (start == end) {
			copyArr[start] = array[start];
			return 0;
		}
		int len = (end - start) / 2;

		int left = inversePairsCore(array, copyArr, start, start + len) % 1000000007;
		int right = inversePairsCore(array, copyArr, start + len + 1, end) % 1000000007;

		// i��ʼ��Ϊǰ������һ�����ֵ��±�
		// j��ʼ��Ϊ���ε����һ�����ֵ��±�
		int i = start + len;
		int j = end;
		int indexCopy = end;
		int count = 0;
		while (i >= start && j >= start + len + 1) {
			if (array[i] > array[j]) {
				copyArr[indexCopy--] = array[i--];
				count += j - start - len;
				if (count >= 1000000007)// ��ֵ��������
				{
					count %= 1000000007;
				}
			} else {
				copyArr[indexCopy--] = array[j--];
			}
		}
		for (; i >= start; --i)
			copyArr[indexCopy--] = array[i];
		for (; j >= start + len + 1; --j)
			copyArr[indexCopy--] = array[j];
		System.arraycopy(copyArr, start, array, start, end - start + 1);

		return (left + right + count) % 1000000007;
	}

	// ���������һ�������ڵ�
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

		if (pHead1 == null || pHead2 == null)
			return null;
		int pHead1Len = getLength(pHead1);
		int pHead2Len = getLength(pHead2);
		int firstGo = 0;
		if (pHead1Len >= pHead2Len) {
			firstGo = pHead1Len - pHead2Len;
			while (firstGo > 0) {
				pHead1 = pHead1.next;
				firstGo--;
			}
			while (pHead1 != null && pHead2 != null) {
				if (pHead1 == pHead2) {
					return pHead1;
				} else {
					pHead1 = pHead1.next;
					pHead2 = pHead2.next;
				}
			}
		} else {
			firstGo = pHead2Len - pHead1Len;
			while (firstGo > 0) {
				pHead2 = pHead2.next;
				firstGo--;
			}
			while (pHead1 != null && pHead2 != null) {
				if (pHead1 == pHead2) {
					return pHead1;
				} else {
					pHead1 = pHead1.next;
					pHead2 = pHead2.next;
				}
			}
		}
		return null;
	}

	private int getLength(ListNode pHead) {

		int count = 0;
		while (pHead != null) {
			pHead = pHead.next;
			count++;
		}

		return count;
	}

	// ���������������г��ֵĴ���
	public int GetNumberOfK(int[] array, int k) {

		if (array == null || array.length == 0)
			return 0;
		int firstPos = getFirstPos(array, k, 0, array.length - 1);
		int lastPos = getLastPos(array, k, 0, array.length - 1);
		if (firstPos > -1 && lastPos > -1)
			return lastPos - firstPos + 1;
		return 0;
	}

	private int getFirstPos(int[] array, int k, int start, int end) {

		if (start > end)
			return -1;
		int middleIndex = (start + end) / 2;
		int middleData = array[middleIndex];
		if (middleData == k) {
			if (middleIndex > 0 && array[middleIndex - 1] != k || middleIndex == 0)
				return middleIndex;
			else
				end = middleIndex - 1;
		} else if (middleData > k) {
			end = middleIndex - 1;
		} else {
			start = middleIndex + 1;
		}
		return getFirstPos(array, k, start, end);
	}

	private int getLastPos(int[] array, int k, int start, int end) {
		if (start > end)
			return -1;
		int middleIndex = (start + end) / 2;
		int middleData = array[middleIndex];

		if (middleData == k) {
			if (middleIndex < array.length - 1 && array[middleIndex + 1] != k || middleIndex == array.length - 1) {
				return middleIndex;
			} else {
				start = middleIndex + 1;
			}
		} else if (middleData < k) {
			start = middleIndex + 1;
		} else {
			end = middleIndex - 1;
		}

		return getLastPos(array, k, start, end);
	}

	// �����������
	public int TreeDepth(TreeNode root) {

		if (root == null)
			return 0;
		int left = TreeDepth(root.left);
		int right = TreeDepth(root.right);

		return Math.max(left, right) + 1;
	}

	// ƽ�������
	private boolean isBalanced = true;

	public boolean IsBalanced_Solution(TreeNode root) {

		if (root == null)
			return true;
		getBalancedFactor(root);

		return isBalanced;
	}

	private int getBalancedFactor(TreeNode root) {

		if (root == null)
			return 0;
		int left = getBalancedFactor(root.left);
		int right = getBalancedFactor(root.right);
		if (left - right > 1 || left - right < -1) {
			isBalanced = false;
		}
		return right > left ? right + 1 : left + 1;
	}

	// ������ֻ����һ�ε�����
	public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {

		if (array == null || array.length == 0 || num1 == null || num2 == null)
			return;
		int result = 0;
		for (int i = 0, len = array.length; i < len; i++) {
			result ^= array[i];
		}
		int indexOf1 = findFirstBitIs1(result);
		for (int i = 0, len = array.length; i < len; i++) {
			if (IsBit1(array[i], indexOf1)) {
				num2[0] ^= array[i];
			} else {
				num1[0] ^= array[i];
			}
		}
	}

	private boolean IsBit1(int num, int indexBit) {
		num = num >> indexBit;
		return (num & 1) == 1 ? true : false;
	}

	private int findFirstBitIs1(int result) {

		int indexBit = 0;
		while ((result & 1) == 0) {
			result = result >> 1;
			++indexBit;
		}
		return indexBit;
	}

	// ��ΪS��������������
	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		if (sum < 0)
			return list;
		int index = 1, small = 1, big = 1, tmpCount = 0;
		while (index <= sum) {
			if (tmpCount == sum) {
				ArrayList<Integer> tmpList = new ArrayList<>();
				for (int i = small; i <= big; i++) {
					tmpList.add(i);
				}
				list.add(tmpList);
				tmpCount -= small;
				small++;
			} else if (tmpCount < sum) {
				tmpCount += index;
				big = index;
				index++;
			} else {
				tmpCount -= small;
				small++;
			}
		}
		return list;
	}

	// ��ΪS����������
	public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {

		ArrayList<Integer> arrayList = new ArrayList<>();
		if (array == null || array.length == 0) {
			return arrayList;
		}
		int left = 0, right = array.length - 1;
		while (left < right) {
			if (array[right] >= sum) {
				right--;
			} else if (array[left] + array[right] == sum) {
				arrayList.add(array[left]);
				arrayList.add(array[right]);
				break;
			} else {
				left++;
			}
		}
		return arrayList;
	}

	// ����ת�ַ���
	public String LeftRotateString(String str, int n) {

		if (str == null || str.length() == 0 || n <= 0 || n >= str.length())
			return str;
		String subStrLeft = str.substring(0, n);
		String subStrRight = str.substring(n, str.length());
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(subStrRight);
		stringBuilder.append(subStrLeft);
		return stringBuilder.toString();
	}

	// ��ת����˳������
	public String ReverseSentence(String str) {

		if (str == null)
			return str;
		char[] strArr = str.toCharArray();
		reverse(strArr, 0, strArr.length - 1);

		int left = 0, right = 0;
		while (left < strArr.length && right < strArr.length) {
			if (strArr[left] == ' ') {
				left++;
				right++;
			} else if (strArr[right] == ' ') {
				reverse(strArr, left, right - 1);
				left = ++right;
			} else if (right == strArr.length - 1) {
				reverse(strArr, left, right);
				left = ++right;
			} else {
				right++;
			}
		}
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0, len = strArr.length; i < len; i++) {
			stringBuilder.append(strArr[i]);
		}
		return stringBuilder.toString();
	}

	public void reverse(char[] strArr, int left, int right) {
		if (strArr == null || strArr.length == 0 || left < 0 || right >= strArr.length)
			return;
		while (left < right) {
			char c = strArr[left];
			strArr[left] = strArr[right];
			strArr[right] = c;
			left++;
			right--;
		}
	}

	// �˿���˳��
	public boolean isContinuous(int[] numbers) {

		if (numbers == null || numbers.length == 0 || numbers.length != 5)
			return false;
		int zeroCount = 0;
		int len = numbers.length;
		Arrays.sort(numbers);
		for (int i = 0; i < len && numbers[i] == 0; i++) {
			zeroCount++;
		}
		int numbersGap = 0;
		int small = zeroCount;
		int big = small + 1;
		while (big < len) {
			if (numbers[small] == numbers[big]) {
				return false;
			}
			numbersGap += numbers[big] - numbers[small] - 1;
			small = big;
			++big;
		}
		return (numbersGap > zeroCount) ? false : true;
	}

	// ԲȦ�����ʣ�µ���(Լɪ��)
	public int LastRemaining_Solution(int n, int m) {

		if (n < 1 || m < 1)
			return -1;
		LinkedList<Integer> circleList = new LinkedList<>();
		for (int i = 0; i < n; i++)
			circleList.add(i);
		int index = 0, num = 9;
		while (circleList.size() > 1) {
			int tmpIndex = (index + m - 1) % circleList.size();
			index = (tmpIndex + 1) % circleList.size();
			num = circleList.get(index);
			circleList.remove(tmpIndex);
			index = circleList.indexOf(num);
		}

		return circleList.removeFirst();
	}

	// ��1+2+3+...+nҪ����ʹ�ó˳�����for��while��if��else��switch��case�ȹؼ��ּ������ж���䣨A?B:C����
	public int Sum_Solution(int n) {
		int sum = n;
		boolean res = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
		return sum;
	}

	// ���Ӽ��˳����ӷ�
	public int Add(int num1, int num2) {

		int sum = 0, carry = 0;
		do {
			sum = num1 ^ num2;
			carry = (num1 & num2) << 1;
			num1 = sum;
			num2 = carry;
		} while (num2 != 0);

		return num1;
	}

	// �ַ���ת��������
	private boolean illegal = false;

	public int StrToInt(String str) {

		if (str == null || str.length() == 0) {
			illegal = true;
			return 0;
		}

		int index = 0;
		if (str.charAt(index) == '+' || str.charAt(index) == '-')
			index++;
		while (index < str.length() && (Character.isDigit(str.charAt(index)))) {
			index++;
		}
		if (index == str.length() && index > 1)
			return Integer.valueOf(str);

		return 0;
	}

	/*
	 * 
	 * -------------------------------------------------------------------------
	 * 
	 */
	// �������ظ�������
	public boolean duplicate(int numbers[], int length, int[] duplication) {

		if (numbers == null || numbers.length == 0 || duplication == null || duplication.length != 1
				|| numbers.length != length)
			return false;
		Boolean[] boolArr = new Boolean[length];
		for (int i = 0; i < length; i++)
			boolArr[i] = false;
		for (int i = 0; i < length; i++) {
			if (boolArr[numbers[i]]) {
				duplication[0] = numbers[i];
				return true;
			} else {
				boolArr[numbers[i]] = true;
			}
		}
		return false;
	}

	// �����˻�����
	public int[] multiply(int[] A) {

		if (A == null || A.length == 0)
			return null;
		int len = A.length;
		int[] B = new int[len];
		// ʱ�临�Ӷȸߣ�Ч�ʵ�
		// for(int i=0,len=A.length;i<len;i++)
		// B[i]=1;
		// for(int i=0,len=A.length;i<len;i++){
		// for(int j=0;j<len;j++){
		// if(j!=i){
		// B[i]*=A[j];
		// }
		// }
		// }

		// ��Ϊ����ǰi-1�ͺ�n-i������������
		int[] forword = new int[len];
		int[] backword = new int[len];

		forword[0] = 1;
		backword[0] = 1;

		for (int i = 1; i < len; i++) {
			forword[i] = A[i - 1] * forword[i - 1];
			backword[i] = A[len - i] * backword[i - 1];
		}
		for (int i = 0; i < len; i++) {
			B[i] = forword[i] * backword[len - i - 1];
		}

		return B;
	}

	// ������ʽ
	public boolean match(char[] str, char[] pattern) {
		if (str == null | pattern == null)
			return false;
		if (str.length == 0 && pattern.length == 0)
			return true;

		String s1 = String.valueOf(str);
		String s2 = String.valueOf(pattern);

		if (s1.equals(s2))
			return true;

		Pattern p = Pattern.compile(s2);
		Matcher m = p.matcher(s1);
		return m.matches();
	}

	// ��ʾ��ֵ���ַ���
	public boolean isNumeric(char[] str) {

		if (str == null || str.length == 0)
			return false;
		String string = String.valueOf(str);
		String regex = "[+-]?[0-9]*(\\.[0-9]*)?([eE][+-]?[0-9]+)?";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(string);
		return matcher.matches();
	}

	// �ַ����е�һ�����ظ����ַ�
	private int[] count = new int[256];
	private int index = 1;
	private final int Length = 256;

	// Insert one char from stringstream
	public void Insert(char ch) {
		if (count[ch] == 0) {
			count[ch] = index++;
		} else {
			count[ch] = -1;
		}
	}

	// return the first appearence once char in current stringstream
	public char FirstAppearingOnce() {
		int temp = Integer.MAX_VALUE;
		char ch = '#';
		for (int i = 0; i < Length; i++) {
			if (count[i] != 0 && count[i] != -1 && count[i] < temp) {
				temp = count[i];
				ch = (char) i;
			}
		}
		return ch;
	}

	// �����л�����ڽ��
	public ListNode EntryNodeOfLoop(ListNode pHead) {

		if (pHead == null)
			return null;
		ListNode p1 = pHead;
		ListNode p2 = pHead;
		while (p2 != null && p2.next != null) {
			p1 = p1.next;
			p2 = p2.next.next;
			if (p1 == p2) {
				p2 = pHead;
				while (p1 != p2) {
					p1 = p1.next;
					p2 = p2.next;
				}
				if (p1 == p2)
					return p1;
			}
		}
		return p1;
	}

	// ɾ���������ظ��Ľ��
	public ListNode deleteDuplication(ListNode pHead) {

		if (pHead == null)
			return null;
		ListNode tmpHead = null;
		if (pHead.val != -1) {
			tmpHead = new ListNode(-1);
		} else {
			tmpHead = new ListNode(-2);
		}
		tmpHead.next = pHead;
		ListNode p = tmpHead;
		ListNode q = tmpHead.next;

		while (q != null) {
			while (q.next != null && (q.next.val == q.val)) {
				q = q.next;
			}
			if (p.next != q) {
				q = q.next;
				p.next = q;
			} else {
				p = q;
				q = q.next;
			}
		}
		return tmpHead.next;
	}

	// ����������һ�����

	public class TreeLinkNode {
		int val;
		TreeLinkNode left = null;
		TreeLinkNode right = null;
		TreeLinkNode next = null;

		TreeLinkNode(int val) {
			this.val = val;
		}
	}

	public TreeLinkNode GetNext(TreeLinkNode pNode) {

		if (pNode == null)
			return null;
		if (pNode.right != null) {
			pNode = pNode.right;
			while (pNode.left != null) {
				pNode = pNode.left;
			}
			return pNode;
		}
		while (pNode.next != null) {
			if (pNode.next.left == pNode)
				return pNode.next;
			pNode = pNode.next;
		}
		return null;
	}

	// �Գƶ�����
	public boolean isSymmetrical(TreeNode pRoot) {

		if (pRoot == null || (pRoot.left == null && pRoot.right == null)) {
			return true;
		} else if (pRoot.left != null && pRoot.right != null) {
			if (pRoot.left.val != pRoot.right.val)
				return false;
		} else {
			return false;
		}
		return isSym(pRoot.left, pRoot.right);
	}

	private boolean isSym(TreeNode left, TreeNode right) {

		boolean l = false, r = false;
		if (left != null && right != null) {

			if (left.val == right.val) {
				l = isSym(left.left, right.right);
				r = isSym(left.right, right.left);
				if (l && r)
					return true;
			}
		} else if (left == null && right == null) {
			return true;
		}
		return false;
	}

	// ��֮����ʽ˳���ӡ������
	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

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

	// �Ѷ�������ӡ�ɶ���
	ArrayList<ArrayList<Integer>> Printh(TreeNode pRoot) {
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

	// �����������ĵ�k�����
	private int kThIndex = 0;
	private TreeNode KTHNODE = null;

	public TreeNode KthNode(TreeNode pRoot, int k) {

		if (pRoot == null || k <= 0)
			return KTHNODE;
		kThIndex = k;
		KthNodeInOrder(pRoot);
		return KTHNODE;
	}

	private void KthNodeInOrder(TreeNode pRoot) {
		TreeNode tmp = null;
		if (pRoot != null) {
			KthNodeInOrder(pRoot.left);
			if (kThIndex == 1) {
				KTHNODE = pRoot;
			}
			kThIndex--;
			KthNodeInOrder(pRoot.right);
		}
	}

	// �������е�������
	private ArrayList<Integer> arrayList = new ArrayList<>();

	public void Insert(Integer num) {
		arrayList.add(num);
		arrayList.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1 == o2) {
					return 0;
				} else if (o1 > o2) {
					return 1;
				}
				return -1;
			}
		});
	}

	public Double GetMedian() {

		if (arrayList.isEmpty())
			return -1.0;
		int index = arrayList.size() / 2;
		if (arrayList.size() % 2 == 0) {
			return (arrayList.get(index - 1) + arrayList.get(index)) / 2.0;
		} else {
			return arrayList.get(index) / 2.0;
		}
	}

	// �������ڵ����ֵ
	public ArrayList<Integer> maxInWindows(int[] num, int size) {

		ArrayList<Integer> list = new ArrayList<>();
		if (num == null || num.length == 0 || size < 1)
			return list;
		LinkedList<Integer> temp = new LinkedList<>();
		int len = num.length;
		if (len >= size) {
			int index = 0;
			while (index < size) {
				temp.add(num[index]);
				index++;
			}
			list.add(Collections.max(temp));
			while (index < len) {
				temp.removeFirst();
				temp.add(num[index]);
				list.add(Collections.max(temp));
				index++;
			}
		} else {
			return list;
		}
		return list;
	}

	// �����е�·��
	public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {

		if (matrix == null || str == null || matrix.length == 0 || str.length == 0)
			return false;

		for (int i = 0, len = matrix.length; i < len; i++) {
			if (exist(matrix, rows, cols, i, str, 0))
				return true;
		}

		return false;
	}

	private boolean exist(char[] board, int rows, int cols, int index, char[] word, int start) {

		if (start >= word.length)
			return true;
		if (index < 0 || index >= board.length)
			return false;
		if (board[index] == word[start++]) {
			char c = board[index];
			board[index] = '#';
			boolean res = exist(board, rows, cols, cols + index, word, start)
					|| exist(board, rows, cols, index + 1, word, start)
					|| exist(board, rows, cols, index - cols, word, start)
					|| exist(board, rows, cols, index - 1, word, start);
			board[index] = c;
			return res;
		}
		return false;
	}

	// �����˵��˶���Χ
	public int movingCount(int threshold, int rows, int cols) {
		if (threshold < 0 || rows < 0 || cols < 0)
			return 0;
		boolean[][] matrix = new boolean[rows][cols];

		return canMove(matrix, 0, 0, threshold);
	}

	private int canMove(boolean[][] matrix, int i, int j, int threshold) {

		if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length)
			return 0;

		if (!canIn(i, j, threshold))
			return 0;

		if (!matrix[i][j]) {
			matrix[i][j] = true;

			return 1 + canMove(matrix, i + 1, j, threshold) + canMove(matrix, i, j + 1, threshold)
					+ +canMove(matrix, i - 1, j, threshold) + canMove(matrix, i, j - 1, threshold);
		}
		return 0;
	}

	private boolean canIn(int i, int j, int threshold) {

		int sum = 0;
		while (i != 0) {
			sum += i % 10;
			i = i / 10;
		}
		while (j != 0) {
			sum += j % 10;
			j = j / 10;
		}
		if (sum > threshold)
			return false;
		return true;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] arr = { 2, 3, 1, 0, 2, 5, 3 };
		int[] arr2 = { 0 };

	}
}
