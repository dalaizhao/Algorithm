package com.dalai.array1_50;

import java.util.ArrayList;
import java.util.List;

/*Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]*/

public class Pascalsriangle {

	// 118. Pascal's Triangle(Ñî»ÔÈý½ÇÐÎ)
	public List<List<Integer>> getRow(int numRows) {

		if (numRows < 0)
			return null;
		ArrayList<List<Integer>> arrayList = new ArrayList<>();
		for (int i = 0; i < numRows; i++) {
			ArrayList<Integer> arr = new ArrayList<>(i + 1);
			if (i > 0) {
				arr.add(1);
			}
			for (int j = 1; j < i; j++) {
				arr.add(j, arrayList.get(i - 1).get(j - 1) + arrayList.get(i - 1).get(j));
			}
			arr.add(1);
			arrayList.add(arr);
		}
		return arrayList;
	}
}
