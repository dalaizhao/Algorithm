import java.util.HashMap;

/*
 * 题目描述
 *	在一个字符串(1<=字符串长度<=10000，
 *	全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 * */
public class FirstNotRepeatingChar {

	// 第一个只出现一次的字符
	public int firstNotRepeatingChar(String str) {

		if (str == null || str.length() == 0)
			return -1;
		HashMap<Character, Integer> hashMap = new HashMap<>();
		for (int i = 0, len = str.length(); i < len; i++) {
			char c = str.charAt(i);
			if (hashMap.containsKey(c)) {
				hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
			} else {
				hashMap.put(c, 1);
			}
		}
		for (int i = 0, len = str.length(); i < len; i++) {
			char c = str.charAt(i);
			if (hashMap.get(c) == 1)
				return i;
		}
		return -1;
	}
}
