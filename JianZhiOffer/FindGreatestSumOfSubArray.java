/*
 * ��Ŀ����
 *	HZż������Щרҵ������������Щ�Ǽ����רҵ��ͬѧ��
 *	��������鿪����,���ַ�����:�ڹ��ϵ�һάģʽʶ����,
 *	������Ҫ��������������������,������ȫΪ������ʱ��,����ܺý����
 *	����,��������а�������,�Ƿ�Ӧ�ð���ĳ������,�������Աߵ��������ֲ����أ�
 *	����:{6,-3,-2,7,-15,1,2,2},����������������Ϊ8(�ӵ�0����ʼ,����3��Ϊֹ)��
 *	��᲻�ᱻ������ס��(�������ĳ���������1)
 * 
 * */
public class FindGreatestSumOfSubArray {

	// ���������������
	public int findGreatestSumOfSubArray(int[] array) {

		if (array == null || array.length == 0)
			return 0;

		int maxSub = array[0], tmpMaxSub = array[0];

		for (int i = 1, len = array.length; i < len; i++) {
			tmpMaxSub = Math.max(tmpMaxSub + array[i], array[i]);
			maxSub = Math.max(tmpMaxSub, maxSub);
		}

		return maxSub;
	}
}
