/*
 * 
 * 题目描述
 *	输入两个链表，找出它们的第一个公共结点。
 * 
 * */

public class FindFirstCommonNode {

	// 两个链表第一个公共节点
	public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {

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

	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}
}
