package com.dalai.array1_50;

/*Given a non-negative integer represented as a non-empty array of digits, 
 * plus one to the integer.

You may assume the integer do not contain any leading zero, 
except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.*/

public class PlusOne {

	// 66. Plus One
	public int[] plusOne(int[] digits) {

		if (digits.length <= 0 || digits == null)
			return null;
		int len = digits.length;
		int result = 0;
		boolean flag = false;
		for (int i = len - 1; i >= 0; i--) {
			result = digits[i] + 1;
			if ((i == 0) && (result > 9)) {
				flag = true;
			}
			if (result > 9) {
				digits[i] = result % 10;
			} else {
				digits[i] = result;
				break;
			}
		}
		if (flag) {
			int[] arr = new int[len + 1];
			arr[0] = 1;
			for (int i = 1; i < len + 1; i++) {
				arr[i] = digits[i - 1];
			}
			return arr;
		}
		return digits;
	}

}
