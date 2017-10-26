import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * ��Ŀ����
 *	��ʵ��һ�����������ж��ַ����Ƿ��ʾ��ֵ������������С������
 *	���磬�ַ���"+100","5e2","-123","3.1416"��"-1E-16"����ʾ��ֵ��
 *	 ����"12e","1a3.14","1.2.3","+-5"��"12e+4.3"�����ǡ�
 * */
public class IsNumeric {

	// ��ʾ��ֵ���ַ���
	public boolean isNumeric(char[] str) {

		if (str == null || str.length == 0)
			return false;
		String string = String.valueOf(str);
		String regex = "[+-]?[0-9]*(\\.[0-9]*)?([eE][+-]?[0-9]+)?";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(string);
		return matcher.matches();
	}
}
