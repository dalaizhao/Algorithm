/*
 * ��Ŀ����
 *	�����������һ����λָ�����ѭ�����ƣ�ROL����
 *	�����и��򵥵����񣬾������ַ���ģ�����ָ�����������
 *	����һ���������ַ�����S���������ѭ������Kλ������������
 *	���磬�ַ�����S=��abcXYZdef��,Ҫ�����ѭ������3λ��Ľ����
 *	����XYZdefabc�����ǲ��Ǻܼ򵥣�OK���㶨����
 * */
public class LeftRotateString {

	// ����ת�ַ���
	public String leftRotateString(String str, int n) {

		if (str == null || str.length() == 0 || n <= 0 || n >= str.length())
			return str;
		String subStrLeft = str.substring(0, n);
		String subStrRight = str.substring(n, str.length());
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(subStrRight);
		stringBuilder.append(subStrLeft);
		return stringBuilder.toString();
	}
}
