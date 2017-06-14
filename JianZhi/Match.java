import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 题目描述
 *	请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 *	模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 *	在本题中，匹配是指字符串的所有字符匹配整个模式。
 *	例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 * 
 * */
public class Match {

	// 正则表达式
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
