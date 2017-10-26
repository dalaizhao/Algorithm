/*
 * 题目描述
 *	输入一个复杂链表（每个节点中有节点值，以及两个指针，
 *	一个指向下一个节点，另一个特殊指针指向任意一个节点），
 *	返回结果为复制后复杂链表的head。
 *	（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * */
public class Clone {

	// 复杂链表复制
	public RandomListNode clone(RandomListNode pHead) {
		if (pHead == null)
			return null;
		// 复制原始链表的任意节点N并创建节点N1，再把n1链接到N的后面
		cloneNodes(pHead);
		// 设置节点的random
		connectRandomNodes(pHead);
		// 分开为两个链表
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

}
