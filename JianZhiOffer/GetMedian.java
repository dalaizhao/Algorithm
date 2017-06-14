import java.util.ArrayList;
import java.util.Comparator;

/*
 * ��Ŀ����
 *	��εõ�һ���������е���λ����������������ж�����������ֵ��
 *	��ô��λ������������ֵ����֮��λ���м����ֵ��
 *	������������ж���ż������ֵ����ô��λ������������ֵ����֮���м���������ƽ��ֵ��
 * */
public class GetMedian {

	// �������е�������
	private ArrayList<Integer> arrayList = new ArrayList<>();

	public void Insert(Integer num) {
		arrayList.add(num);
		arrayList.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1 == o2) {
					return 0;
				} else if (o1 > o2) {
					return 1;
				}
				return -1;
			}
		});
	}

	public Double getMedian() {

		if (arrayList.isEmpty())
			return -1.0;
		int index = arrayList.size() / 2;
		if (arrayList.size() % 2 == 0) {
			return (arrayList.get(index - 1) + arrayList.get(index)) / 2.0;
		} else {
			return arrayList.get(index) / 2.0;
		}
	}

}
