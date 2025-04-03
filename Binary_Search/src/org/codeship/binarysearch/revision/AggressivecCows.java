package org.codeship.binarysearch.revision;

import java.util.Arrays;

public class AggressivecCows {

	// TC: O(nlogn) + O(log2 (max - min) * n)
	// SC: O(1)
	private static boolean canWePlace(int[] arr, int cows, int dist) {
		int n = arr.length;
		int cntCows = 1;
		int last = arr[0];
		for (int i = 0; i < n; i++) {
			if (arr[i] - last >= dist) {
				cntCows++;
				last = arr[i];
			}
			// if we are able to place all cows then return true from here
			if (cntCows >= cows) {
				return true;
			}
		}
		return false;
	}

	public static int aggressiveCows(int[] arr, int cows) {
		// sort the array first for applying BS
		Arrays.sort(arr);
		int n = arr.length;
		int ans = 0;
		int low = 0, high = arr[n - 1];
		// max - min
		while (low <= high) {
			int mid = (low + high) / 2;
			if (canWePlace(arr, cows, mid)) {
				ans = mid;
				// need to maximize the ans, eliminate the left half search space
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
