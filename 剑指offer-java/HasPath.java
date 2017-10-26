/*
 * 题目描述
 *	请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 *	路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 *	如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 *	 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，
 *	但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
 *	路径不能再次进入该格子。
 * */
public class HasPath {

	// 矩阵中的路径
	public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {

		if (matrix == null || str == null || matrix.length == 0 || str.length == 0)
			return false;

		for (int i = 0, len = matrix.length; i < len; i++) {
			if (exist(matrix, rows, cols, i, str, 0))
				return true;
		}

		return false;
	}

	private boolean exist(char[] board, int rows, int cols, int index, char[] word, int start) {

		if (start >= word.length)
			return true;
		if (index < 0 || index >= board.length)
			return false;
		if (board[index] == word[start++]) {
			char c = board[index];
			board[index] = '#';
			boolean res = exist(board, rows, cols, cols + index, word, start)
					|| exist(board, rows, cols, index + 1, word, start)
					|| exist(board, rows, cols, index - cols, word, start)
					|| exist(board, rows, cols, index - 1, word, start);
			board[index] = c;
			return res;
		}
		return false;
	}
}
