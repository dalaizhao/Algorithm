/*
 * 题目描述
 *	写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * */
public class Add {

	// 不加减乘除做加法
	public int add(int num1, int num2) {

		int sum = 0, carry = 0;
		do {
			sum = num1 ^ num2;
			carry = (num1 & num2) << 1;
			num1 = sum;
			num2 = carry;
		} while (num2 != 0);

		return num1;
	}
}
