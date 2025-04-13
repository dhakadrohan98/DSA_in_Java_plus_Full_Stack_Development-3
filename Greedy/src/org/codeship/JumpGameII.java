package org.codeship;

import java.util.Arrays;

public class JumpGameII {

	// Approach-2 Greedy
	// TC: O(n)
	// SC: O(1)
	public int jumpGreedyApproach(int[] nums) {
		int n = nums.length;
		int l = 0, r = 0, jumps = 0;
		// r will till n-2 because there are four ranges has been made including the
		// first element in the range as l=0, r=0.
		while (r < n - 1) {
			int farthest = 0;
			for (int i = l; i <= r; i++) {
				farthest = Math.max(farthest, nums[i] + i);
			}
			jumps += 1;
			// update the range
			l = r + 1;
			r = farthest;
		}
		return jumps;
	}

	// Approach-1 Dp solution
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
