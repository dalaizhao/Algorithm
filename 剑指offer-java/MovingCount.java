/*
 * ��Ŀ����
 *	������һ��m�к�n�еķ���
 *	һ�������˴�����0,0�ĸ��ӿ�ʼ�ƶ���ÿһ��ֻ�������ң��ϣ����ĸ������ƶ�һ��
 *	���ǲ��ܽ�������������������λ֮�ʹ���k�ĸ��ӡ�
 *	 ���磬��kΪ18ʱ���������ܹ����뷽��35,37������Ϊ3+5+3+7 = 18��
 *	���ǣ������ܽ��뷽��35,38������Ϊ3+5+3+8 = 19�����ʸû������ܹ��ﵽ���ٸ����ӣ�
 * */
public class MovingCount {

	// �����˵��˶���Χ
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
