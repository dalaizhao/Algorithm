package com.dalai.par;

import java.util.*;

//599. Minimum Index Sum of Two Lists
public class MinimumIndexSumOfTwoLists {

	/*
	 * Suppose Andy and Doris want to choose a restaurant for dinner, and they both
	 * have a list of favorite restaurants represented by strings.
	 * 
	 * You need to help them find out their common interest with the least list
	 * index sum. If there is a choice tie between answers, output all of them with
	 * no order requirement. You could assume there always exists an answer.
	 */

	public String[] findRestaurant(String[] list1, String[] list2) {

		Map<String, Integer> map = new HashMap<>();
		List<String> res = new LinkedList<>();

		int minSum = Integer.MAX_VALUE;
		for (int i = 0, len1 = list1.length; i < len1; i++)
			map.put(list1[i], i);
		for (int i = 0, len2 = list2.length; i < len2; i++) {
			Integer j = map.get(list2[i]);
			if (j != null && i + j <= minSum) {
				if (i + j < minSum) {
					res.clear();
					minSum = i + j;
				}
				res.add(list2[i]);
			}
		}
		return res.toArray(new String[res.size()]);
	}
}
