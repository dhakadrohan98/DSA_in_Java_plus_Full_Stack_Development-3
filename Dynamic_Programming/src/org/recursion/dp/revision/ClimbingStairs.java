package org.recursion.dp.revision;

import java.util.Arrays;

public class ClimbingStairs {
	
	// TC: O(2^n) -> O(n) reduced space
	// SC: O(n) stack space + O(n) memoization array
	public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return rec(n, dp);
    }

    private int rec(int n, int[] dp) {
        //base case
        if(n == 0) return 1;
        if(n == -1) return 0;
        if(dp[n] != -1) return dp[n];
        int oneStep = rec(n-1, dp);
        int twoStep = rec(n-2, dp);
        int steps = oneStep + twoStep;
        return dp[n] = steps;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
