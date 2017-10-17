package com.dalai.par;

//5.Longest Palindromic Substring
public class LongestPalindromicSubstring {

	/*
	 * Given a string s, find the longest palindromic substring in s. You may assume
	 * that the maximum length of s is 1000.
	 * 
	 * Example:
	 * 
	 * Input: "babad"
	 * 
	 * Output: "bab"
	 * 
	 * Note: "aba" is also a valid answer.
	 * 
	 * Example:
	 * 
	 * Input: "cbbd"
	 * 
	 * Output: "bb"
	 */
	// 回文是一个两个方向读取相同的字符串
	public String longestPalindrome(String s) {

		if (s == null || s.length() == 0) {
			return null;
		}
		int start = 0, end = 0;
		for (int i = 0, len = s.length(); i < len; i++) {
			int len1 = expandAroundCenter(s, i, i);
			int len2 = expandAroundCenter(s, i, i + 1);
			int maxLen = Math.max(len1, len2);
			if (maxLen > end - start) {
				start = i - (maxLen - 1) / 2;
				end = i + maxLen / 2;
			}
		}
		return s.substring(start, end + 1);
	}

	private int expandAroundCenter(String s, int left, int right) {

		int L = left, R = right;
		while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
			L--;
			R++;
		}
		return R - L - 1;
	}

	public static void main(String[] args) {

		System.out.println(new LongestPalindromicSubstring().longestPalindrome("babad"));
		System.out.println(new LongestPalindromicSubstring().longestPalindrome("cbbd"));
		System.out.println(new LongestPalindromicSubstring().longestPalindrome("a"));
		System.out.println(new LongestPalindromicSubstring().longestPalindrome("ccc"));
	}
}
