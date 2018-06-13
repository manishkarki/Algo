package com.prac.hackerrank.algorithm;

/**
 * @author Manish Karki
 * 
 */

// Java program to count islands in boolean 2D matrix

public class CountIsland {
	// No of rows and columns
	static final int ROW = 5, COL = 5;

	// A function to check if a given cell (row, col) can
	// be included in DFS
	boolean isSafe(int M[][], int row, int col, boolean visited[][]) {
		// row number is in range, column number is in range
		// and value is 1 and not yet visited
		return ((row >= 0) && (row < M.length) && (col >= 0) && (col < M[0].length) && (M[row][col] == 1)
				&& !visited[row][col]);

	}

	// A utility function to do DFS for a 2D boolean matrix.
	// It only considers the 8 neighbors as adjacent vertices
	void DFS(int M[][], int row, int col, boolean visited[][]) {
		int[] possibleRow = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] possibleCol = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };

		visited[row][col] = true;

		for (int k = 0; k < 8; ++k)
			if (isSafe(M, row + possibleRow[k], col + possibleCol[k], visited))
				DFS(M, row + possibleRow[k], col + possibleCol[k], visited);
	}

	// The main function that returns count of islands in a given
	// boolean 2D matrix
	int countIslands(int M[][]) {
		// Make a bool array to mark visited cells.
		// Initially all cells are unvisited
		boolean visited[][] = new boolean[ROW][COL];

		// Initialize count as 0 and travese through the all cells
		// of given matrix
		int count = 0;
		for (int i = 0; i < ROW; ++i)
			for (int j = 0; j < COL; ++j)
				if (M[i][j] == 1 && !visited[i][j]) // If a cell with
				{ // value 1 is not
					// visited yet, then new island found, Visit all
					// cells in this island and increment island count
					DFS(M, i, j, visited);
					++count;
				}

		return count;
	}

	// Driver method
	public static void main(String[] args) throws java.lang.Exception {
		int M[][] = new int[][] { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 },
				{ 1, 0, 1, 0, 1 } };
		CountIsland I = new CountIsland();
		System.out.println("Number of islands is: " + I.countIslands(M));
	}
}