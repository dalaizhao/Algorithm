/*
 * 题目描述:
 *	一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 *	求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * */
public class JumpFloor {

	// 跳台阶
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
