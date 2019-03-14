/*
 * ��Ŀ����
 *	��һ������������У������ظ��Ľ�㣬��ɾ�����������ظ��Ľ�㣬�ظ��Ľ�㲻��������������ͷָ�롣
 *	 ���磬����1->2->3->3->4->4->5 �����Ϊ 1->2->5
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
}
