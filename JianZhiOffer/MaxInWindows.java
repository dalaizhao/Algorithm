import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/*
 * 题目描述
 * 	给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 	例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 	他们的最大值分别为{4,4,6,6,6,5}；
 * 	 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， 
 * 	{2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}，
 * 	 {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * 
 * */
public class MaxInWindows {

	// 滑动窗口的最大值
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
