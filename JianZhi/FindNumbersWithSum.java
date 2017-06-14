import java.util.ArrayList;

/*
 * 题目描述
 *	输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 *	是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。 
 * 
 * */
public class FindNumbersWithSum {

	// 和为S的两个数组
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
