package com.dalai.par;

import java.util.Arrays;

//7.Reverse Integer
public class ReverseInteger {

	/*
	 * Reverse digits of an integer.
	 * 
	 * Example1: x = 123, return 321 Example2: x = -123, return -321
	 */
	public int reverse(int x) {

		char[] ch = Integer.toString(x).toCharArray();
		int number = 0;
		if (ch[0] == '-') {
			number = 0 - reverseStr(Arrays.copyOfRange(ch, 1, ch.length));
		} else {
			number = reverseStr(ch);
		}
		return number;
	}

	private int reverseStr(char[] ch) {

		if (ch == null || ch.length <= 0)
			return 0;
		int len = ch.length, mid = len / 2;
		StringBuffer stringBuffer = new StringBuffer();
		boolean flag = true;
		int idx = 0;
		for (; idx < mid; idx++) {
			char temp = ch[idx];
			ch[idx] = ch[len - idx - 1];
			ch[len - idx - 1] = temp;
			if (ch[idx] == '0' && flag) {

			} else {
				stringBuffer.append(ch[idx]);
				flag = false;
			}
		}
		stringBuffer.append(ch, idx, len - idx);
		try {
			return Integer.valueOf(stringBuffer.toString());
		} catch (Exception e) {
			return 0;
		}
	}

	public static void main(String[] args) {

		System.out.println(new ReverseInteger().reverse(-123));
		System.out.println(new ReverseInteger().reverse(1000000003));
		System.out.println(new ReverseInteger().reverse(100));
	}
}
