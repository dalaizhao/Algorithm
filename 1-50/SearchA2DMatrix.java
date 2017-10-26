package com.dalai.array1_50;

/*Write an efficient algorithm that searches for a value in an m x n matrix. 
 * This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.

Subscribe to see which companies asked this question.*/

public class SearchA2DMatrix {

	// 74. Search a 2D Matrix
	public boolean searchMatrix(int[][] matrix, int target) {

		if (matrix == null || matrix.length == 0)
			return false;
		for (int i = 0, rowlen = matrix.length; i < rowlen; i++) {
			if (matrix[i].length == 0)
				return false;
			int collen = matrix[i].length;
			if (matrix[i][collen - 1] >= target) {
				for (int j = 0; j < collen; j++) {
					if (matrix[i][j] == target)
						return true;
				}
				return false;
			}
		}
		return false;
	}
}
