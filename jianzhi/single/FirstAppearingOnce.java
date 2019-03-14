/*
 * 题目描述
 *	请实现一个函数用来找出字符流中第一个只出现一次的字符。
 *	例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 *	当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。 
 * 
 * */
public class FirstAppearingOnce {

	// 字符流中第一个不重复的字符
	private int[] count = new int[256];
	private int index = 1;
	private final int Length = 256;

	// Insert one char from stringstream
	public void insert(char ch) {
		if (count[ch] == 0) {
			count[ch] = index++;
		} else {
			count[ch] = -1;
		}
	}

	// return the first appearence once char in current stringstream
	public char firstAppearingOnce() {
		int temp = Integer.MAX_VALUE;
		char ch = '#';
		for (int i = 0; i < Length; i++) {
			if (count[i] != 0 && count[i] != -1 && count[i] < temp) {
				temp = count[i];
				ch = (char) i;
			}
		}
		return ch;
	}
}
