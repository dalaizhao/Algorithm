package com.dalai.Contest35;

import java.util.*;

public class Solution {

	// 605. Can Place Flowers
	public boolean canPlaceFlowers(int[] flowerbed, int n) {

		if (flowerbed == null || flowerbed.length == 0) {
			return false;
		}
		if (flowerbed.length == 1 && flowerbed[0] == 0) {
			return true;
		}
		int count = 0;
		for (int i = 0, len = flowerbed.length; i < len; i++) {
			if (flowerbed[i] == 0) {
				if (i == 0) {
					if (flowerbed[i + 1] == 0) {
						flowerbed[i] = 1;
						count++;
					}
				} else if (i == len - 1) {
					if (flowerbed[i - 1] == 0) {
						flowerbed[i] = 1;
						count++;
					}
				} else {
					if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
						flowerbed[i] = 1;
						count++;
					}
				}
			}
		}
		if (n <= count)
			return true;
		return false;
	}

	// 606. Construct String from Binary Tree
	public String tree2str(TreeNode t) {

		if (t == null)
			return null;

		return null;
	}

	private String BFS(TreeNode t) {

		return null;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// 609. Find Duplicate File in System
	public List<List<String>> findDuplicate(String[] paths) {
		return null;
	}

	// 591. Tag Validator
	public boolean isValid(String code) {
		return false;
	}

	public static void main(String[] args) {

		Solution solution = new Solution();
		int[] arr = { 1, 0, 0, 0, 1 };
		System.out.println(solution.canPlaceFlowers(arr, 1));

	}

}
