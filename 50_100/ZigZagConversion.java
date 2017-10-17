package com.dalai.par;

//6. ZigZag Conversion
public class ZigZagConversion {
	/*
	 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
	 * of rows like this: (you may want to display this pattern in a fixed font for
	 * better legibility)
	 * 
	 * P A H N A P L S I I G Y I R And then read line by line: "PAHNAPLSIIGYIR"
	 * Write the code that will take a string and make this conversion given a
	 * number of rows:
	 * 
	 * string convert(string text, int nRows); convert("PAYPALISHIRING", 3) should
	 * return "PAHNAPLSIIGYIR".
	 */
	public String convert(String s, int numRows) {

		if (s == null || s.length() == 0)
			return s;
		char[] ch = s.toCharArray();
		int len = ch.length;
		StringBuffer[] sb = new StringBuffer[numRows];
		for (int i = 0; i < numRows; i++)
			sb[i] = new StringBuffer();
		int i = 0;
		while (i < len) {
			for (int idx = 0; idx < numRows && i < len; idx++)
				sb[idx].append(ch[i++]);
			for (int idx = numRows - 2; idx >= 1 && i < len; idx--)
				sb[idx].append(ch[i++]);
		}
		for (int idx = 1; idx < numRows; idx++)
			sb[0].append(sb[idx]);

		return sb[0].toString();
	}

	public static void main(String[] args) {
		System.out.println(new ZigZagConversion().convert("PAYPALISHIRING", 3));
	}
}
