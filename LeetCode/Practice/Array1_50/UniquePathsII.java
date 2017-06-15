package com.dalai.array1_50;

/*Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. 
How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.*/
public class UniquePathsII {

	// 63. Unique Paths II
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {

		if (obstacleGrid == null || obstacleGrid.length == 0)
			return 0;
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] pathNum = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				if (obstacleGrid[i][j] == 1) {
					pathNum[i][j] = 0;
				} else if (i == 0 && j == 0) {
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
