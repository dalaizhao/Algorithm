import java.util.ArrayList;

/*
 * 题目描述:
 *	输入一个链表，从尾到头打印链表每个节点的值。
 * 
 * */
public class PrintListFromTailToHead {
	// 从尾到头打印链表
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
}
