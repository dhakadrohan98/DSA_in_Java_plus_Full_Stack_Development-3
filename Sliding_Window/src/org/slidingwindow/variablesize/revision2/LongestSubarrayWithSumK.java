package org.slidingwindow.variablesize.revision2;

public class LongestSubarrayWithSumK {

	// TC: O(n)
	// SC: O(n)
	public int longestSubarray(int[] arr, int k) {
		// code here
		int n = arr.length;
		int sum = 0;
		int i = 0, j = 0;
		int longest = 0;
		while (j < n) {
			// do some calculations
			sum += arr[j];
			// hit the condition
			if (sum < k) {
				j++;
			} else if (sum == k) {
				longest = Math.max(longest, j - i + 1);
				j++;
			} else { // sum > k
				// remove calculations from back(i) until sum <= k
				while (sum > k) {
					sum -= arr[i];
					i++;
				}
				// if sum again becomes equals k
				if (sum == k) {
					longest = Math.max(longest, j - i + 1);
				}
				// slide the window from right side
				j++;
			}
		}
		return longest;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
