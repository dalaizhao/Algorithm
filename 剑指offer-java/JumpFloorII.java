/*
 * ��Ŀ����:
 *	һֻ����һ�ο�������1��̨�ף�Ҳ��������2��������Ҳ��������n����
 *	�����������һ��n����̨���ܹ��ж�����������
 * */
public class JumpFloorII {

	// ��̬��̨��
	public int jumpFloorII(int target) {

		if (target <= 0) {
			return target;
		}
		// ��ѧ���ɷ����Եõ�f(n)=2^(n-1)
		return (int) Math.pow(2, target - 1);
	}
}
