package org.recursion.dp.revision;

import java.util.Arrays;

public class FromJump {

	// TC: O(n)
	// SC: O(n) memoization array space + O(n) stack space due to rec call
	public static int frogJump(int n, int heights[]) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);
		return rec(n - 1, heights, dp);
	}

	private static int rec(int n, int[] heights, int[] dp) {
		// base case
		if (n == 0)
			return 0;
		if (dp[n] != -1)
			return dp[n];
		int left = Math.abs(heights[n] - heights[n - 1]) + rec(n - 1, heights, dp);
		int right = Integer.MAX_VALUE;
		if (n > 1) {
			right = Math.abs(heights[n] - heights[n - 2]) + rec(n - 2, heights, dp);
		}
		return dp[n] = Math.min(left, right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
