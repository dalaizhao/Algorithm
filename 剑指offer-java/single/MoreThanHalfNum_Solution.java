/*
 * 
 * ��Ŀ����
 * 	��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡�
 *	��������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}��
 *	��������2�������г�����5�Σ��������鳤�ȵ�һ�룬������2��
 *	��������������0��
 * 
 * */
public class MoreThanHalfNum_Solution {

	// �����г��ִ�������һ�������
	public int moreThanHalfNum_Solution(int[] array) {

		if (array == null || array.length == 0)
			return 0;
		int result = array[0];
		int times = 1;
		for (int i = 1, len = array.length; i < len; i++) {
			if (times == 0) {
				result = array[i];
				times = 1;
			} else if (array[i] == result) {
				times++;
			} else {
				times--;
			}
		}
		if (checkMoreThanHalf(array, result))
			return result;
		return 0;
	}

	public boolean checkMoreThanHalf(int[] array, int results) {

		int times = 0;
		for (int i = 0, len = array.length; i < len; i++) {
			if (array[i] == results)
				times++;
		}

		return times > array.length / 2 ? true : false;
	}
}
