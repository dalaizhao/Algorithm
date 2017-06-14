import java.util.Arrays;
import java.util.Comparator;

/*
 * 
 * 题目描述
 *	输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 *	打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
 *	则打印出这三个数字能排成的最小数字为321323。
 * */
public class PrintMinNumber {

	// 把数组排成最小的数
	public String printMinNumber(int[] numbers) {

		if (numbers == null || numbers.length == 0)
			return new String();
		String[] strings = new String[numbers.length];
		for (int i = 0, len = numbers.length; i < len; i++) {
			strings[i] = String.valueOf(numbers[i]);
		}
		Arrays.sort(strings, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				int o1Len = o1.length();
				int o2Len = o2.length();
				int i = 0, j = 0;
				boolean iFlag = true, jFlag = true;

				while (i < o1Len && j < o2Len) {
					if (o1.charAt(i) < o2.charAt(j)) {
						return -1;
					} else if (o1.charAt(i) > o2.charAt(j)) {
						return 1;
					}
					i++;
					j++;
					if (i >= o1Len && jFlag) {
						i = 0;
						iFlag = false;
					}
					if (j >= o2Len && iFlag) {
						j = 0;
						jFlag = false;
					}
				}
				return 0;
			}
		});
		StringBuilder stringBuilder = new StringBuilder();
		for (String string : strings) {
			stringBuilder.append(string);
		}
		return stringBuilder.toString();
	}

}
