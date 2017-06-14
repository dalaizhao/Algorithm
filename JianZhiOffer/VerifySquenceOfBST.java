
/*��Ŀ����
 *	����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ����
 *	����������Yes,�������No��
 *	�������������������������ֶ�������ͬ��
 **/
public class VerifySquenceOfBST {

	// �����������ĺ����������
	public boolean verifySquenceOfBST(int[] sequence) {

		if (sequence == null || sequence.length == 0)
			return false;

		return verifySquence(sequence, 0, sequence.length);
	}

	private boolean verifySquence(int[] sequence, int start, int len) {

		if (sequence == null || len == 0)
			return false;

		int root = sequence[start + len - 1];

		// ������������������С�ڸ��ڵ�
		int i = 0;
		for (; i < len - 1; i++) {
			if (sequence[i + start] > root)
				break;
		}
		// ���������������������ڸ��ڵ�
		int j = i;
		for (; j < len - 1; j++) {
			if (sequence[j + start] < root)
				return false;
		}
		// �ж��������ǲ��Ƕ���������
		boolean left = true;
		if (i > 0)
			left = verifySquence(sequence, start, i);
		// �ж�������
		boolean right = true;
		if (i < len - 1)
			right = verifySquence(sequence, i + start, len - i - 1);
		return (left && right);
	}
}
