import java.util.Arrays;

/*
 * ��Ŀ����
 *	LL���������ر��,��Ϊ��ȥ����һ���˿���,���������Ȼ��2������,
 *	2��С��(һ����ԭ����54��^_^)...��������г����5����,
 *	�����Լ�������,�����ܲ��ܳ鵽˳��,����鵽�Ļ�,������ȥ��������Ʊ,�ٺ٣���
 *	������A,����3,С��,����,��Ƭ5��,��Oh My God!������˳��.....LL��������,
 *	��������,������\С �����Կ����κ�����,����A����1,JΪ11,QΪ12,KΪ13��
 *	�����5���ƾͿ��Ա�ɡ�1,2,3,4,5��(��С���ֱ���2��4),��So Lucky!����
 *	LL����ȥ��������Ʊ���� ����,Ҫ����ʹ�������ģ������Ĺ���,Ȼ���������LL��������Ρ�
 *	Ϊ�˷������,�������Ϊ��С����0��
 * 
 * */
public class IsContinuous {

	// �˿���˳��
	public boolean isContinuous(int[] numbers) {

		if (numbers == null || numbers.length == 0 || numbers.length != 5)
			return false;
		int zeroCount = 0;
		int len = numbers.length;
		Arrays.sort(numbers);
		for (int i = 0; i < len && numbers[i] == 0; i++) {
			zeroCount++;
		}
		int numbersGap = 0;
		int small = zeroCount;
		int big = small + 1;
		while (big < len) {
			if (numbers[small] == numbers[big]) {
				return false;
			}
			numbersGap += numbers[big] - numbers[small] - 1;
			small = big;
			++big;
		}
		return (numbersGap > zeroCount) ? false : true;
	}
}
