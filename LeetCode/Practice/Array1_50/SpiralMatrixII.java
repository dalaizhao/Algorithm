package com.dalai.array1_50;

/*
 * Given an integer n, generate a square matrix filled
 *  with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 * */
public class SpiralMatrixII {

	// 59. Spiral Matrix II
	public int[][] generateMatrix(int n) {

		if (n <= 0)
			return null;
		int start = 0;
		int[][] matrix = new int[n][n];
		while (n > start * 2) {

			matrixCircle(matrix, start);
			start++;
		}
		return matrix;
	}

	private int number = 1;

	private void matrixCircle(int[][] matrix, int start) {
		int endX = 0, endY = 0;
		endX = endY = matrix.length - start - 1;

		// 从左到右
		for (int i = start; i <= endX; i++) {
			matrix[start][i] = number++;
		}
		// 从上到下
		if (start < endY) {
			for (int i = start + 1; i <= endY; i++) {
				matrix[i][endX] = number++;
			}
		}
		// right to left
		if (start < endX && start < endY) {
			for (int i = endX - 1; i >= start; i--) {
				matrix[endY][i] = number++;
			}
		}
		// down to up
		if (start < endX && start < endY - 1) {
			for (int i = endY - 1; i >= start + 1; i--) {
				matrix[i][start] = number++;
			}
		}
	}
}
