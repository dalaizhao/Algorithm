/*
 * ��Ŀ����
 *	�����һ�������������ж���һ���������Ƿ����һ������ĳ�ַ��������ַ���·����
 *	·�����ԴӾ����е�����һ�����ӿ�ʼ��ÿһ�������ھ������������ң����ϣ������ƶ�һ�����ӡ�
 *	���һ��·�������˾����е�ĳһ�����ӣ����·�������ٽ���ø��ӡ�
 *	 ���� a b c e s f c s a d e e �����а���һ���ַ���"bcced"��·����
 *	���Ǿ����в�����"abcb"·������Ϊ�ַ����ĵ�һ���ַ�bռ���˾����еĵ�һ�еڶ�������֮��
 *	·�������ٴν���ø��ӡ�
 * */
public class HasPath {

	// �����е�·��
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
