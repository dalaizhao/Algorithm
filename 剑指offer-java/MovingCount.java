/*
 * 题目描述
 *	地上有一个m行和n列的方格。
 *	一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 *	但是不能进入行坐标和列坐标的数位之和大于k的格子。
 *	 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 *	但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * */
public class MovingCount {

	// 机器人的运动范围
	public int movingCount(int threshold, int rows, int cols) {
		if (threshold < 0 || rows < 0 || cols < 0)
			return 0;
		boolean[][] matrix = new boolean[rows][cols];

		return canMove(matrix, 0, 0, threshold);
	}

	private int canMove(boolean[][] matrix, int i, int j, int threshold) {

		if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length)
			return 0;

		if (!canIn(i, j, threshold))
			return 0;

		if (!matrix[i][j]) {
			matrix[i][j] = true;

			return 1 + canMove(matrix, i + 1, j, threshold) + canMove(matrix, i, j + 1, threshold)
					+ +canMove(matrix, i - 1, j, threshold) + canMove(matrix, i, j - 1, threshold);
		}
		return 0;
	}

	private boolean canIn(int i, int j, int threshold) {

		int sum = 0;
		while (i != 0) {
			sum += i % 10;
			i = i / 10;
		}
		while (j != 0) {
			sum += j % 10;
			j = j / 10;
		}
		if (sum > threshold)
			return false;
		return true;
	}
}
