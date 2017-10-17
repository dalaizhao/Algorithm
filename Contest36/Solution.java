package com.dalai.Contest36;

import java.util.Arrays;

/**
 * 
 * @author dalai
 *
 */
public class Solution {

	/*
	 * Given two binary trees and imagine that when you put one of them to cover
	 * the other, some nodes of the two trees are overlapped while the others
	 * are not.
	 * 
	 * You need to merge them into a new binary tree. The merge rule is that if
	 * two nodes overlap, then sum node values up as the new value of the merged
	 * node. Otherwise, the NOT null node will be used as the node of new tree.
	 */

	// 617. Merge Two Binary Trees
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		TreeNode root = null;
		if (t1 == null && t2 == null)
			return root;
		else if (t1 == null && t2 != null) {
			return t2;
		} else if (t1 != null && t2 == null) {
			return t1;
		} else {
			root = new TreeNode(t1.val + t2.val);
			root.left = mergeTrees(t1.left, t2.left);
			root.right = mergeTrees(t1.right, t2.right);
		}

		return root;
	}

	/*
	 * Design and implement a data structure for a compressed string iterator.
	 * It should support the following operations: next and hasNext.
	 * 
	 * The given compressed string will be in the form of each letter followed
	 * by a positive integer representing the number of this letter existing in
	 * the original uncompressed string.
	 * 
	 * next() - if the original string still has uncompressed characters, return
	 * the next letter; Otherwise return a white space. hasNext() - Judge
	 * whether there is any letter needs to be uncompressed.
	 * 
	 * Note: Please remember to RESET your class variables declared in
	 * StringIterator, as static/class variables are persisted across multiple
	 * test cases. Please see here for more details.
	 */

	// 604. Design Compressed String Iterator
	class StringIterator {

		public char[] ch;
		public int index = 0;
		public int num = 0;
		public char c;

		StringIterator(String compressedString) {
			ch = compressedString.toCharArray();
		}

		public char next() {

			if (num > 0) {
				num--;
				return c;
			} else if (index < ch.length) {
				c = ch[index];
				int tmpIndex = index + 1;
				while (tmpIndex < ch.length && Character.isDigit(ch[tmpIndex])) {
					tmpIndex++;
				}
				String number = new String(ch, index + 1, tmpIndex - 1 - index);
				num = Integer.valueOf(number) - 1;
				index = tmpIndex;
				return c;
			} else {
				return ' ';
			}
		}

		public boolean hasNext() {
			if (index < ch.length || num > 0)
				return true;
			return false;
		}

	}

	/*
	 * Given an array consists of non-negative integers, your task is to count
	 * the number of triplets chosen from the array that can make triangles if
	 * we take them as side lengths of a triangle.
	 * 
	 * Example 1: Input: [2,2,3,4] Output: 3 Explanation: Valid combinations
	 * are: 2,3,4 (using the first 2) 2,3,4 (using the second 2) 2,2,3 Note: The
	 * length of the given array won't exceed 1000. The integers in the given
	 * array are in the range of [0, 1000].
	 */

	// 611. Valid Triangle Number
	public int triangleNumber(int[] nums) {

		if (nums == null || nums.length == 0)
			return 0;
		Arrays.sort(nums);
		int count = 0, len = nums.length;
		for (int i = len - 1; i >= 2; i--) {
			int left = 0, right = i - 1;
			while (left < right) {
				if (nums[left] + nums[right] > nums[i]) {
					count += right - left;
					right--;
				} else
					left++;
			}
		}

		return count;
	}

	/*
	 * Given a string s and a list of strings dict, you need to add a closed
	 * pair of bold tag <b> and </b> to wrap the substrings in s that exist in
	 * dict. If two such substrings overlap, you need to wrap them together by
	 * only one pair of closed bold tag. Also, if two substrings wrapped by bold
	 * tags are consecutive, you need to combine them.
	 * 
	 * Example 1: Input: s = "abcxyz123" dict = ["abc","123"] Output:
	 * "<b>abc</b>xyz<b>123</b>" Example 2: Input: s = "aaabbcc" dict =
	 * ["aaa","aab","bc"] Output: "<b>aaabbc</b>c"
	 */

	// 616. Add Bold Tag in String
	public String addBoldTag(String s, String[] dict) {
		Boolean[] boolArr = new Boolean[s.length()];
		for (int i = 0, end = 0, len = s.length(); i < len; i++) {
			for (String string : dict) {
				if (s.startsWith(string, i)) {
					end = Math.max(end, i + string.length());
				}
			}
			boolArr[i] = end > i;
		}
		StringBuilder result = new StringBuilder();
		for (int i = 0, len = s.length(); i < len; i++) {
			if (!boolArr[i]) {
				result.append(s.charAt(i));
				continue;
			}
			int j = i;
			while (j < s.length() && boolArr[j])
				j++;
			result.append("<b>" + s.substring(i, j) + "</b>");
			i = j - 1;
		}

		return result.toString();
	}

	public static void main(String[] args) {

		Solution solution = new Solution();

		// Solution.StringIterator iterator = solution.new
		// StringIterator("q2s4v18");
		//
		// System.out.println(iterator.next()); // return 'L'
		// System.out.println(iterator.next());
		// System.out.println(iterator.next());
		// System.out.println(iterator.next());
		// System.out.println(iterator.next());
		// System.out.println(iterator.next());
		// System.out.println(iterator.next());
		// System.out.println(iterator.hasNext()); // return true
		// System.out.println(iterator.next());
		// System.out.println(iterator.hasNext()); // return false
		// System.out.println(iterator.next());

		String string = "abcxyz123";
		String[] arr = { "abc", "123" };
		System.out.println(solution.addBoldTag(string, arr));

	}

}
