/*
 * 题目描述
 *	在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 *	 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * 
 * */
public class DeleteDuplication {

	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	// 删除链表中重复的结点
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
}
