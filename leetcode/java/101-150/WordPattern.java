package com.dalai.par;

import java.util.*;

//290. Word Pattern
public class WordPattern {

	/*
	 * Given a pattern and a string str, find if str follows the same pattern.
	 * 
	 * Here follow means a full match, such that there is a bijection between a
	 * letter in pattern and a non-empty word in str.
	 * 
	 * Examples: pattern = "abba", str = "dog cat cat dog" should return true.
	 * pattern = "abba", str = "dog cat cat fish" should return false. pattern =
	 * "aaaa", str = "dog cat cat dog" should return false. pattern = "abba", str =
	 * "dog dog dog dog" should return false.
	 */
	public boolean wordPattern(String pattern, String str) {

		String[] words = str.split(" ");
		if (words.length != pattern.length())
			return false;
		Map<Object, Object> index = new HashMap<>();
		for (Integer i = 0; i < words.length; ++i)
			if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
				return false;
		return true;
	}
}
