/*
 * ��Ŀ����
 *	���������������������������������ϳɺ������
 *	��Ȼ������Ҫ�ϳɺ���������㵥����������
 * 
 * */

public class Merge {

	// �ϲ��������������
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
