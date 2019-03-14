import java.util.HashMap;

/*
 * ��Ŀ����
 *	��һ���ַ���(1<=�ַ�������<=10000��
 *	ȫ������ĸ���)���ҵ���һ��ֻ����һ�ε��ַ�,����������λ��
 * */
public class FirstNotRepeatingChar {

	// ��һ��ֻ����һ�ε��ַ�
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
