package com.dalai.par;

//87. Scramble String
public class ScrambleString {

	/*
	 * Given a string s1, we may represent it as a binary tree by partitioning it to
	 * two non-empty substrings recursively.
	 * 
	 * Below is one possible representation of s1 = "great":
	 */

	// great
	// / \
	// gr eat
	// / \ / \
	// g r e at
	// / \
	// a t
	/*
	 * To scramble the string, we may choose any non-leaf node and swap its two
	 * children.
	 * 
	 * For example, if we choose the node "gr" and swap its two children, it
	 * produces a scrambled string "rgeat".
	 */

	// rgeat
	// / \
	// rg eat
	// / \ / \
	// r g e at
	// / \
	// a t
	/*
	 * We say that "rgeat" is a scrambled string of "great".
	 * 
	 * Similarly, if we continue to swap the children of nodes "eat" and "at", it
	 * produces a scrambled string "rgtae".
	 */

	// rgtae
	// / \
	// rg tae
	// / \ / \
	// r g ta e
	// / \
	// t a
	/*
	 * We say that "rgtae" is a scrambled string of "great".
	 * 
	 * Given two strings s1 and s2 of the same length, determine if s2 is a
	 * scrambled string of s1.
	 */

	public boolean isScramble(String s1, String s2) {

		if (s1 == null || s2 == null || s1.length() < 0 || s2.length() < 0)
			return false;
		if (s1.length() == 0 && s2.length() == 0)
			return true;
		if (s1.equals(s2))
			return true;

		//很难，有机会再看
		
		return false;
	}

	public static void main(String[] args) {

	}

}
