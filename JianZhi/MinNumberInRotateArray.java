/*
 * 题目描述
 *	把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 	输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 *	例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 *	NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * 
 * */
public class MinNumberInRotateArray {

	// 旋转数组的最小数字
	public int minNumberInRotateArray(int[] array) {

		if (array == null || array.length == 0)
			return 0;
		int left = 0;
		int right = array.length - 1;
		int mid = left;

		while (array[left] >= array[right]) {
			if ((right - left) == 1) {
				mid = right;
				break;
			}

			mid = (left + right) / 2;

			// 如果下标为left,right,mid指向的三个数字相等，则只能用循序查找
			if (array[left] == array[mid] && array[mid] == array[right]) {
				return MinInOrder(array, left, right);
			}

			if (array[mid] >= array[left]) {
				left = mid;
			} else if (array[mid] <= array[right]) {
				right = mid;
			}
		}
		return array[mid];
	}

	private int MinInOrder(int[] array, int left, int right) {

		int result = array[left];
		for (int i = left + 1; i <= right; i++) {
			if (result > array[i])
				result = array[i];
		}
		return result;
	}
}
