/*
 * 题目描述
 *	将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 
 *	数值为0或者字符串不是一个合法的数值则返回0 
 * 
 * */
public class StrToInt {

	// 字符串转换成整数
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
