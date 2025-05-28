package org.recursion.dp.revision;

import java.util.Arrays;

public class FrogWithJumpK {

	// TC: O(n * k)
	// SC: O(n) memoization array space + O(n) stack space due to rec call
	public static int frogJump(int n, int k, int heights[]) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);
		return rec(n - 1, k, heights, dp);
	}

	private static int rec(int indx, int k, int[] heights, int[] dp) {
		// base case
		if (indx == 0) {
			return 0;
		}
		// memoization check
		if (dp[indx] != -1) {
			return dp[indx];
		}
		int minSteps = Integer.MAX_VALUE;
		for (int j = 1; j <= k; j++) {
			int jumps = Integer.MAX_VALUE;
			if (indx > j - 1) {
				jumps = Math.abs(heights[indx] - heights[indx - j]) + rec(indx - j, k, heights, dp);
			}
			minSteps = Math.min(minSteps, jumps);
		}
		return dp[indx] = minSteps;
	}

	public static void main(String[] args) {
		int[] nums = { 10, 5, 20, 0, 15 };
		int[] nums1 = { 30, 10, 60, 10, 60, 50 };
		int k = 2;
		int n = nums1.length;
		int frogJump = frogJump(n, k, nums1);
		System.out.println(frogJump);
	}

}
