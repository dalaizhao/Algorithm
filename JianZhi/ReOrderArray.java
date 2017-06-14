import java.util.ArrayList;

/*
 * ��Ŀ����
 *	����һ���������飬ʵ��һ�����������������������ֵ�˳��
 *	ʹ�����е�����λ�������ǰ�벿�֣�
 *	���е�ż��λ��λ������ĺ�벿�֣�����֤������������
 *	ż����ż��֮������λ�ò��䡣
 * */
public class ReOrderArray {

	// ��������˳��ʹ����λ��ż��ǰ��
	public void reOrderArray(int[] array) {

		if (array == null || array.length == 0)
			return;
		int len = array.length;
		ArrayList<Integer> evenList = new ArrayList<>();
		int index = 0, currentIndex = 0;
		while (index < len) {
			if (isOddNumber(array[index])) {
				array[currentIndex++] = array[index++];
			} else {
				evenList.add(array[index++]);
			}
		}
		for (int i = currentIndex; i < len; i++) {
			array[i] = evenList.get(i - currentIndex);
		}

	}

	private boolean isOddNumber(int num) {
		return (num % 2) != 0;
	}
}
