package org.codeship.binarysearch.revision;

public class LowerBound {

	// TC: O(logn)
	// SC: O(1)
	public static int findFloor(int[] arr, int x) {
		// write code here
		int ans = -1;
		int n = arr.length;
		int low = 0, high = n - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] >= x) {
				ans = mid;
				//eliminate the right half search space
				high = mid - 1;
			} else {
				//eliminate the left half search space
				low = mid + 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
