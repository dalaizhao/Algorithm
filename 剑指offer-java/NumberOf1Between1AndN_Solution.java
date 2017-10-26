/*
 * 
 * 题目描述
 *	求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 *	为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
 *	但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,
 *	可以很快的求出任意非负整数区间中1出现的次数
 * 
 * */

//这个解题厉害了，LeetCode学到的公式，非常的厉害
public class NumberOf1Between1AndN_Solution {

	// 整数中一出现的次数
	public int numberOf1Between1AndN_Solution(int n) {

		if (n < 1)
			return 0;
		int ones = 0;
		for (long m = 1; m <= n; m *= 10)
			ones += (n / m + 8) / 10 * m + (n / m % 10 == 1 ? n % m + 1 : 0);
		return ones;
	}
}
