package com.dalai.par;

import java.util.Stack;

public class LongestValidParentheses {

	/*
	 * Given a string containing just the characters '(' and ')', find the length of
	 * the longest valid (well-formed) parentheses substring.
	 * 
	 * For "(()", the longest valid parentheses substring is "()", which has length
	 * = 2.
	 * 
	 * Another example is ")()())", where the longest valid parentheses substring is
	 * "()()", which has length = 4.
	 * 
	 * ³ö´íµØ·½:"()(())"
	 */
	public int longestValidParentheses(String s) {

		if (s == null || s.length() < 0)
			return 0;
		Stack<Integer> stack = new Stack<>();

		int max = 0;
		int left = -1;
		for (int i = 0, len = s.length(); i < len; i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				if (stack.isEmpty()) {
					left = i;
				} else {
					stack.pop();
					if (stack.isEmpty()) {
						max = Math.max(max, i - left);
					} else {
						max = Math.max(max, i - stack.peek());
					}
				}
			}
		}

		return max;
	}

	public static void main(String[] args) {

		LongestValidParentheses lvp = new LongestValidParentheses();
		System.out.println(lvp.longestValidParentheses(")()())"));
	}

}
