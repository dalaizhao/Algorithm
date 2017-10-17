package com.dalai.Array1_50;

import java.util.ArrayList;
import java.util.List;

import jdk.nashorn.internal.runtime.linker.LinkerCallSite;

/*Find all possible combinations of k numbers that add up to a number n, 
 * given that only numbers from 1 to 9 can be used 
 * and each combination should be a unique set of numbers.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]

Credits:
Special thanks to @mithmatt for adding this problem and creating all test cases.*/

public class CombinationSumIII {

	// 216. Combination Sum III
	public List<List<Integer>> combinationSum3(int k, int n) {

		List<List<Integer>> list = new ArrayList<>();
		if (k < 0 || n < 1)
			return list;
		int num = 10;
		combinationSum(list, new ArrayList<>(), k, n, 1, num);

		return list;
	}

	private void combinationSum(List<List<Integer>> list, ArrayList tempList, int k, int n, int start, int num) {

		if (n < 0 || k < 0) {
			return;
		} else if (n == 0 && k == 0) {
			list.add(tempList);
			return;
		} else if (k > 0 && n > 0) {
			for (int i = start; i < num && i <= n; i++) {
				tempList.add(i);
				combinationSum(list, new ArrayList<>(tempList), k - 1, n - i, i + 1, num);
				tempList.remove(tempList.size() - 1);
			}
		} else {
			;
		}
	}

	public static void main(String[] args) {
		System.out.println(new CombinationSumIII().combinationSum3(3, 9).toString());
	}
}
