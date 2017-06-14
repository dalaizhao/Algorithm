
/*
 * ��Ŀ����
 *	��ֻ��������2��3��5��������������Ugly Number����
 *	����6��8���ǳ�������14���ǣ���Ϊ����������7�� 
 *	ϰ�������ǰ�1�����ǵ�һ���������󰴴�С�����˳��ĵ�N��������
 *
 * */
public class GetUglyNumber_Solution {
	// ����
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
