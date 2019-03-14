package com.dalai.par;

//463. Island Perimeter
public class IslandPerimeter {

	/*
	 * You are given a map in form of a two-dimensional integer grid where 1
	 * represents land and 0 represents water. Grid cells are connected
	 * horizontally/vertically (not diagonally). The grid is completely surrounded
	 * by water, and there is exactly one island (i.e., one or more connected land
	 * cells). The island doesn't have "lakes" (water inside that isn't connected to
	 * the water around the island). One cell is a square with side length 1. The
	 * grid is rectangular, width and height don't exceed 100. Determine the
	 * perimeter of the island.
	 */

	public int islandPerimeter(int[][] grid) {

		if (grid == null)
			return 0;
		int islands = 0, neighbours = 0;
		for (int i = 0, xLen = grid.length; i < xLen; i++) {
			for (int j = 0, yLen = grid[i].length; j < yLen; j++) {
				if (grid[i][j] == 1) {
					islands++;
					if (i < xLen - 1 && grid[i + 1][j] == 1)
						neighbours++;
					if (j < yLen - 1 && grid[i][j + 1] == 1)
						neighbours++;
				}
			}
		}
		return islands * 4 - neighbours * 2;
	}
}
