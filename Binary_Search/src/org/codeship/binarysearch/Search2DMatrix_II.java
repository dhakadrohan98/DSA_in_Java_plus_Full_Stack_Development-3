package org.codeship.binarysearch;

public class Search2DMatrix_II {

	// TC: O(n+m) total no. of rows + total cols in the worst case
	// SC: O(1)
	public boolean searchMatrix(int[][] matrix, int target) {
		int n = matrix.length;
		int m = matrix[0].length;
		int row = 0;
		int col = m - 1;
		while (row < n && col >= 0) {
			if (matrix[row][col] == target) {
				return true;
			}

			if (matrix[row][col] < target) {
				row += 1;
			} else { // if(matrix[row][col] >= target)
				col -= 1;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
