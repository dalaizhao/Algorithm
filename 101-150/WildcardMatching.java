package com.dalai.par;

public class WildcardMatching {

	/*
	 * Implement wildcard pattern matching with support for '?' and '*'.
	 * 
	 * '?' Matches any single character. '*' Matches any sequence of characters
	 * (including the empty sequence).
	 * 
	 * The matching should cover the entire input string (not partial).
	 * 
	 * The function prototype should be: bool isMatch(const char *s, const char *p)
	 * 
	 * Some examples: isMatch("aa","a") ¡ú false isMatch("aa","aa") ¡ú true
	 * isMatch("aaa","aa") ¡ú false isMatch("aa", "*") ¡ú true isMatch("aa", "a*") ¡ú
	 * true isMatch("ab", "?*") ¡ú true isMatch("aab", "c*a*b") ¡ú false
	 */

	public boolean isMatch(String s, String p) {

		if (s == null || p == null || s.length() < 0 || p.length() < 0)
			return false;

		int sIdx = 0, pIdx = 0, match = 0, idx = -1;

		int sLen = s.length(), pLen = p.length();
		while (sIdx < sLen) {

			if (pIdx < pLen && (p.charAt(pIdx) == '?' || s.charAt(sIdx) == p.charAt(pIdx))) {
				sIdx++;
				pIdx++;

			} else if (pIdx < pLen && p.charAt(pIdx) == '*') {
				idx = pIdx;
				match = sIdx;
				pIdx++;
			} else if (idx != -1) {
				pIdx = idx + 1;
				match++;
				sIdx = match;
				// System.out.println("s:" + sIdx);
				// System.out.println("p:" + pIdx);
			} else {
				return false;
			}
		}

		while (pIdx < pLen && p.charAt(pIdx) == '*') {
			pIdx++;
		}

		return pIdx == pLen;
	}

	public static void main(String[] args) {

		System.out.println(new WildcardMatching().isMatch("aaaa", "***a"));
		// System.out.println("123");

	}
}
