package com.dalai.par;

//91. Decode Ways
public class DecodeWays {

	/*
	 * A message containing letters from A-Z is being encoded to numbers using the
	 * following mapping:
	 * 
	 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26 Given an encoded message containing digits,
	 * determine the total number of ways to decode it.
	 * 
	 * For example, Given encoded message "12", it could be decoded as "AB" (1 2) or
	 * "L" (12).
	 * 
	 * The number of ways decoding "12" is 2.
	 */
	public int numDecodings(String s) {

		if (s == null || s.length() <= 0)
			return 0;

		if (s.charAt(0) == '0') {
			return 0;
		}
		int len = s.length();

		int[] memo = new int[len + 1];
		memo[len] = 1;
		memo[len - 1] = s.charAt(len - 1) != '0' ? 1 : 0;

		for (int i = len - 2; i >= 0; i--) {
			if (s.charAt(i) == '0')
				continue;
			else {
				// System.out.println("-------" + Integer.parseInt(s.substring(i, i + 2)));
				memo[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) ? memo[i + 1] + memo[i + 2] : memo[i + 1];
			}
		}

		return memo[0];
	}

	public static void main(String[] args) {

		System.out.println(new DecodeWays().numDecodings("10"));
		System.out.println(new DecodeWays().numDecodings("101"));
		System.out.println(new DecodeWays().numDecodings("110"));
		System.out.println(new DecodeWays().numDecodings("100"));
		System.out.println(new DecodeWays().numDecodings("1267"));
		System.out.println(new DecodeWays().numDecodings("01"));
		System.out.println(new DecodeWays().numDecodings("170"));
	}

}
