import java.util.ArrayList;

/*
 * 
 * 题目描述
 *	输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 *	例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 *	则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * 
 * */

public class PrintMatrix {

	// 顺时针打印矩阵
	public ArrayList<Integer> printMatrix(int[][] matrix) {

		if (matrix == null || matrix.length == 0)
			return null;
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
