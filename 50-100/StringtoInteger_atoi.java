package com.dalai.par;

//8. String to Integer (atoi)
public class StringtoInteger_atoi {

	/* Implement atoi to convert a string to an integer. */

	public int myAtoi(String str) {

		if (str == null || str.length() <= 0)
			return 0;

		int idx = 0, sign = 1, total = 0, len = str.length();

		while (str.charAt(idx) == ' ' && idx < len) {
			idx++;
		}

		if (str.charAt(idx) == '+' || str.charAt(idx) == '-') {
			sign = str.charAt(idx) == '+' ? 1 : -1;
			idx++;
		}

		while (idx < len) {

			int digit = str.charAt(idx) - '0';
			if (digit < 0 || digit > 9)
				break;
			if (Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit)
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

			total = 10 * total + digit;
			idx++;

		}

		return total * sign;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
