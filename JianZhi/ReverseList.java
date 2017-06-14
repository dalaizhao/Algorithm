
/*
 * ��Ŀ����
 *	����һ��������ת�����������������Ԫ�ء�
 * */
public class ReverseList {

	// ��ת����
	public ListNode reverseList(ListNode head) {

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

	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}
}
