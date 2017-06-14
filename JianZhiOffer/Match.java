import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * ��Ŀ����
 *	��ʵ��һ����������ƥ�����'.'��'*'��������ʽ��
 *	ģʽ�е��ַ�'.'��ʾ����һ���ַ�����'*'��ʾ��ǰ����ַ����Գ�������Σ�����0�Σ���
 *	�ڱ����У�ƥ����ָ�ַ����������ַ�ƥ������ģʽ��
 *	���磬�ַ���"aaa"��ģʽ"a.a"��"ab*ac*a"ƥ�䣬������"aa.a"��"ab*a"����ƥ��
 * 
 * */
public class Match {

	// ������ʽ
	public boolean match(char[] str, char[] pattern) {
		if (str == null | pattern == null)
			return false;
		if (str.length == 0 && pattern.length == 0)
			return true;

		String s1 = String.valueOf(str);
		String s2 = String.valueOf(pattern);

		if (s1.equals(s2))
			return true;

		Pattern p = Pattern.compile(s2);
		Matcher m = p.matcher(s1);
		return m.matches();
	}
}
