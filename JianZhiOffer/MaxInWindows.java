import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/*
 * ��Ŀ����
 * 	����һ������ͻ������ڵĴ�С���ҳ����л�����������ֵ�����ֵ��
 * 	���磬�����������{2,3,4,2,6,2,5,1}���������ڵĴ�С3����ôһ������6���������ڣ�
 * 	���ǵ����ֵ�ֱ�Ϊ{4,4,6,6,6,5}��
 * 	 �������{2,3,4,2,6,2,5,1}�Ļ�������������6���� {[2,3,4],2,6,2,5,1}�� 
 * 	{2,[3,4,2],6,2,5,1}�� {2,3,[4,2,6],2,5,1}�� {2,3,4,[2,6,2],5,1}��
 * 	 {2,3,4,2,[6,2,5],1}�� {2,3,4,2,6,[2,5,1]}��
 * 
 * */
public class MaxInWindows {

	// �������ڵ����ֵ
	public ArrayList<Integer> maxInWindows(int[] num, int size) {

		ArrayList<Integer> list = new ArrayList<>();
		if (num == null || num.length == 0 || size < 1)
			return list;
		LinkedList<Integer> temp = new LinkedList<>();
		int len = num.length;
		if (len >= size) {
			int index = 0;
			while (index < size) {
				temp.add(num[index]);
				index++;
			}
			list.add(Collections.max(temp));
			while (index < len) {
				temp.removeFirst();
				temp.add(num[index]);
				list.add(Collections.max(temp));
				index++;
			}
		} else {
			return list;
		}
		return list;
	}
}
