package com.dalai.par;

import java.util.Stack;

//84. Largest Rectangle in Histogram
public class LargestRectangleInHistogram {

	/*
	 * Given n non-negative integers representing the histogram's bar height where
	 * the width of each bar is 1, find the area of largest rectangle in the
	 * histogram.
	 * 
	 * 
	 * Above is a histogram where width of each bar is 1, given height =
	 * [2,1,5,6,2,3].
	 * 
	 * 
	 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
	 * 
	 * For example, Given heights = [2,1,5,6,2,3], return 10.
	 * 
	 */
	public int largestRectangleArea(int[] heights) {

		if (heights == null || heights.length < 0)
			return 0;

		int len = heights.length;
		Stack<Integer> stack = new Stack<>();
		int maxArea = 0;

		for (int i = 0; i <= len; i++) {
			int h = (i == len ? 0 : heights[i]);
			if (stack.isEmpty() || h >= heights[stack.peek()]) {
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

		System.out.println(new LargestRectangleInHistogram().largestRectangleArea(new int[] { 2, 0, 5, 6, 2, 3 }));
	}

}
