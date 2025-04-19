package com.recusrion.revision;

import java.util.Arrays;

public class SubsetSum {

	// TC: O(n^2)
	// SC: O(n) due to stack space + O(n*sum) memoization space
	public static Boolean isSubsetSum(int arr[], int sum) {
		int n = arr.length;
		int[][] dp = new int[n + 1][sum + 1];
		for (int[] temp : dp) {
			Arrays.fill(temp, -1);
		}
		return fuc(n - 1, sum, arr, dp);
	}

	private static Boolean fuc(int indx, int sum, int[] arr, int[][] dp) {
		// base case
		if (sum == 0)
			return true;
		if (indx < 0)
			return false;

		// memoization check
		if (dp[indx][sum] != -1) {
			if (dp[indx][sum] == 1) {
				return true;
			} else {
				return false;
			}
		}

		// pick or not pick
		boolean left = false;
		if (sum >= arr[indx]) {
			left = fuc(indx - 1, sum - arr[indx], arr, dp);
		}
		boolean right = fuc(indx - 1, sum, arr, dp);
		if (left || right) {
			dp[indx][sum] = 1;
		} else {
			dp[indx][sum] = 0;
		}
		return left || right;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
