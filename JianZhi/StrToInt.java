/*
 * ��Ŀ����
 *	��һ���ַ���ת����һ��������Ҫ����ʹ���ַ���ת�������Ŀ⺯���� 
 *	��ֵΪ0�����ַ�������һ���Ϸ�����ֵ�򷵻�0 
 * 
 * */
public class StrToInt {

	// �ַ���ת��������
	private boolean illegal = false;

	public int strToInt(String str) {

		if (str == null || str.length() == 0) {
			illegal = true;
			return 0;
		}

		int index = 0;
		if (str.charAt(index) == '+' || str.charAt(index) == '-')
			index++;
		while (index < str.length() && (Character.isDigit(str.charAt(index)))) {
			index++;
		}
		if (index == str.length() && index > 1)
			return Integer.valueOf(str);

		return 0;
	}
}
