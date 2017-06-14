/*
 * ��Ŀ����:
 *	��һ����ά�����У�ÿһ�ж����մ����ҵ�����˳������
 *	ÿһ�ж����մ��ϵ��µ�����˳�����������һ��������
 *	����������һ����ά�����һ���������ж��������Ƿ��и�������
 * */

public class Find {
	// ��ά�����еĲ�������
	public boolean find(int target, int[][] array) {

		if (array == null || array.length == 0)
			return false;
		int row = 0, rowLen = array.length;
		int col = array[0].length - 1;
		while (row < rowLen && col >= 0) {
			if (array[row][col] == target) {
				return true;
			} else if (array[row][col] > target) {
				col--;
			} else {
				row++;
			}
		}
		return false;
	}
}
