import java.util.ArrayList;

/*
 * 题目描述
 *	输入n个整数，找出其中最小的K个数。
 *	例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 **/
public class GetLeastNumbers_Solution {

	// 最小的k个数
	public ArrayList<Integer> getLeastNumbers_Solution(int[] input, int k) {

		ArrayList<Integer> tmpList = new ArrayList<>();

		if (input == null || input.length == 0 || k > input.length || k <= 0)
			return tmpList;
		int[] maxHeap = new int[k];
		for (int i = 0, len = input.length; i < len; i++) {
			if (i < k) {
				maxHeap[i] = input[i];
			} else {

				if (maxHeap[k - 1] > input[i]) {
					maxHeap[k - 1] = input[i];
					heapSort(maxHeap);
				}
			}
			if (i == k - 1)
				heapSort(maxHeap);
		}

		for (int i = 0; i < k; i++) {
			tmpList.add(maxHeap[i]);
		}
		return tmpList;
	}

	private void heapSort(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		for (int len = nums.length, i = len / 2 - 1; i >= 0; --i) {
			percDown(nums, i, len);
		}
		for (int i = nums.length - 1; i > 0; i--) {
			swapReference(nums, 0, i);
			percDown(nums, 0, i);
		}
	}

	private void percDown(int[] nums, int i, int len) {

		int child = 0;
		int tmp = 0;
		for (tmp = nums[i]; leftChild(i) < len; i = child) {
			child = leftChild(i);
			if (child != len - 1 && nums[child] < nums[child + 1])
				child++;
			if (tmp < nums[child])
				nums[i] = nums[child];
			else
				break;
		}
		nums[i] = tmp;
	}

	private int leftChild(int i) {

		return 2 * i + 1;
	}

	private void swapReference(int[] nums, int i, int j) {

		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

}
