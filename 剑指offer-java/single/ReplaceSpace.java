
/*
 * ��Ŀ����:
 *	��ʵ��һ����������һ���ַ����еĿո��滻�ɡ�%20����
 *	���磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
 **/

public class ReplaceSpace {

	// �滻�ո�
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
