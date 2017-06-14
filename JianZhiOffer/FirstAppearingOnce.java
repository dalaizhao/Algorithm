/*
 * ��Ŀ����
 *	��ʵ��һ�����������ҳ��ַ����е�һ��ֻ����һ�ε��ַ���
 *	���磬�����ַ�����ֻ����ǰ�����ַ�"go"ʱ����һ��ֻ����һ�ε��ַ���"g"��
 *	���Ӹ��ַ����ж���ǰ�����ַ���google"ʱ����һ��ֻ����һ�ε��ַ���"l"�� 
 * 
 * */
public class FirstAppearingOnce {

	// �ַ����е�һ�����ظ����ַ�
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
