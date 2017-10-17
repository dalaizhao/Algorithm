package com.dalai.array1_50;

/*A robot is located at the top-left corner of a m x n grid 
 * (marked 'Start' in the diagram below).

The robot can only move either down 
or right at any point in time. 
The robot is trying to reach the bottom-right corner of the grid 
(marked 'Finish' in the diagram below).*/

public class UniquePaths {

	// 62. Unique Paths
	public int uniquePaths(int m, int n) {

		if (m <= 0 || n <= 0)
			return 0;
		int[][] pathNum = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				if (i == 0 && j == 0) {
					pathNum[i][j] = 1;
				} else if (i == 0 && j != 0) {
					pathNum[i][j] = pathNum[i][j - 1];
				} else if (i != 0 && j == 0) {
					pathNum[i][j] = pathNum[i - 1][j];
				} else {
					pathNum[i][j] = pathNum[i - 1][j] + pathNum[i][j - 1];
				}
			}
		}

		return pathNum[m - 1][n - 1];
	}
}
