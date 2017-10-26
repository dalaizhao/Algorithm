package com.dalai.par;


//96. Unique Binary Search Trees
public class UniqueBinarySearchTrees {

	/*
	 * Given n, how many structurally unique BST's (binary search trees) that store
	 * values 1...n?
	 * 
	 * For example, Given n = 3, there are a total of 5 unique BST's.
	 */

	// 1 3 3 2 1
	// \ / / / \ \
	// 3 2 1 1 3 2
	// / / \ \
	// 2 1 2 3

	// ÌØÕ÷·½³Ì£º F(i, n) = G(i-1) * G(n-i) 1 <= i <= n

	public int numTrees(int n) {

		if (n < 0)
			return 0;
		int[] G = new int[n + 1];
		G[0] = G[1] = 1;

		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				G[i] += G[j - 1] * G[i - j];
			}
		}

		return G[n];
	}

	public static void main(String[] args) {
		System.out.println(new UniqueBinarySearchTrees().numTrees(4));
	}
}
