package org.codeship.binarysearch.revision;

public class FindFirstAndLastPositionOfElementInSortedArray {
	
	//TC: O(2logn)
    //SC: O(1)
    public int findStarting(int[] nums, int n, int target) {
        int low = 0, high = n-1;
        int ans = -1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(nums[mid] == target) {
                ans = mid;
                //find left most side element
                high = mid - 1;
            } else if(nums[mid] < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public int findEnding(int[] nums, int n, int target) {
        int low = 0, high = n-1;
        int ans = -1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(nums[mid] == target) {
                ans = mid;
                 //find right most side element
                low = mid + 1;
            } else if(nums[mid] < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int startingPos = findStarting(nums, n, target);
        int endingPos = findEnding(nums, n, target);
        return new int[]{startingPos, endingPos};
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
