import java.util.ArrayList;

/*
 * 题目描述
 *	输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 *	使得所有的奇数位于数组的前半部分，
 *	所有的偶数位于位于数组的后半部分，并保证奇数和奇数，
 *	偶数和偶数之间的相对位置不变。
 * */
public class ReOrderArray {

	// 调整数组顺序使奇数位于偶数前面
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
