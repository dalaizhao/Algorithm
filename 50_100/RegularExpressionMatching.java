package com.dalai.par;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//10. Regular Expression Matching
public class RegularExpressionMatching {

	/*
	 * Implement regular expression matching with support for '.' and '*'.
	 * 
	 * '.' Matches any single character. '*' Matches zero or more of the preceding
	 * element.
	 * 
	 * The matching should cover the entire input string (not partial).
	 * 
	 * The function prototype should be: bool isMatch(const char *s, const char *p)
	 * 
	 * Some examples: isMatch("aa","a") → false isMatch("aa","aa") → true
	 * isMatch("aaa","aa") → false isMatch("aa", "a*") → true isMatch("aa", ".*") →
	 * true isMatch("ab", ".*") → true isMatch("aab", "c*a*b") → true
	 */
	// I. 直接用正则做的，运行时间较长
	public boolean isMatch(String s, String p) {

		if (s == null || p == null || s.length() < 0 || p.length() < 0)
			return false;

		Pattern pattern = Pattern.compile(p);
		Matcher matcher = pattern.matcher(s);

		return matcher.matches();
	}

	// II. DP思想，，运行较快,略懂
	public boolean isMatchII(String s, String p) {

		if (s == null || p == null || s.length() < 0 || p.length() < 0)
			return false;

		int sLen = s.length(), pLen = p.length();
		boolean[][] dp = new boolean[sLen + 1][pLen + 1];
		dp[0][0] = true;

		for (int i = 0; i < pLen; i++) {
			if (p.charAt(i) == '*' && dp[0][i - 1]) {
				dp[0][i + 1] = true;
			}
		}
		for (int i = 0; i < sLen; i++) {
			for (int j = 0; j < pLen; j++) {
				if (p.charAt(j) == '.') {
					dp[i + 1][j + 1] = dp[i][j];
				}
				if (p.charAt(j) == s.charAt(i)) {
					dp[i + 1][j + 1] = dp[i][j];
				}
				if (p.charAt(j) == '*') {
					if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
						dp[i + 1][j + 1] = dp[i + 1][j - 1];
					} else {
						dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i = 1][j - 1]);
					}
				}
			}
		}
		return dp[sLen][pLen];
	}

	public static void main(String[] args) {

		System.out.println(new RegularExpressionMatching().isMatchII("", ".*"));
	}
}
