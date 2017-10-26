package com.dalai.par;

import java.util.Arrays;
import java.util.Stack;

//85. Maximal Rectangle
public class MaximalRectangle {

	/*
	 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle
	 * containing only 1's and return its area.
	 * 
	 * For example, given the following matrix:
	 */
	// 1 0 1 0 0
	// 1 0 1 1 1
	// 1 1 1 1 1
	// 1 0 0 1 0
	// Return 6.

	public int maximalRectangle(char[][] matrix) {

		if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0)
			return 0;

		int[] heights = new int[matrix[0].length];
		Arrays.fill(heights, 0);
		int maxArea = 0;

		for (int i = 0, len = matrix.length; i < len; i++) {
			for (int j = 0, len2 = matrix[i].length; j < len2; j++) {

				if (matrix[i][j] == '1') {
					heights[j] += 1;
				} else {
					heights[j] = 0;
				}
				System.out.println(Arrays.toString(heights));

			}
			maxArea = Math.max(calculateMaxArea(heights), maxArea);
		}

		return maxArea;
	}

	public int calculateMaxArea(int[] heights) {

		if (heights == null || heights.length <= 0)
			return 0;
		Stack<Integer> stack = new Stack<>();
		int maxArea = 0;
		int len = heights.length;
		for (int i = 0; i <= len; i++) {
			int h = (i == len ? 0 : heights[i]);

			if (stack.empty() || h >= heights[stack.peek()]) {
				stack.push(i);
			} else {
				int tp = stack.pop();
				maxArea = Math.max(maxArea, heights[tp] * (stack.isEmpty() ? i : i - 1 - stack.peek()));
				i--;
			}
		}
		return maxArea;
	}

	public static void main(String[] args) {

		char[][] arr = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '0' } };
		char[][] arr1 = { { '0', '1' }, { '1', '0' } };
		System.out.println(new MaximalRectangle().maximalRectangle(arr));

	}

}
