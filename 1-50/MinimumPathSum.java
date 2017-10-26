package com.dalai.array1_50;

/*Given a m x n grid filled with non-negative numbers, 
 * find a path from top left to bottom right 
 * which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.*/
public class MinimumPathSum {

	// 64. Minimum Path Sum
	public int minPathSum(int[][] grid) {

		if (grid == null || grid.length == 0)
			return 0;
		int row = grid.length;
		int col = grid[0].length;
		int[][] sum = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {

				if (i == 0 && j == 0) {
					sum[i][j] = sum[i][j];
				} else if (i == 0 && j != 0) {
					sum[i][j] = sum[i][j - 1] + grid[i][j];
				} else if (i != 0 && j == 0) {
					sum[i][j] = sum[i - 1][j] + grid[i][j];
				} else {
					sum[i][j] = Math.min(sum[i - 1][j], sum[i][j - 1]) + grid[i][j];
				}
			}
		}
		return sum[row - 1][col - 1];
	}
}
