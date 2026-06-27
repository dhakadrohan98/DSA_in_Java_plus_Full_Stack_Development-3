package com.codeship.medium.revision3;

public class RotateImage {

	// TC: O(n * n/2)
	// SC: O(1)
	public void rotate(int[][] mat) {
		// n*n matrix
		int n = mat.length;
		// Logic for transpose of a matrix
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				swap(mat, i, j);
			}
		}

		// print the matrix
		// for(int i = 0; i < n; i++) {
		// for(int j = 0; j < n; j++) {
		// System.out.print(mat[i][j] + " ");
		// }
		// System.out.println();
		// }

		// reverse each rows of transpose
		for (int i = 0; i < n; i++) { // access each rows
			for (int j = 0; j < n / 2; j++) { // go till half
				int temp = mat[i][j];
				mat[i][j] = mat[i][n - 1 - j];
				mat[i][n - 1 - j] = temp;
			}
		}
	}

	private void swap(int[][] mat, int i, int j) {
		int temp = mat[i][j];
		mat[i][j] = mat[j][i];
		mat[j][i] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
