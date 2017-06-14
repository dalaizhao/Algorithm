/*
 * 题目描述
 *	最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 *	同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 *	例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 *	正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 * */
public class ReverseSentence {

	// 反转单词顺序序列
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
