package com.dalai.array1_50;

import java.util.ArrayList;

/*Given a m x n matrix, if an element is 0, 
 * set its entire row and column to 0. Do it in place.*/

public class SetMatrixZeroes {

	// 73. Set Matrix Zeroes
	public void setZeroes(int[][] matrix) {

		if (matrix == null || matrix.length == 0)
			return;
		ArrayList<Integer> rowList = new ArrayList<>();
		ArrayList<Integer> colList = new ArrayList<>();
		for (int i = 0, row = matrix.length; i < row; i++)
			for (int j = 0, col = matrix[i].length; j < col; j++) {
				if (matrix[i][j] == 0) {
					rowList.add(i);
					colList.add(j);
				}
			}
		for (int i = 0, len = rowList.size(); i < len; i++) {
			setZeroesRowCol(matrix, rowList.get(i), colList.get(i));
		}
	}

	private void setZeroesRowCol(int[][] matrix, int x, int y) {
		for (int i = 0, row = matrix.length; i < row; i++) {
			if (matrix[i][y] != 0) {
				matrix[i][y] = 0;
			}
		}
		for (int i = 0, col = matrix[x].length; i < col; i++) {
			if (matrix[x][i] != 0) {
				matrix[x][i] = 0;
			}
		}
	}

}
