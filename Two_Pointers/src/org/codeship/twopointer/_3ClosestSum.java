package org.codeship.twopointer;

import java.util.Arrays;

public class _3ClosestSum {

	public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[nums.length-1];
        
        for(int i = 0; i <= nums.length-3; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            
            while(start < end) {
                int currSum = nums[i] + nums[start] + nums[end];
                if(currSum > target) {
                    end--;
                }
                else {
                    start++;
                }
                
                if(Math.abs(currSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currSum;
                }
            }
        }
        return closestSum;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
