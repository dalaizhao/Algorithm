package com.dalai.par;

//14. Longest Common Prefix
public class LongestCommonPrefix {

	/*
	 * Write a function to find the longest common prefix string amongst an array of
	 * strings.
	 */
	public String longestCommonPrefix(String[] strs) {

		if (strs == null || strs.length <= 0)
			return "";

		String commonPrefix = strs[0];

		for (int i = 1, len = strs.length; i < len; i++) {
			int minlen = Math.min(commonPrefix.length(), strs[i].length());
			commonPrefix = commonPrefix.substring(0, minlen);
			for (int j = 0; j < minlen; j++) {
				if (commonPrefix.charAt(j) != strs[i].charAt(j)) {
					commonPrefix = commonPrefix.substring(0, j);
					break;
				}
			}
		}

		return commonPrefix;
	}

	public static void main(String[] args) {

		System.out.println();
	}

}
