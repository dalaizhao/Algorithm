import java.util.LinkedList;

/*
 * ��Ŀ����
 *	ÿ����һ��ͯ��,ţ�Ͷ���׼��һЩС����ȥ�����¶�Ժ��С����,����������ˡ�
 *	HF��Ϊţ�͵�����Ԫ��,��ȻҲ׼����һЩС��Ϸ��
 *	����,�и���Ϸ��������:����,��С������Χ��һ����Ȧ��
 *	Ȼ��,�����ָ��һ����m,�ñ��Ϊ0��С���ѿ�ʼ������
 *	ÿ�κ���m-1���Ǹ�С����Ҫ���г��׸�,Ȼ���������Ʒ�����������ѡ����,
 *	���Ҳ��ٻص�Ȧ��,��������һ��С���ѿ�ʼ,����0...m-1����....
 *	������ȥ....ֱ��ʣ�����һ��С����,���Բ��ñ���,
 *	�����õ�ţ������ġ�����̽���ϡ���ذ�(��������Ŷ!!^_^)��
 *	������������,�ĸ�С���ѻ�õ������Ʒ�أ�(ע��С���ѵı���Ǵ�0��n-1)
 * */
public class LastRemaining_Solution {

	// ԲȦ�����ʣ�µ���(Լɪ��)
	public int lastRemaining_Solution(int n, int m) {

		if (n < 1 || m < 1)
			return -1;
		LinkedList<Integer> circleList = new LinkedList<>();
		for (int i = 0; i < n; i++)
			circleList.add(i);
		int index = 0, num = 9;
		while (circleList.size() > 1) {
			int tmpIndex = (index + m - 1) % circleList.size();
			index = (tmpIndex + 1) % circleList.size();
			num = circleList.get(index);
			circleList.remove(tmpIndex);
			index = circleList.indexOf(num);
		}

		return circleList.removeFirst();
	}

}
