package org.codeship.binarysearch.revision;

public class BinarySearch {
	
	//TC: O(logn)
    //SC: O(1)
    public int search(int[] nums, int target) {
        int indx = -1;
        int n = nums.length;
        int low = 0, high = n-1;
        while(low <= high) {
            int mid = (low + high) / 2;
            //trim down to the right half space
            if(nums[mid] < target) {
                low = mid + 1;
            } else if(nums[mid] > target) {
                high = mid - 1;
            } else {
                indx = mid;
                break;
            }
        }
        return indx;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
