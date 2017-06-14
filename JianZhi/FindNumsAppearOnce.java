/*
 * 题目描述
 *	一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 *	请写程序找出这两个只出现一次的数字。
 * */
public class FindNumsAppearOnce {
	// 数字中只出现一次的数字
	public void findNumsAppearOnce(int[] array, int num1[], int num2[]) {

		if (array == null || array.length == 0 || num1 == null || num2 == null)
			return;
		int result = 0;
		for (int i = 0, len = array.length; i < len; i++) {
			result ^= array[i];
		}
		int indexOf1 = findFirstBitIs1(result);
		for (int i = 0, len = array.length; i < len; i++) {
			if (IsBit1(array[i], indexOf1)) {
				num2[0] ^= array[i];
			} else {
				num1[0] ^= array[i];
			}
		}
	}

	private boolean IsBit1(int num, int indexBit) {
		num = num >> indexBit;
		return (num & 1) == 1 ? true : false;
	}

	private int findFirstBitIs1(int result) {

		int indexBit = 0;
		while ((result & 1) == 0) {
			result = result >> 1;
			++indexBit;
		}
		return indexBit;
	}

}
