/*
 * ��Ŀ����
 *	һ�����������������������֮�⣬���������ֶ����������Ρ�
 *	��д�����ҳ�������ֻ����һ�ε����֡�
 * */
public class FindNumsAppearOnce {
	// ������ֻ����һ�ε�����
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
