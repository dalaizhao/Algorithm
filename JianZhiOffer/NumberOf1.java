/*
 * ��Ŀ����
 *	����һ��������������������Ʊ�ʾ��1�ĸ��������и����ò����ʾ��
 * */
public class NumberOf1 {

	// �������е�1�ĸ���
	public int numberOf1(int n) {

		int count = 0;
		while (n != 0) {
			++count;
			n = n & (n - 1);
		}

		return count;
	}
}
