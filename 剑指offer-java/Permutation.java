import java.util.ArrayList;
import java.util.TreeSet;

/*
 * 题目描述
 *	输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 *	例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。 
 *	输入描述:
 *	输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 * */
public class Permutation {

	// 字符串的排列
	public ArrayList<String> permutation(String str) {

		ArrayList<String> result = new ArrayList<String>();
		if (str == null || str.length() == 0) {
			return result;
		}

		char[] chars = str.toCharArray();
		TreeSet<String> temp = new TreeSet<>();
		permutation(chars, 0, temp);
		result.addAll(temp);
		return result;
	}

	public void permutation(char[] chars, int begin, TreeSet<String> result) {
		if (chars == null || chars.length == 0 || begin < 0 || begin > chars.length - 1) {
			return;
		}

		if (begin == chars.length - 1) {
			result.add(String.valueOf(chars));
			System.out.println(String.valueOf(chars));
		} else {
			for (int i = begin; i <= chars.length - 1; i++) {
				swap(chars, begin, i);

				permutation(chars, begin + 1, result);

				swap(chars, begin, i);
			}
		}
	}

	public void swap(char[] x, int a, int b) {
		char t = x[a];
		x[a] = x[b];
		x[b] = t;
	}

}
