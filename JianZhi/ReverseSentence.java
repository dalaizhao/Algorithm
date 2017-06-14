/*
 * ��Ŀ����
 *	�������һ����Ա��Fish��ÿ���糿���ǻ�����һ��Ӣ����־��дЩ�����ڱ����ϡ�
 *	ͬ��Cat��Fishд�������ĸ���Ȥ����һ������Fish������������ȴ������������˼��
 *	���磬��student. a am I������������ʶ������һ�ԭ���Ѿ��ӵ��ʵ�˳��ת�ˣ�
 *	��ȷ�ľ���Ӧ���ǡ�I am a student.����Cat��һһ�ķ�ת��Щ����˳��ɲ����У����ܰ�����ô��
 * */
public class ReverseSentence {

	// ��ת����˳������
	public String reverseSentence(String str) {

		if (str == null)
			return str;
		char[] strArr = str.toCharArray();
		reverse(strArr, 0, strArr.length - 1);

		int left = 0, right = 0;
		while (left < strArr.length && right < strArr.length) {
			if (strArr[left] == ' ') {
				left++;
				right++;
			} else if (strArr[right] == ' ') {
				reverse(strArr, left, right - 1);
				left = ++right;
			} else if (right == strArr.length - 1) {
				reverse(strArr, left, right);
				left = ++right;
			} else {
				right++;
			}
		}
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0, len = strArr.length; i < len; i++) {
			stringBuilder.append(strArr[i]);
		}
		return stringBuilder.toString();
	}

	public void reverse(char[] strArr, int left, int right) {
		if (strArr == null || strArr.length == 0 || left < 0 || right >= strArr.length)
			return;
		while (left < right) {
			char c = strArr[left];
			strArr[left] = strArr[right];
			strArr[right] = c;
			left++;
			right--;
		}
	}
}
