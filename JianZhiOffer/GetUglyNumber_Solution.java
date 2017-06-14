
/*
 * 题目描述
 *	把只包含因子2、3和5的数称作丑数（Ugly Number）。
 *	例如6、8都是丑数，但14不是，因为它包含因子7。 
 *	习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 * */
public class GetUglyNumber_Solution {
	// 丑数
	public int getUglyNumber_Solution(int index) {

		if (index <= 0) {
			return 0;
		}
		int[] uglyNums = new int[index];
		int count = 0;
		int i2 = 0;
		int i3 = 0;
		int i5 = 0;
		uglyNums[0] = 1;
		int tmp = 0;
		while (count < index - 1) {
			tmp = min(uglyNums[i2] * 2, uglyNums[i3] * 3, uglyNums[i5] * 5);
			if (tmp == uglyNums[i2] * 2)
				i2++;
			if (tmp == uglyNums[i3] * 3)
				i3++;
			if (tmp == uglyNums[i5] * 5)
				i5++;
			uglyNums[++count] = tmp;
		}
		return uglyNums[index - 1];
	}

	private int min(int i, int j, int k) {
		int min = i > j ? j : i;
		return min > k ? k : min;
	}
}
