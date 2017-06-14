import java.util.ArrayList;

/*
 * ��Ŀ����
 *	С����ϲ����ѧ,��һ����������ѧ��ҵʱ,Ҫ������9~16�ĺ�,�����Ͼ�д������ȷ����100��
 *	���������������ڴ�,�����뾿���ж������������������еĺ�Ϊ100(���ٰ���������)��
 *	û���,���͵õ���һ������������Ϊ100������:18,19,20,21,22��
 *	���ڰ����⽻����,���ܲ���Ҳ�ܿ���ҳ����к�ΪS��������������? Good Luck! 
 * 
 * */
public class FindContinuousSequence {

	// ��ΪS��������������
	public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		if (sum < 0)
			return list;
		int index = 1, small = 1, big = 1, tmpCount = 0;
		while (index <= sum) {
			if (tmpCount == sum) {
				ArrayList<Integer> tmpList = new ArrayList<>();
				for (int i = small; i <= big; i++) {
					tmpList.add(i);
				}
				list.add(tmpList);
				tmpCount -= small;
				small++;
			} else if (tmpCount < sum) {
				tmpCount += index;
				big = index;
				index++;
			} else {
				tmpCount -= small;
				small++;
			}
		}
		return list;
	}
}
