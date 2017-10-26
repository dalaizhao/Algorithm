/*
 * ��Ŀ����
 *	ͳ��һ�����������������г��ֵĴ�����
 * 
 * */
public class GetNumberOfK {

	// ���������������г��ֵĴ���
	public int getNumberOfK(int[] array, int k) {

		if (array == null || array.length == 0)
			return 0;
		int firstPos = getFirstPos(array, k, 0, array.length - 1);
		int lastPos = getLastPos(array, k, 0, array.length - 1);
		if (firstPos > -1 && lastPos > -1)
			return lastPos - firstPos + 1;
		return 0;
	}

	private int getFirstPos(int[] array, int k, int start, int end) {

		if (start > end)
			return -1;
		int middleIndex = (start + end) / 2;
		int middleData = array[middleIndex];
		if (middleData == k) {
			if (middleIndex > 0 && array[middleIndex - 1] != k || middleIndex == 0)
				return middleIndex;
			else
				end = middleIndex - 1;
		} else if (middleData > k) {
			end = middleIndex - 1;
		} else {
			start = middleIndex + 1;
		}
		return getFirstPos(array, k, start, end);
	}

	private int getLastPos(int[] array, int k, int start, int end) {
		if (start > end)
			return -1;
		int middleIndex = (start + end) / 2;
		int middleData = array[middleIndex];

		if (middleData == k) {
			if (middleIndex < array.length - 1 && array[middleIndex + 1] != k || middleIndex == array.length - 1) {
				return middleIndex;
			} else {
				start = middleIndex + 1;
			}
		} else if (middleData < k) {
			start = middleIndex + 1;
		} else {
			end = middleIndex - 1;
		}

		return getLastPos(array, k, start, end);
	}
}
