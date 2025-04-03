package org.codeship.binarysearch.revision;

public class KthSmallestElementInSortedArray_OptimalApproach {

	// TC: O(nlog(max−min)logn)
	// max = the largest element in the matrix (mat[n-1][n-1])
	// min = the smallest element in the matrix (mat[0][0])
	// performing binary search on values from mat[0][0] to mat[n-1][n-1], the
	// number of iterations in binary search is roughly log(max-min).
	// SC: O(1)
	private int upperBound(int[] arr, int x) {
		// write code here
		int n = arr.length;
		int ans = n;
		int low = 0, high = n - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] > x) {
				ans = mid;
				// eliminate the right half search space
				high = mid - 1;
			} else {
				// eliminate the left half search space
				low = mid + 1;
			}
		}
		return ans;
	}

	public int kthSmallest(int[][] mat, int k) {
		int n = mat.length;
		// apply binary search on range rather than indexes
		int low = mat[0][0];
		int high = mat[n - 1][n - 1];
		// TC: O(log (n * logn))
		while (low < high) {
			int mid = (low + high) / 2;
			// how many small elements are present than k
			int count = 0;
			for (int i = 0; i < n; i++) {
				count += upperBound(mat[i], mid);
			}

			if (count < k) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
