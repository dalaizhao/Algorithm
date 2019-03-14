package com.dalai.par;

//43. Multiply Strings
public class MultiplyStrings {

	/*
	 * Given two non-negative integers num1 and num2 represented as strings, return
	 * the product of num1 and num2.
	 * 
	 * Note:
	 * 
	 * The length of both num1 and num2 is < 110. Both num1 and num2 contains only
	 * digits 0-9. Both num1 and num2 does not contain any leading zero. You must
	 * not use any built-in BigInteger library or convert the inputs to integer
	 * directly.
	 */

	// 此方法能整出正确答案 但是效率堪忧 leetcode直接都time limit exceeded了
	public String multiplyII(String num1, String num2) {

		if (num1.length() + num2.length() >= 110)
			return "0";

		long num1L = strToLong(num1);
		long num2L = strToLong(num2);

		if (num1L == 0 || num2L == 0)
			return "0";

		return longToStr(num1L * num2L);
	}

	private Long strToLong(String s) {

		long number = 1;
		long num = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			num += (long) (s.charAt(i) - '0') * number;
			number *= 10;
		}
		return num;
	}

	private String longToStr(long l) {

		StringBuilder sb = new StringBuilder();

		int temp = 1;
		while (l >= temp) {
			temp *= 10;
		}
		temp /= 10;
		while (temp > 0) {
			sb.append((l / temp));
			l = l % temp;
			temp /= 10;
		}

		return sb.toString();
	}

	//
	public String multiply(String num1, String num2) {

		int m = num1.length(), n = num2.length();
		int[] pos = new int[m + n];

		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				int p1 = i + j, p2 = i + j + 1;
				int sum = mul + pos[p2];

				pos[p1] += sum / 10;
				pos[p2] = (sum) % 10;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i : pos) {
			System.out.println(i);
			if (!(sb.length() == 0 && i == 0))
				sb.append(i);
		}
		return sb.length() == 0 ? "0" : sb.toString();
	}

	public static void main(String[] args) {

		System.out.println(new MultiplyStrings().multiply("100", "20"));
		System.out.println(new MultiplyStrings().multiply("1", "1"));
	}

}
