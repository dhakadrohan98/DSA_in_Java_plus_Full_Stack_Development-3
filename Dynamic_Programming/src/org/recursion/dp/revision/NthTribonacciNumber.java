package org.recursion.dp.revision;

import java.util.Arrays;

public class NthTribonacciNumber {

	// TC: O(3^n) -> O(n) reduced space
	// SC: O(n) stack space + O(n) memoization array
	public int tribonacci(int n) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);
		return rec(n, dp);
	}

	private int rec(int n, int[] dp) {
		// base cases
		if (n == -1)
			return 0;
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		if (dp[n] != -1)
			return dp[n];
		int oneStep = rec(n - 1, dp);
		int twoStep = rec(n - 2, dp);
		int thirdStep = rec(n - 3, dp);
		int steps = oneStep + twoStep + thirdStep;
		return dp[n] = steps;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
