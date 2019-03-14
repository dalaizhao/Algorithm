package com.dalai.par;

import java.util.LinkedList;

//3. Longest Substring Without Repeating Characters
public class LengthOfLongestSubstring {

	/*
	 * Given a string, find the length of the longest substring without repeating
	 * characters.
	 * 
	 * Examples:
	 * 
	 * Given "abcabcbb", the answer is "abc", which the length is 3.
	 * 
	 * Given "bbbbb", the answer is "b", with the length of 1.
	 * 
	 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the
	 * answer must be a substring, "pwke" is a subsequence and not a substring.
	 */
	public int lengthOfLongestSubstring(String s) {

		if (s == null || s.length() == 0)
			return 0;
		LinkedList<Integer> linkedList = new LinkedList<>();
		int length = 0;
		for (int i = 0, len = s.length(); i < len; i++) {
			int number = Integer.valueOf(s.charAt(i));
			if (linkedList.contains(number)) {
				length = linkedList.size() > length ? linkedList.size() : length;
				linkedList.subList(0, linkedList.indexOf(number) + 1).clear();
			}
			linkedList.addLast(number);
		}

		return linkedList.size() > length ? linkedList.size() : length;
	}

	public static void main(String[] args) {
		String string = "bbbbb";
		String string2 = "aab";
		String string3 = "pwwkew";
		System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring(string));
		System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring(string2));
		System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring(string3));
	}
}
