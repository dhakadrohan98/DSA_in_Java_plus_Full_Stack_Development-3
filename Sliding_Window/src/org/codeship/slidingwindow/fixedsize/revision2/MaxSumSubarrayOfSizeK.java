package org.codeship.slidingwindow.fixedsize.revision2;

public class MaxSumSubarrayOfSizeK {

	// TC: O(n)
	// SC: O(n)
	public int maximumSumSubarray(int[] arr, int k) {
		// Code here
		int n = arr.length;
		int sum = 0;
		int maxi = 0;
		int i = 0, j = 0;
		while (j < n) {
			sum += arr[j];
			// window size has not been hit
			if (j - i + 1 < k) {
				j++;
			} else if (j - i + 1 == k) {
				// calculate ans
				maxi = Math.max(maxi, sum);
				// remove calculations for i
				sum -= arr[i];
				// maintain the size & slide the window
				i++;
				j++;
			}
		}
		return maxi;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
