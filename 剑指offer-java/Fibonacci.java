/*
 * 题目描述:
 * 	大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 *	n<=39
 * */
public class Fibonacci {

	// 斐波那契数列
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
