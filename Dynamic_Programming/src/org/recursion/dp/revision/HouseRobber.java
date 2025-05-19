package org.recursion.dp.revision;

public class HouseRobber {
	
	//TC: O(n) linear no. of iteration
    //SC: O(n) stack space + O(n) memoization array space
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);
        int lastIndex = rec(n-1, nums, dp);
        int secondLastIndex = rec(n-2, nums, dp);
        return Math.max(lastIndex, secondLastIndex);
    }

    private int rec(int n, int[] nums, int[] dp) {
        //base cases
        if(n == 0) return nums[0];
        if(n < 0) return 0;
        if(dp[n] != -1) return dp[n];

        int left = nums[n] + rec(n-2, nums, dp);
        int right = nums[n] + rec(n-3, nums, dp);
        return dp[n] = Math.max(left, right);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
