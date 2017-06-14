/*
 * ��Ŀ����
 *	����һ����������ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬
 *	һ��ָ����һ���ڵ㣬��һ������ָ��ָ������һ���ڵ㣩��
 *	���ؽ��Ϊ���ƺ��������head��
 *	��ע�⣬���������벻Ҫ���ز����еĽڵ����ã�������������ֱ�ӷ��ؿգ�
 * */
public class Clone {

	// ����������
	public RandomListNode clone(RandomListNode pHead) {
		if (pHead == null)
			return null;
		// ����ԭʼ���������ڵ�N�������ڵ�N1���ٰ�n1���ӵ�N�ĺ���
		cloneNodes(pHead);
		// ���ýڵ��random
		connectRandomNodes(pHead);
		// �ֿ�Ϊ��������
		return reconnectNodes(pHead);
	}

	private RandomListNode reconnectNodes(RandomListNode pHead) {

		RandomListNode pNode = pHead;
		RandomListNode pClonedHead = null;
		RandomListNode pClonedNode = null;
		if (pNode != null) {
			pClonedHead = pClonedNode = pNode.next;
			pNode.next = pClonedHead.next;
			pNode = pNode.next;
		}
		while (pNode != null) {
			pClonedNode.next = pNode.next;
			pClonedNode = pClonedNode.next;
			pNode.next = pClonedNode.next;
			pNode = pNode.next;
		}
		return pClonedHead;
	}

	private void connectRandomNodes(RandomListNode pHead) {

		RandomListNode pNode = pHead;
		while (pNode != null) {
			RandomListNode pCloned = pNode.next;
			if (pNode.random != null) {
				pCloned.random = pNode.random.next;
			}
			pNode = pCloned.next;
		}
	}

	private void cloneNodes(RandomListNode pHead) {

		RandomListNode pNode = pHead;
		while (pNode != null) {
			RandomListNode pCloned = new RandomListNode(pNode.label);
			pCloned.next = pNode.next;
			pCloned.random = null;

			pNode.next = pCloned;
			pNode = pCloned.next;
		}
	}

	public class RandomListNode {
		int label;
		RandomListNode next = null;
		RandomListNode random = null;

		RandomListNode(int label) {
			this.label = label;
		}
	}

}
