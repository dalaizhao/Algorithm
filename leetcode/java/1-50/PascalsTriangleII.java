package com.dalai.array1_50;

import java.util.ArrayList;
import java.util.List;

/*Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space? */

public class PascalsTriangleII {

	// 119. Pascal's Triangle II(Ñî»ÔÈý½ÇÐÎ)
	public List<Integer> getRow2(int rowIndex) {

		if (rowIndex < 0)
			return null;
		ArrayList<Integer> arrayList = new ArrayList<>();
		for (int i = 0; i < rowIndex + 1; i++) {
			arrayList.add(1);
			for (int j = i - 1; j > 0; j--) {
				arrayList.set(j, arrayList.get(j - 1) + arrayList.get(j));
			}
		}
		return arrayList;
	}
}
