/*
 * ��Ŀ����:
 *	һֻ����һ�ο�������1��̨�ף�Ҳ��������2����
 *	�����������һ��n����̨���ܹ��ж�����������
 * */
public class JumpFloor {

	// ��̨��
	public int jumpFloor(int n) {
		if (n <= 0)
			return n;
		if (n == 1)
			return 1;
		int fibOne = 1;
		int fibTwo = 1;
		int fibN = 0;
		for (int i = 2; i <= n; i++) {
			fibN = fibOne + fibTwo;
			fibOne = fibTwo;
			fibTwo = fibN;
		}
		return fibN;
	}
}
