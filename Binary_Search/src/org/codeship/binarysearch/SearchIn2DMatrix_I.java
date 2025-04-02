package org.codeship.binarysearch;

public class SearchIn2DMatrix_I {

	// TC: O(log2 (n*m))
	// SC: O(1)
	public boolean searchMatrix(int[][] mat, int target) {
		int n = mat.length;
		int m = mat[0].length;
		int low = 0;
		int high = n * m - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			// calculate actual row & col index from hypothetical 1D array
			int row = mid / m;
			int col = mid % m;
			if (mat[row][col] == target) {
				return true;
			} else if (mat[row][col] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		// target is not found in the matrix
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
