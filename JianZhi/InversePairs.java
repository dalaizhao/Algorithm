/*
 * 题目描述
 *	在数组中的两个数字，如果前面一个数字大于后面的数字，
 *	则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
 *	并将P对1000000007取模的结果输出。 即输出P%1000000007 
 *	输入描述:
 *		题目保证输入的数组中没有的相同的数字
 *	数据范围：
 *		对于%50的数据,size<=10^4
 *		对于%75的数据,size<=10^5
 *		对于%100的数据,size<=2*10^5
 * */
public class InversePairs {

	// 数组中的逆序对
	public int inversePairs(int[] array) {

		if (array == null || array.length == 0)
			return 0;
		int[] copyArr = new int[array.length];
		int count = inversePairsCore(array, copyArr, 0, array.length - 1);
		return count;
	}

	private int inversePairsCore(int[] array, int[] copyArr, int start, int end) {

		if (start == end) {
			copyArr[start] = array[start];
			return 0;
		}
		int len = (end - start) / 2;

		int left = inversePairsCore(array, copyArr, start, start + len) % 1000000007;
		int right = inversePairsCore(array, copyArr, start + len + 1, end) % 1000000007;

		// i初始化为前半段最后一个数字的下标
		// j初始化为后半段的最后一个数字的下标
		int i = start + len;
		int j = end;
		int indexCopy = end;
		int count = 0;
		while (i >= start && j >= start + len + 1) {
			if (array[i] > array[j]) {
				copyArr[indexCopy--] = array[i--];
				count += j - start - len;
				if (count >= 1000000007)// 数值过大求余
				{
					count %= 1000000007;
				}
			} else {
				copyArr[indexCopy--] = array[j--];
			}
		}
		for (; i >= start; --i)
			copyArr[indexCopy--] = array[i];
		for (; j >= start + len + 1; --j)
			copyArr[indexCopy--] = array[j];
		System.arraycopy(copyArr, start, array, start, end - start + 1);

		return (left + right + count) % 1000000007;
	}

}
