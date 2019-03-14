/*
 * ��Ŀ����
 * 	��һ������Ϊn����������������ֶ���0��n-1�ķ�Χ�ڡ� 
 * 	������ĳЩ�������ظ��ģ�����֪���м����������ظ��ġ�
 * 	Ҳ��֪��ÿ�������ظ����Ρ����ҳ�����������һ���ظ������֡�
 * 	 ���磬������볤��Ϊ7������{2,3,1,0,2,5,3}����ô��Ӧ������ǵ�һ���ظ�������2��
 * 
 * */
public class Duplicate {

	// �������ظ�������
	public boolean duplicate(int numbers[], int length, int[] duplication) {

		if (numbers == null || numbers.length == 0 || duplication == null || duplication.length != 1
				|| numbers.length != length)
			return false;
		Boolean[] boolArr = new Boolean[length];
		for (int i = 0; i < length; i++)
			boolArr[i] = false;
		for (int i = 0; i < length; i++) {
			if (boolArr[numbers[i]]) {
				duplication[0] = numbers[i];
				return true;
			} else {
				boolArr[numbers[i]] = true;
			}
		}
		return false;
	}
}
