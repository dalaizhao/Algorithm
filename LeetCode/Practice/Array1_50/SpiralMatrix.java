package com.dalai.array1_50;

import java.util.ArrayList;
import java.util.List;

/*Given a matrix of m x n elements (m rows, n columns), 
 * return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].*/
public class SpiralMatrix {

	// 54. Spiral Matrix
	public List<Integer> spiralOrder(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return new ArrayList<>();
		int start = 0, rows = matrix[0].length, cols = matrix.length;
		ArrayList<Integer> matrixList = new ArrayList<>();
		while (rows > start * 2 && cols > start * 2) {
			printMatrixCircle(matrix, start, matrixList);
			start++;
		}
		return matrixList;
	}

	private void printMatrixCircle(int[][] matrix, int start, ArrayList<Integer> matrixList) {
		int endX = matrix[0].length - start - 1;
		int endY = matrix.length - start - 1;
		// 从左到右
		for (int i = start; i <= endX; i++) {
			matrixList.add(matrix[start][i]);
		}
		// 从上到下
		if (start < endY) {
			for (int i = start + 1; i <= endY; i++) {
				matrixList.add(matrix[i][endX]);
			}
		}
		// right to left
		if (start < endX && start < endY) {
			for (int i = endX - 1; i >= start; i--) {
				matrixList.add(matrix[endY][i]);
			}
		}
		// down to up
		if (start < endX && start < endY - 1) {
			for (int i = endY - 1; i >= start + 1; i--) {
				matrixList.add(matrix[i][start]);
			}
		}
	}
}
