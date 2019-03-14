package com.dalai.par;

import java.util.HashMap;
import java.util.Map;

//409. Longest Palindrome
public class LongestPalindrome {

	/*
	 * Given a string which consists of lowercase or uppercase letters, find the
	 * length of the longest palindromes that can be built with those letters.
	 * 
	 * This is case sensitive, for example "Aa" is not considered a palindrome here.
	 */
	// ≤‚ ‘”√¿˝£∫
	// bb
	// aaa
	// aacccdss
	// aaddffgggg
	// a
	public int longestPalindrome(String s) {

		if (s == null) {
			return 0;
		}
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0, len = s.length(); i < len; i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		}
		int max = 0;
		int single = 0;
		for (Character c : map.keySet()) {
			if (map.get(c) % 2 == 0) {
				max += map.get(c);
			} else if (map.get(c) % 2 != 0 && map.get(c) / 2 > 1) {
				max += map.get(c) - 1;
			} else {
				if (single != -1) {
					single = 1;
				}
			}
		}
		return max + single;
	}
}
