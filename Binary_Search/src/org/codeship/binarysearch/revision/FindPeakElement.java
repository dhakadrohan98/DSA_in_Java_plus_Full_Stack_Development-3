package org.codeship.binarysearch.revision;

public class FindPeakElement {
	
	//TC: O(logn)
    //SC: O(1)
    public int findPeakElement(int[] nums) {
         int n = nums.length; // Size of array

	        // Some Edge cases:
	        if (n == 1) return 0;
	        if (nums[0] > nums[1]) return 0;
	        if (nums[n-1] > nums[n-2]) return n - 1;

	        int low = 1, high = n - 2;
	        while (low <= high) {
	            int mid = (low + high) / 2;

	            // If arr[mid] is the peak:
	            if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1])
	                return mid;

	            // If we are in the left search space side:	
	            if (nums[mid] < nums[mid + 1]) 
                    low = mid + 1;

	            // If we are in the right search space side:
	            // Or, arr[mid] is a common point:
	            else if(nums[mid - 1] >= nums[mid])
                    high = mid - 1;
	        }
	        // Dummy return statement
	        return -1;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
