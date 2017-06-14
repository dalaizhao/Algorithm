
/*
 * ��Ŀ����
 *	����һ����������������е�����k����㡣
 * */
public class FindKthToTail {

	// �����е�����k���ڵ�
	public ListNode findKthToTail(ListNode head, int k) {

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

	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}
}
