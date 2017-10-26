package com.dalai.par;


// 72.Edit Distance
public class EditDistance {

	/*
	 * Given two words word1 and word2, find the minimum number of steps required to
	 * convert word1 to word2. (each operation is counted as 1 step.)
	 * 
	 * You have the following 3 operations permitted on a word:
	 * 
	 * a) Insert a character b) Delete a character c) Replace a character
	 */
	public int minDistance(String word1, String word2) {

		if (word1 == null || word2 == null || word1.length() < 0 || word2.length() < 0)
			return 0;

		int len1 = word1.length();
		int len2 = word2.length();

		int[][] cost = new int[len1 + 1][len2 + 1];

		for (int i = 0; i <= len1; i++)
			cost[i][0] = i;
		for (int i = 0; i <= len2; i++)
			cost[0][i] = i;

		for (int i = 0; i < len1; i++) {
			for (int j = 0; j < len2; j++) {
				if (word1.charAt(i) == word2.charAt(j)) {
					cost[i + 1][j + 1] = cost[i][j];
				} else {
					cost[i + 1][j + 1] = 1 + Math.min(cost[i][j + 1], Math.min(cost[i][j], cost[i + 1][j]));
				}
			}
		}

		// for (int i = 0; i <= len1; i++) {
		// System.out.println(Arrays.toString(cost[i]));
		// }
		return cost[len1][len2];
	}

	public static void main(String[] args) {

		System.out.println(new EditDistance().minDistance("dotg", "hogot"));
	}

}
