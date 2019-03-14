/*
 * 题目描述:
 *	一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 *	求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * */
public class JumpFloorII {

	// 变态跳台阶
	public int jumpFloorII(int target) {

		if (target <= 0) {
			return target;
		}
		// 数学归纳法可以得到f(n)=2^(n-1)
		return (int) Math.pow(2, target - 1);
	}
}
