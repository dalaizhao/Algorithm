/*
 * 题目描述
 *	一个链表中包含环，请找出该链表的环的入口结点。
 * */

public class EntryNodeOfLoop {

	// 链表中环的入口结点
	public ListNode entryNodeOfLoop(ListNode pHead) {

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

	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}
}
