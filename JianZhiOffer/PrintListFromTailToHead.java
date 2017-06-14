import java.util.ArrayList;

/*
 * ��Ŀ����:
 *	����һ��������β��ͷ��ӡ����ÿ���ڵ��ֵ��
 * 
 * */
public class PrintListFromTailToHead {
	// ��β��ͷ��ӡ����
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
