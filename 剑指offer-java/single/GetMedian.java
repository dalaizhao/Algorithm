import java.util.ArrayList;
import java.util.Comparator;

/*
 * 题目描述
 *	如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
 *	那么中位数就是所有数值排序之后位于中间的数值。
 *	如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * */
public class GetMedian {

	// 数据流中的中心数
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
