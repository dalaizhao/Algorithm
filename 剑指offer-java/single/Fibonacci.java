/*
 * ��Ŀ����:
 * 	��Ҷ�֪��쳲��������У�����Ҫ������һ������n���������쳲��������еĵ�n�
 *	n<=39
 * */
public class Fibonacci {

	// 쳲���������
	public int fibonacci(int n) {

		if (n < 0)
			return n;
		int[] res = { 0, 1 };
		if (n < 2)
			return res[n];
		int fibOne = 0;
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
