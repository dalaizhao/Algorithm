package com.dalai.Array1_50;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/*Given a set of candidate numbers (C) (without duplicates) 
 * and a target number (T), find all unique combinations in C 
 * where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]*/

public class CombinationSum {

	// 39. Combination Sum

	// 这个基于纯递归的实现可以运行成功、但是时间超了，有重复运算。
	//得用回溯算法实现，下面有实现过程。
//	public List<List<Integer>> combinationSum(int[] candidates, int target) {
//
//		Set<List<Integer>> list = new HashSet<>();
//		if (candidates == null || candidates.length == 0)
//			return new ArrayList<List<Integer>>(list);
//		Arrays.sort(candidates);
//		int index = candidates.length;
//		for (int i = 0, len = candidates.length; i < len; i++) {
//			if (candidates[i] > target) {
//				index = i;
//				break;
//			}
//		}
//		List<Integer> each = new ArrayList<>();
//		calculSum(candidates, target, index, list, each);
//		return new ArrayList<List<Integer>>(list);
//	}
//
//	private void calculSum(int[] candidates, int target, int index, Set<List<Integer>> list, List<Integer> each) {
//
//		if (!each.isEmpty()) {
//			int sum = 0;
//			for (Integer integer : each) {
//				sum += integer;
//			}
//			if (sum == target) {
//				Collections.sort(each);
//				list.add(each);
//				return;
//			} else if (sum > target) {
//				return;
//			} else {
//				for (int i = 0; i < index; i++) {
//					each.add(candidates[i]);
//					calculSum(candidates, target, index, list, new ArrayList<>(each));
//					each.remove(each.indexOf(candidates[i]));
//				}
//			}
//		}
//		if (each.isEmpty()) {
//			for (int i = 0; i < index; i++) {
//
//				if (candidates[i] == target) {
//					each.add(candidates[i]);
//					list.add(each);
//				} else {
//					each.add(candidates[i]);
//					calculSum(candidates, target, index, list, new ArrayList<>(each));
//					each.remove(each.indexOf(candidates[i]));
//				}
//			}
//		}
//	}

	// 回溯算法实现
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> list = new ArrayList<>();
		if (candidates == null || candidates.length == 0 || target < 0)
			return list;
		Arrays.sort(candidates);
		backTrack(list, new ArrayList<>(), candidates, target, 0);
		return list;
	}

	private void backTrack(List<List<Integer>> list, List<Integer> tmpList, int[] candidates, int target, int start) {

		if (target < 0)
			return;
		else if (target == 0) {
			list.add(new ArrayList<>(tmpList));
		} else {
			for (int i = start, len = candidates.length; i < len && candidates[i] <= target; i++) {
				tmpList.add(candidates[i]);
				backTrack(list, tmpList, candidates, target - candidates[i], i);
				tmpList.remove(tmpList.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		int[] candidates = { 2, 3, 6, 7 };

		CombinationSum combinationSum = new CombinationSum();
		List<List<Integer>> lsit = combinationSum.combinationSum(candidates, 7);

		System.out.println(lsit.toString());
	}
}
