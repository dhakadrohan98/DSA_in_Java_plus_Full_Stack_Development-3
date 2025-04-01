package org.codeship.binarysearch.revision;

public class FindMinimumInRotatedSortedArray {

	// TC: O(logn)
	// SC: O(1)
	public int findMin(int[] nums) {
		int n = nums.length;
		int low = 0, high = n - 1;
		int ans = Integer.MAX_VALUE;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (nums[low] <= nums[mid]) {
				// left half is sorted
				// pick the minimum & eliminate the left half search space
				ans = Math.min(ans, nums[low]);
				low = mid + 1;
			} else if (nums[mid] <= nums[high]) {
				// right half is sorted
				// pick the minimum & eliminate the right half search space
				ans = Math.min(ans, nums[mid]);
				high = mid - 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
