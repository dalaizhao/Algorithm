/*
 * 题目描述:
 *	我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 *	请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 
 * */
public class RectCover {

	// 矩阵覆盖
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
