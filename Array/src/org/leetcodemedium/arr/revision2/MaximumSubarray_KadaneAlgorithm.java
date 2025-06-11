package org.leetcodemedium.arr.revision2;

public class MaximumSubarray_KadaneAlgorithm {
	
	//TC: O(n)
    //SC: O(1)
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxi = nums[0];
        int currSum = 0;
        for(int num: nums) {
            currSum += num;
            maxi = Math.max(maxi, currSum);
            if(currSum < 0) {
                currSum = 0;
            }
        }
        return maxi;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
