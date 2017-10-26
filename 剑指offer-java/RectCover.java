/*
 * ��Ŀ����:
 *	���ǿ�����2*1��С���κ��Ż�������ȥ���Ǹ���ľ��Ρ�
 *	������n��2*1��С�������ص��ظ���һ��2*n�Ĵ���Σ��ܹ��ж����ַ�����
 * 
 * */
public class RectCover {

	// ���󸲸�
	public int rectCover(int n) {

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
