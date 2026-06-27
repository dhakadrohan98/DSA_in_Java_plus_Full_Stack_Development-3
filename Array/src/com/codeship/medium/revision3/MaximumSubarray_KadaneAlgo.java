package com.codeship.medium.revision3;

public class MaximumSubarray_KadaneAlgo {

	 public int maxSubArray(int[] nums) {
	        int len = nums.length;
	        int sum = 0;
	        int maxi = nums[0];
	        int i = 0;
	        while(i < len) {
	            sum += nums[i];
	            maxi = Math.max(maxi, sum);
	            if(sum < 0) {
	                //resetting the sum value
	                sum = 0;
	            }
	            i += 1;
	        }
	        return maxi;
	    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
