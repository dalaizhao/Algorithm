
/*
 * 题目描述:
 *	请实现一个函数，将一个字符串中的空格替换成“%20”。
 *	例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 **/

public class ReplaceSpace {

	// 替换空格
	public String replaceSpace(StringBuffer str) {

		if (str == null || str.length() == 0) {
			return str.toString();
		}
		StringBuffer stringBuffer = new StringBuffer();

		for (int i = 0, len = str.length(); i < len; i++) {
			if (str.charAt(i) == ' ') {
				stringBuffer.append("%20");
			} else {
				stringBuffer.append(str.charAt(i));
			}
		}
		return stringBuffer.toString();
	}

}
