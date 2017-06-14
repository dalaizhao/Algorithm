/*
 * ��Ŀ����
 *	�������е��������֣����ǰ��һ�����ִ��ں�������֣�
 *	���������������һ������ԡ�����һ������,�����������е�����Ե�����P��
 *	����P��1000000007ȡģ�Ľ������� �����P%1000000007 
 *	��������:
 *		��Ŀ��֤�����������û�е���ͬ������
 *	���ݷ�Χ��
 *		����%50������,size<=10^4
 *		����%75������,size<=10^5
 *		����%100������,size<=2*10^5
 * */
public class InversePairs {

	// �����е������
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

		// i��ʼ��Ϊǰ������һ�����ֵ��±�
		// j��ʼ��Ϊ���ε����һ�����ֵ��±�
		int i = start + len;
		int j = end;
		int indexCopy = end;
		int count = 0;
		while (i >= start && j >= start + len + 1) {
			if (array[i] > array[j]) {
				copyArr[indexCopy--] = array[i--];
				count += j - start - len;
				if (count >= 1000000007)// ��ֵ��������
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
