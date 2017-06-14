/*
 * 题目描述
 *	输入两个单调递增的链表，输出两个链表合成后的链表，
 *	当然我们需要合成后的链表满足单调不减规则。
 * 
 * */

public class Merge {

	// 合并两个排序的链表
	public ListNode merge(ListNode list1, ListNode list2) {

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
		head.next = merge(list1, list2);
		return head;
	}

	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}
}
