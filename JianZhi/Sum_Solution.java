/*
 * ��Ŀ����
 * 	��1+2+3+...+n��Ҫ����ʹ�ó˳�����for��while��if��else��switch��case��
 * �ؼ��ּ������ж���䣨A?B:C����
 * */
public class Sum_Solution {

	// ��1+2+3+...+nҪ����ʹ�ó˳�����for��while��if��else��switch��case�ȹؼ��ּ������ж���䣨A?B:C����
	public int sum_Solution(int n) {
		int sum = n;
		boolean res = (n > 0) && ((sum += sum_Solution(n - 1)) > 0);
		return sum;
	}
}
