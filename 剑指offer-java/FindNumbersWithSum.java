import java.util.ArrayList;

/*
 * ��Ŀ����
 *	����һ����������������һ������S���������в�����������
 *	�ǵ����ǵĺ�������S������ж�����ֵĺ͵���S������������ĳ˻���С�ġ� 
 * 
 * */
public class FindNumbersWithSum {

	// ��ΪS����������
	public ArrayList<Integer> findNumbersWithSum(int[] array, int sum) {

		ArrayList<Integer> arrayList = new ArrayList<>();
		if (array == null || array.length == 0) {
			return arrayList;
		}
		int left = 0, right = array.length - 1;
		while (left < right) {
			if (array[right] >= sum) {
				right--;
			} else if (array[left] + array[right] == sum) {
				arrayList.add(array[left]);
				arrayList.add(array[right]);
				break;
			} else {
				left++;
			}
		}
		return arrayList;
	}
}
