package com.codeship.medium.revision3;

public class SetMatrixZeroes {

	public void setZeroes(int[][] mat) {
		// n->rows, m-> columns
		int n = mat.length;
		int m = mat[0].length;

		// require one copy array to keep track of original 0s positions
		int[][] copy = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				copy[i][j] = mat[i][j];
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (copy[i][j] == 0) {
					int row = i - 1; // up direction
					while (row >= 0) {
						mat[row][j] = 0;
						row -= 1;
					}
					// reset row to i for down direction
					row = i + 1; // down direction
					while (row < n) {
						mat[row][j] = 0;
						row += 1;
					}
					row = i;

					int col = j - 1; // left direction
					while (col >= 0) {
						mat[i][col] = 0;
						col -= 1;
					}
					col = j + 1; // right direction
					while (col < m) {
						mat[i][col] = 0;
						col += 1;
					}
					col = j;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
