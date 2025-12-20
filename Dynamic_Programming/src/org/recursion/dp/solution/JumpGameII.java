package org.recursion.dp.solution;

import java.util.Arrays;

public class JumpGameII {

	// TC: O(n^2)
	// SC: O(n^2)
	private int rec(int indx, int jumps, int[] nums, int[][] dp) {
		// base case
		if (indx >= nums.length - 1) {
			return jumps;
		}

		// memoization
		if (dp[indx][jumps] != -1) {
			return dp[indx][jumps];
		}

		int mini = Integer.MAX_VALUE;
		for (int i = 1; i <= nums[indx]; i++) {
			mini = Math.min(mini, rec(indx + i, jumps + 1, nums, dp));
		}

		dp[indx][jumps] = mini;
		return mini;
	}

	public int jump(int[] nums) {
		int n = nums.length;
		int[][] dp = new int[n + 1][n + 1];
		for (int[] arr : dp) {
			Arrays.fill(arr, -1);
		}
		// f(index, jumps)
		return rec(0, 0, nums, dp);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
